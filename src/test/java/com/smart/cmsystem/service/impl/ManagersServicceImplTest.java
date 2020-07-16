package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.entity.Managers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-mybatis.xml"})
public class ManagersServicceImplTest {
    @Resource
    ManagersServiceImpl managersService;
    @Test
    public void queryAll() {
        List<Managers> managers = managersService.queryAll();
        System.out.println(managers);
    }
}