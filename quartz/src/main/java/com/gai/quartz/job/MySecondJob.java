package com.gai.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Created by gaigiacoming on 2019/11/5.
 */
public class MySecondJob extends QuartzJobBean{
    private String name;
    public void setName(String name){
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hello:" + name + ":" + new Date());
    }
}
