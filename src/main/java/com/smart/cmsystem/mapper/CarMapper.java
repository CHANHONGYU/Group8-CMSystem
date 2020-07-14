package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.Car;

public interface CarMapper {
    int deleteByPrimaryKey(Integer carId);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer carId);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}