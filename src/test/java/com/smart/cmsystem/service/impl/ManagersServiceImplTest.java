package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.ManagerDto;
import com.smart.cmsystem.domain.entity.Managers;
import com.smart.cmsystem.service.ManagersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-mybatis.xml"})
public class ManagersServiceImplTest {
    @Resource
    ManagersService managersService;
    @Test
    public void queryByKeyword() {
        List<Managers> list = managersService.queryByKeyword("超");
        System.out.println(list);
    }
    @Test
    public void addData(){
        ManagerDto managerDto =new ManagerDto();
        managerDto.setMEmils("654");
        managerDto.setMJoiningtime(new Date());
        managerDto.setMName("654");
        managerDto.setMPassword("56745");
        managerDto.setMPhone(15456757);
        managerDto.setMRole("普通");
        managerDto.setMState(1);
        int i = managersService.addData(managerDto);
        System.out.println(i);
    }
    @Test
    public void modifyData(){
        ManagerDto managerDto= new ManagerDto();
        managerDto.setMPhone(15456757);
        managerDto.setMRole("普通");
        managerDto.setMId(7);
        int i = managersService.modifyData(managerDto);
        System.out.println(i);
    }
}