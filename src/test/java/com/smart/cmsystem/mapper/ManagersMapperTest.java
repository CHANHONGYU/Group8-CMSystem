package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.dto.ManagerDto;
import com.smart.cmsystem.domain.entity.Managers;
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
public class ManagersMapperTest {
@Resource
ManagersMapper managersMapper;
    @Test
    public void selectALL() {
        List<Managers> managers = managersMapper.selectALL();
        System.out.println(managers);
    }

    @Test
    public void selectByKeyword() {
        List<Managers> list = managersMapper.selectByKeyword("超");
        System.out.println(list);
    }
    @Test
    public void insert(){
        Managers managerDto = new Managers();
        managerDto.setMEmils("987");
        managerDto.setMJoiningtime(new Date());
        managerDto.setMName("987");
        managerDto.setMPassword("1355468");
        managerDto.setMPhone(157687457);
        managerDto.setMRole("超级");
        managerDto.setMState(1);
        int insert = managersMapper.insert(managerDto);
        System.out.println(insert);
    }
    @Test
    public void updateByField(){
        Managers managerDto = new Managers();
        managerDto.setMId(7);
        managerDto.setMEmils("987");
        managerDto.setMJoiningtime(new Date());
        managerDto.setMName("987");
        int i = managersMapper.updateByField(managerDto);
        System.out.println(i);
    }
    @Test
    public void updateByDel(){
        int[] ints = {7,8,9};
        int i = managersMapper.updateByDel(ints);
    }
}