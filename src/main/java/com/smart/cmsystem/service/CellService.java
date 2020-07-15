package com.smart.cmsystem.service;



import com.smart.cmsystem.domain.entity.Cell;

import java.util.List;

public interface CellService {
    //查
    List<Cell> queryAll(int page, int size);
    //改状态
    int modifyByState(int state, int cid);
    //删
    int removeData(int cid);
    //关键查
    List<Cell> querykeywords(String keywords);
    //修改
    int RevisedContent(Cell cell);
    //添加
    int setupData(Cell cell);
    //批量删除
    int BatchDeletion(int[] ints);

}
