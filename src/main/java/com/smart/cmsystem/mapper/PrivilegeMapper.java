package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.Privilege;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrivilegeMapper {
    //列表显示
    List<Privilege> selectAll(@Param("page") int page,@Param("size") int size);

    //查询
    List<Privilege> selectBykeyword(@Param("keyword") String keyword);

    //修改
    int updateByZd(@Param("context") Privilege privilege);

    //添加
    int insertdate(@Param("privil") Privilege privilege);
    //删除
    int updatebydel(@Param("del") int[] del);


}