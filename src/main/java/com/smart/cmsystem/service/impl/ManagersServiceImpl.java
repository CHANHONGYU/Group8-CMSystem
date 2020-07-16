package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.ManagerDto;
import com.smart.cmsystem.domain.entity.Managers;
import com.smart.cmsystem.mapper.ManagersMapper;
import com.smart.cmsystem.service.ManagersService;
import com.smart.cmsystem.utils.RUtity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagersServiceImpl implements ManagersService {
    @Resource
    ManagersMapper managersMapper;
    @Override
    public List<Managers> queryAll() {
        List<Managers> managers = managersMapper.selectALL();
        return managers;
    }

    @Override
    public List<Managers> queryByKeyword(String keyword) {
        List<Managers> managers = managersMapper.selectByKeyword(keyword);

        return managers;
    }

    @Override
    public int addData(ManagerDto managerDto) {
        Managers managers= new Managers();
        if(managerDto!=null){
            BeanUtils.copyProperties(managerDto,managers);
        }
        int insert = managersMapper.insert(managers);
        return insert;
    }

    @Override
    public int modifyData(ManagerDto managerDto) {
        Managers managers = new Managers();
        BeanUtils.copyProperties(managerDto,managers);
        int i = managersMapper.updateByField(managers);
        return i;
    }

    @Override
    public int DeleteInformation(int[] ints) {
        int i = managersMapper.updateByDel(ints);
        return i;
    }
}
