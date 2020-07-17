package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Owner;
import com.smart.cmsystem.exception.DaoException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OwnerMapper {
    //根据id假删除业主信息
    int deleteByPrimaryKey(Integer ownerId) throws DaoException;
    //添加业主信息
    int insert(Owner record) throws DaoException;
    //动态添加业主信息
    int insertSelective(Owner record) throws DaoException;
    //根据id查询相应业主信息表
    Owner selectByPrimaryKey(Integer ownerId) throws DaoException;
    //根据id动态更新业主信息
    int updateByPrimaryKeySelective(Owner record) throws DaoException;
    //根据id更新业主信息
    int updateByPrimaryKey(Owner record) throws DaoException;
    //获取所有业主信息
    List<Owner> selectAll() throws DaoException;
    //根据日期和关键字查询业主
    List<Owner> selectAllByDate(@Param("search") Search search) throws DaoException;

}