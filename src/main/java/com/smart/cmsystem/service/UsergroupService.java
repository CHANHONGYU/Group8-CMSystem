package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.UsergroupDto;
import com.smart.cmsystem.domain.entity.Usergroup;

import java.util.List;

public interface UsergroupService {
    List<Usergroup> query();

    List<Usergroup>  queryBykeyword(String keyword);

    int  modify(UsergroupDto usergroupDto);

    int  addDate(UsergroupDto usergroupDto);

    int  deteleDate(int[] ints);
}
