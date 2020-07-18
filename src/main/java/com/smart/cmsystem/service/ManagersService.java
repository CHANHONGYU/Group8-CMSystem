package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.ManagerDto;
import com.smart.cmsystem.domain.entity.Managers;
import com.smart.cmsystem.exception.ServiceException;

import java.util.List;

public interface ManagersService {
    //显示列表
    List<Managers> queryAll();
    //关键字查询
    List<Managers> queryByKeyword(String keyword);
    //添加数据
    int addData(ManagerDto managerDto) throws ServiceException;
    //修改数据
    int modifyData(ManagerDto managerDto) throws ServiceException;
    //批量删除
    int DeleteInformation(int[] ints);

}
