package com.zwk.weibo;


import com.zwk.crawler.config.HttpClientDownloader;
import com.zwk.crawler.test.DoubanProcessor;
import com.zwk.crawler.test.TestPageProcessor;
import com.zwk.weibo.service.FoodService;
import com.zwk.weibo.service.UserService;
import com.zwk.weibo.utils.CacheData;
import com.zwk.weibo.utils.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-02 09:13
 * @ Description：
 */
@Component
public class InitApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private FoodService foodService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        CacheData cacheData=new CacheData();
        cacheData.refreshCache();
        startCrawler();
    }

    //启动爬虫
    private void startCrawler(){
        Spider.create(new DoubanProcessor())
                .addUrl("https://www.douban.com/doulist/3907668/")  //设置爬的url
                .addPipeline(new ConsolePipeline()) //会output到控制台...在这里并不需要,因为持久化到数据库了
                .thread(5)
                .run();
    }


}
