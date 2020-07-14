package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Owner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OwnerMapper {
    int deleteByPrimaryKey(Integer ownerId);

    int insert(Owner record);

    int insertSelective(Owner record);

    Owner selectByPrimaryKey(Integer ownerId);

    int updateByPrimaryKeySelective(Owner record);

    int updateByPrimaryKey(Owner record);

    /**
     * 返回所有业主信息
     * @return
     */
    List<Owner> selectAll();

    List<Owner> selectAllByDate(@Param("search")Search search);

}