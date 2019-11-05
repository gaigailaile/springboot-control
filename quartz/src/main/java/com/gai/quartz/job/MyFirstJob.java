package com.gai.quartz.job;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by gaigaicoming on 2019/11/5.
 */
@Component
public class MyFirstJob {
    public void sayHello(){
        System.out.println("MyFirstJob:sayHello:" + new Date());
    }
}
