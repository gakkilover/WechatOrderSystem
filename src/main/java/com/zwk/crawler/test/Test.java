package com.zwk.crawler.test;

import com.zwk.crawler.config.HttpClientDownloader;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-23 11:04
 * @ Description：
 */
public class Test  {
    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new SelfPageModelPipeling(), GithubRepo.class)

                .setDownloader(new HttpClientDownloader())
                .addUrl("https://github.com/code4craft").thread(5).run();
    }
}
