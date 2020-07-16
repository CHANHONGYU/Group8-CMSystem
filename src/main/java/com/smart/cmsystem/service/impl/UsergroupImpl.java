package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.UsergroupDto;
import com.smart.cmsystem.domain.entity.Usergroup;
import com.smart.cmsystem.mapper.UsergroupMapper;
import com.smart.cmsystem.service.UsergroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UsergroupImpl implements UsergroupService {
    @Resource
    UsergroupMapper usergroupMapper;

    @Override
    public List<Usergroup> query() {
        List<Usergroup> usergroups = usergroupMapper.selectAll();
        return usergroups;
    }

    @Override
    public List<Usergroup> queryBykeyword(String keyword) {
        List<Usergroup> usergroups = usergroupMapper.selectByKeyword(keyword);
        return usergroups;
    }

    @Override
    public int modify(UsergroupDto usergroupDto) {
        Usergroup usergroup1 = new Usergroup();
        BeanUtils.copyProperties(usergroupDto,usergroup1);
        int i = usergroupMapper.updateXinx(usergroup1);
        return i;
    }

    @Override
    public int addDate(UsergroupDto usergroupDto) {
        Usergroup usergroup = new Usergroup();
        BeanUtils.copyProperties(usergroupDto,usergroup);
        int i = usergroupMapper.insertDate(usergroup);
        return i;
    }

    @Override
    public int deteleDate(int[] ints) {
        int i = usergroupMapper.updateBydetele(ints);
        return i;
    }
}
