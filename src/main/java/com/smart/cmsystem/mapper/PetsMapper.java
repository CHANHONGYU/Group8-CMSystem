package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Pets;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PetsMapper {
    int deleteByPrimaryKey(Integer petsId);

    int insert(Pets record);

    int insertSelective(Pets record);

    Pets selectByPrimaryKey(Integer petsId);

    int updateByPrimaryKeySelective(Pets record);

    int updateByPrimaryKey(Pets record);

    List<Pets> selectAllByDate(@Param("search")Search search);

    List<Pets> selectAll();
}