package com.smart.cmsystem.service.impl;


import com.smart.cmsystem.domain.dto.CellDto;
import com.smart.cmsystem.domain.entity.Cell;
import com.smart.cmsystem.mapper.CellMapper;
import com.smart.cmsystem.service.CellService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class CellServiceImpl implements CellService {
    @Resource
    CellMapper cellMapper;



    @Override
    public List<Cell> queryAll(int page, int size) {
        List<Cell> cells = cellMapper.seritesAll(page, size);
        return cells;
    }

    @Override
    public int modifyByState( int state,int cid) {
        int i = cellMapper.selectByState(state,cid);
        return i;
    }

    @Override
    public int removeData(int cid) {
        int i = cellMapper.updateByPrimaryKey(cid);
        return i;
    }

    @Override
    public List<Cell> querykeywords(String keywords) {
        List<Cell> cells = cellMapper.selectBykeyword(keywords);
        return cells;
    }

    @Override
    public int RevisedContent(CellDto cellDto) {
        Cell cell = new Cell();
        if (cellDto!=null){
            /**
             * 第一个是被复制的，第二个是接受的
             */
            BeanUtils.copyProperties(cellDto,cell);
            }
        int i = cellMapper.updataByContent(cell);
        return i;
    }

    @Override
    public int setupData(CellDto cellDto) {
        Cell cell = new Cell();
        if (cellDto!=null){
            if(cellDto.getCCreationtime()==null){
                cellDto.setCCreationtime(new Date());
            }
            BeanUtils.copyProperties(cellDto,cell);
        }
        int i = cellMapper.insertCell(cell);
        return i;
    }

    @Override
    public int BatchDeletion(int[] ints) {
        int i = cellMapper.updataByArray(ints);
        return i;
    }
}
