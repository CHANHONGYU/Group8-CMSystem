package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.PrivilegeDto;
import com.smart.cmsystem.domain.entity.Privilege;

import java.util.List;

public interface PrivilegeService {

    List<Privilege> queryAll(int page,int size);


    List<Privilege> queryByk(String keyword);

    int modify(PrivilegeDto privilegeDto);

    int addDate(PrivilegeDto privilegeDto);

    int deleteById(int[] pid);
}
