package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.ManagerDto;
import com.smart.cmsystem.domain.entity.Managers;

import java.util.List;

public interface ManagersService {
    List<Managers> queryAll();

    List<Managers> queryByKeyword(String keyword);

    int addData(ManagerDto managerDto);

    int modifyData(ManagerDto managerDto);

    int DeleteInformation(int[] ints);

}
