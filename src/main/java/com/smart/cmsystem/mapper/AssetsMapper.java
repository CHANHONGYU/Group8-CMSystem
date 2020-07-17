package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Assets;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssetsMapper {
    int deleteByPrimaryKey(Integer assetsId);

    int insert(Assets record);

    int insertSelective(Assets record);

    Assets selectByPrimaryKey(Integer assetsId);

    int updateByPrimaryKeySelective(Assets record);

    int updateByPrimaryKey(Assets record);

    List<Assets> selectAllByDate(@Param("search") Search search);

    List<Assets> selectAll();
}