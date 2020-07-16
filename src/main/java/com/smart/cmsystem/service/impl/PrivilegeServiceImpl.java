package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.PrivilegeDto;
import com.smart.cmsystem.domain.entity.Privilege;
import com.smart.cmsystem.mapper.PrivilegeMapper;
import com.smart.cmsystem.service.PrivilegeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Resource
    PrivilegeMapper privilegeMapper;
    @Override
    public List<Privilege> queryAll(int page, int size) {
        List<Privilege> privileges = privilegeMapper.selectAll((page-1)*size, size);
        return privileges;
    }

    @Override
    public List<Privilege> queryByk(String keyword) {
        List<Privilege> privileges = privilegeMapper.selectBykeyword(keyword);
        return privileges;
    }

    @Override
    public int modify(PrivilegeDto privilegeDto) {
        Privilege privilege=new Privilege();
        BeanUtils.copyProperties(privilegeDto,privilege);
        int i = privilegeMapper.updateByZd(privilege);
        return i;
    }

    @Override
    public int addDate(PrivilegeDto privilegeDto) {
        Privilege privilege = new Privilege();
        BeanUtils.copyProperties(privilegeDto,privilege);
        int insertdate = privilegeMapper.insertdate(privilege);
        return insertdate;
    }

    @Override
    public int deleteById(int[] pid) {
        int updatebydel = privilegeMapper.updatebydel(pid);
        return updatebydel;
    }
}
