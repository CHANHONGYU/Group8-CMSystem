package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.Usergroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsergroupMapper {
    //显示列表
    List<Usergroup> selectAll();
    //关键字查询
    List<Usergroup> selectByKeyword(@Param("keyword") String keyword);
    //修改
    int updateXinx(@Param("ug") Usergroup usergroup);
    //添加
    int insertDate(@Param("ug") Usergroup usergroup);
    //删除
    int  updateBydetele(@Param("ints") int[] ints);


}