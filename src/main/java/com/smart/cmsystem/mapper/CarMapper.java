package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    int deleteByPrimaryKey(Integer carId);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer carId);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    List<Car> selectAllByDate(@Param("search")Search search);

    List<Car> selectAll();
}