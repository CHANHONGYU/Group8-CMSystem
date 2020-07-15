package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.ActivitiesDto;
import com.smart.cmsystem.domain.entity.Activities;
import com.smart.cmsystem.utils.ResponseEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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



    @Test
    public void deleteActivities() throws Exception {
        List<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        ResponseEntity responseEntity = activitiesService.deleteActivities(list);
    }
    @Test
    public void  saveActivities() throws ParseException {
        ActivitiesDto actDto=new ActivitiesDto();
        actDto.setTheme("跳舞");
        actDto.setCommunity("金华万府");
        actDto.setLocation("万府广场");
        actDto.setOrganizers("万府物业");
        SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
        String sd="2020-04-15";
        String en="2020-05-01";
        actDto.setStartTime(dateFormat.parse(sd));
        actDto.setEndTime(dateFormat.parse(en));
        actDto.setStatus(1);
        System.out.println(actDto);
        ResponseEntity responseEntity = activitiesService.saveActivities(actDto);
        System.out.println(responseEntity.toString());

//        3,五一晚会,金华万府,万府广场,万府物业,2020-04-15 00:00:00,2020-05-01 23:59:59,2020-07-14 15:22:51,3,0


    }
}