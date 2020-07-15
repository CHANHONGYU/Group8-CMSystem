package com.smart.cmsystem.mapper;


import com.smart.cmsystem.domain.entity.Cell;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CellMapper {
    //全查
    List<Cell> seritesAll(@Param("page") int page, @Param("size") int size);
    //修改状态
    int selectByState(@Param("state") int state, @Param("cid") int cid);
    //单删除
    int updateByPrimaryKey(@Param("cid") int cid);
    //添加
    int insertCell(@Param("cells") Cell cell);
    //关键字查询
    List<Cell> selectBykeyword(@Param("keyword") String keyword);
    //修改
    int updataByContent(@Param("content") Cell content);
    //批量删除
    int updataByArray(@Param("ids") int[] ids);

}