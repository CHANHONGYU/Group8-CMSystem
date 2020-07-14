package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.entity.Activities;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-mybatis.xml"})
public class ActivitiesServiceTest {
    @Resource
    ActivitiesService activitiesService;

//    String keyword,String startTime,String endTime,int limit,int offset
    @Test
    public void activitiesList() {
        activitiesService.ActivitiesList("","2020-07-13","",0,10);
    }
}