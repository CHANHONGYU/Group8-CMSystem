package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.Privilege;
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
public class PrivilegeMapperTest {
    @Resource
    PrivilegeMapper privilegeMapper;
    @Test
    public void selectBykeyword() {
        List<Privilege> privileges = privilegeMapper.selectBykeyword("2");
        System.out.println(privileges);
    }
    @Test
    public void updateByZd(){
        Privilege privilege = new Privilege();
        privilege.setPCreationtime(new Date());
        privilege.setPId(14);
        privilege.setPLevel("987");
        privilege.setPName("987");
        privilege.setPRole("987");
        privilege.setPState(0);
        int i = privilegeMapper.updateByZd(privilege);
        System.out.println(i);
    }
}