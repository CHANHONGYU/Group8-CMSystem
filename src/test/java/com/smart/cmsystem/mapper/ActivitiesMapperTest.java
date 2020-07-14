package com.smart.cmsystem.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-mybatis.xml"})
public class ActivitiesMapperTest {
@Resource
ActivitiesMapper activitiesMapper;
    @Test
    public void selectAll() {
        activitiesMapper.selectAll("","2020-07-13","",0,10);
    }
}