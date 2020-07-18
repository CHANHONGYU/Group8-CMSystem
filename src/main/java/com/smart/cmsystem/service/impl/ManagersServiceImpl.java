package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.ManagerDto;
import com.smart.cmsystem.domain.entity.Managers;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.mapper.ManagersMapper;
import com.smart.cmsystem.service.ManagersService;
import com.smart.cmsystem.utils.ErrorStatus;
import com.smart.cmsystem.utils.RUtity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagersServiceImpl implements ManagersService {
    @Resource
    ManagersMapper managersMapper;
    //查询列表
    @Override
    public List<Managers> queryAll() throws SecurityException{
        List<Managers> managers = managersMapper.selectALL();
        return managers;
    }
    //关键字查询
    @Override
    public List<Managers> queryByKeyword(String keyword) throws SecurityException{
        List<Managers> managers = managersMapper.selectByKeyword(keyword);

        return managers;
    }
    //添加数据
    @Override
    public int addData(ManagerDto managerDto) throws ServiceException{
        Managers managers= new Managers();
        if(managerDto==null){
            throw new ServiceException(ErrorStatus.SERVICE_ERROR);
        }
        int insert = managersMapper.insert(managers);
        return insert;
    }
    //修改数据
    @Override
    public int modifyData(ManagerDto managerDto) throws ServiceException {
        Managers managers = new Managers();
        if(managerDto==null){
            throw new ServiceException(ErrorStatus.SERVICE_ERROR);
        }
        BeanUtils.copyProperties(managerDto,managers);
        int i = managersMapper.updateByField(managers);
        return i;
    }
    //删除数据
    @Override
    public int DeleteInformation(int[] ints) throws SecurityException{
        
        int i = managersMapper.updateByDel(ints);
        return i;
    }
}
