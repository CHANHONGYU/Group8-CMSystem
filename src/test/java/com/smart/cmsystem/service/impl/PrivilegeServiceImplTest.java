package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.PrivilegeDto;
import com.smart.cmsystem.domain.entity.Privilege;
import com.smart.cmsystem.service.PrivilegeService;
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
public class PrivilegeServiceImplTest {
    @Resource
    PrivilegeService privilegeService;
    @Test
    public void queryAll() {
        List<Privilege> privileges = privilegeService.queryAll(0, 10);
        System.out.println(privileges);
    }
    @Test
    public void queryByk(){
        List<Privilege> privileges = privilegeService.queryByk("3");
        System.out.println(privileges);
    }
    @Test
    public void addDate(){
        PrivilegeDto privilegeDto =new PrivilegeDto();
        privilegeDto.setPCreationtime(new Date());
        privilegeDto.setPId(14);
        privilegeDto.setPLevel("987");
        privilegeDto.setPName("987");
        privilegeDto.setPRole("987");
        privilegeDto.setPState(1);
        int i = privilegeService.addDate(privilegeDto);
        System.out.println(i);
    }
    @Test
    public void deleteById(){
        int[] ints = {1,2};
        int i = privilegeService.deleteById(ints);
        System.out.println(i);
    }
}