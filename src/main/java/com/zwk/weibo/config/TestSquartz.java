package com.zwk.weibo.config;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-18 15:02
 * @ Description：编写 quartz 定时任务
 */
public class TestSquartz extends QuartzJobBean {

    @Autowired
    private MqTestSender sender;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz task "+new Date());
        sender.send();
    }
}
