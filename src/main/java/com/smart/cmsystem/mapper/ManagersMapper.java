package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.dto.ManagerDto;
import com.smart.cmsystem.domain.entity.Managers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagersMapper {
    //查询所有
    List<Managers> selectALL();
    //关键字查询
    List<Managers> selectByKeyword(@Param("keyword") String keyword);
    //添加
    int insert(@Param("man") Managers managers);
    //修改
    int updateByField(@Param("field") Managers managers);
    //批量删除
    int updateByDel(@Param("ints") int[] ints);
}