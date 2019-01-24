package com.zwk.crawler.test;

import com.zwk.weibo.entity.CommentEntity;
import com.zwk.weibo.service.CommentService;
import com.zwk.weibo.service.impl.CommentServiceImpl;
import com.zwk.weibo.utils.SpringContextUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class DoubanProcessor implements PageProcessor {
    private Site site = Site.me().setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:56.0) Gecko/20100101 Firefox/56.0").setRetryTimes(3).setSleepTime(1000);

    private CommentService commentService=(CommentServiceImpl) SpringContextUtils.getBean("commentService");

    @Override
    public void process(Page page) {
        List<String> titles = page.getHtml().xpath("//div[@class='title']/a/text()").all(); //这是匹配标题
        List<String> movieUrls = page.getHtml().xpath("//div[@class='post']/a").links().all(); //这是匹配电影url
        List<String> ratings = page.getHtml().xpath("//div[@class='rating']/span[@class='rating_nums']/text()").all(); //这是匹配评分
        List<String> attrFields = page.getHtml().xpath("//div[@class='abstract']").all(); //这是匹配下方的abstract标签里的属性项
        for (int i = 0; i < titles.size(); i++) { //循环存储到数据库
            CommentEntity entity=new CommentEntity();
            entity.setCommentDiscreption(titles.get(i));
            entity.setStatusCd(movieUrls.get(i));
            commentService.insertComment(entity);
//            doubanList.setTitle(titles.get(i));
//            doubanList.setMovieUrl(movieUrls.get(i));
//            doubanList.setRating(ratings.get(i));
//            String[] movieAttrs = attrFields.get(i).split("<br>");
//            if(movieAttrs.length>4) {
//                doubanList.setDirector(movieAttrs[0].substring(23).trim());
//                doubanList.setActor(movieAttrs[1].trim());
//                doubanList.setType(movieAttrs[2].trim());
//                doubanList.setTime(movieAttrs[4].substring(0, 9).trim());
//            }else {
//                doubanList.setDirector(attrFields.get(i));
//            }
//            DoubanListDao.save(doubanList);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new DoubanProcessor())
                .addUrl("https://www.douban.com/doulist/3907668/")  //设置爬的url
                .addPipeline(new ConsolePipeline()) //会output到控制台...在这里并不需要,因为持久化到数据库了
                .thread(5)
                .run();
    }
}