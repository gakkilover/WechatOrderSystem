package com.zwk.crawler.test;

import com.zwk.crawler.config.HttpClientDownloader;
import com.zwk.weibo.entity.CommentEntity;
import com.zwk.weibo.service.CommentService;
import com.zwk.weibo.service.impl.CommentServiceImpl;
import com.zwk.weibo.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;


public class TestPageProcessor implements PageProcessor {


    private CommentService commentService=(CommentServiceImpl) SpringContextUtils.getBean("commentService");

    //1.抓取网站的 相关配置，包括编码，抓取间隔，重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private static List<Page> pageList=new ArrayList<>();

    // process 是定制爬虫逻辑的核心接口，编写抽取逻辑
    @Override
    public void process(Page page) {
        //2.定义如何抽取页面信息并保存下来
        pageList.add(page);
        String author=page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString();
        String name=page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString();
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        CommentEntity commentEntity=new CommentEntity();
        commentEntity.setCommentDiscreption(author);
        commentEntity.setStatusCd(name);
        commentService.insertComment(commentEntity);
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        //从页面发现后续的url地址来抓取
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new TestPageProcessor())
                .setDownloader(new HttpClientDownloader())
                .addUrl("https://github.com/code4craft")//开始爬取的界面
                .thread(1)
                .run();
    }

}