package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.Pets;

public interface PetsMapper {
    int deleteByPrimaryKey(Integer petsId);

    int insert(Pets record);

    int insertSelective(Pets record);

    Pets selectByPrimaryKey(Integer petsId);

    int updateByPrimaryKeySelective(Pets record);

    int updateByPrimaryKey(Pets record);
}