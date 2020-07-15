package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.MoneyDetail;

public interface MoneyDetailMapper {
    int deleteByPrimaryKey(Integer monDetId);

    int insert(MoneyDetail record);

    int insertSelective(MoneyDetail record);

    MoneyDetail selectByPrimaryKey(Integer monDetId);

    int updateByPrimaryKeySelective(MoneyDetail record);

    int updateByPrimaryKey(MoneyDetail record);
}