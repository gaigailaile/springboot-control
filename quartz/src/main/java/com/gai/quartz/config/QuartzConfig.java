package com.gai.quartz.config;

import com.gai.quartz.job.MySecondJob;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

/**
 * Created by gaigaicoming on 2019/11/5.
 */
@Configuration
public class QuartzConfig {
    @Bean
    MethodInvokingJobDetailFactoryBean jobDetail1(){
        MethodInvokingJobDetailFactoryBean bean =
                new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("myFirstJob");
        bean.setTargetMethod("sayHello");
        return bean;
    }

    @Bean
    JobDetailFactoryBean jobDetail2(){
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(MySecondJob.class);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("name","sang");
        bean.setJobDataMap(jobDataMap);
        bean.setDurability(true);
        return bean;
    }

    @Bean
    SimpleTriggerFactoryBean simpleTrigger(){
        SimpleTriggerFactoryBean simpleTrigger =
                new SimpleTriggerFactoryBean();
        simpleTrigger.setJobDetail(jobDetail1().getObject());
        simpleTrigger.setRepeatCount(3);
        simpleTrigger.setStartDelay(1000);
        simpleTrigger.setRepeatInterval(2000);
        return simpleTrigger;
    }

    @Bean
    CronTriggerFactoryBean cronTrigger(){
        CronTriggerFactoryBean cronTrigger =
                new CronTriggerFactoryBean();
        cronTrigger.setJobDetail(jobDetail2().getObject());
        cronTrigger.setCronExpression("* * * * * ?");
        return cronTrigger;
    }

    @Bean
    SchedulerFactoryBean schedulerFactory(){
        SchedulerFactoryBean schedulerFactory =
                new SchedulerFactoryBean();
        SimpleTrigger simpleTrigger = simpleTrigger().getObject();
        CronTrigger cronTrigger = cronTrigger().getObject();
        schedulerFactory.setTriggers(simpleTrigger,cronTrigger);
        return schedulerFactory;
    }
}
