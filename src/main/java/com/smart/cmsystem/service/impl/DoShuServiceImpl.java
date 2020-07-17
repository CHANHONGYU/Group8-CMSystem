package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.DoShuDto;
import com.smart.cmsystem.domain.dto.HousingDto;
import com.smart.cmsystem.domain.entity.DoShu;
import com.smart.cmsystem.domain.entity.Housing;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.mapper.DoShuMapper;
import com.smart.cmsystem.service.DoShuService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class DoShuServiceImpl implements DoShuService {
    @Resource
    DoShuMapper doShuMapper;
    @Override
    //插入字段
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity insertDoShu(DoShuDto doShuDto) {
        DoShu doShu = new DoShu();
        BeanUtils.copyProperties(doShuDto,doShu);
        int insert = doShuMapper.insert(doShu);
        if (insert == 1) {
            return  ResponseEntity.success(insert);
        }
        return ResponseEntity.error();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity alterDoShu(DoShuDto doShuDto) {

        DoShu doShu = new DoShu();
        BeanUtils.copyProperties(doShuDto,doShu);
        int update = doShuMapper.update(doShu);
        if (update == 1) {
            return  ResponseEntity.success(update);
        }
        return ResponseEntity.error();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity delDoShu(int dId) {
        int delete = doShuMapper.delete(dId);
        if (delete == 1) {
            return ResponseEntity.success(delete);
        }
        return  ResponseEntity.error();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity delDoShuAll(List<Integer> dIds) throws ServiceException {
        int i = doShuMapper.deleteDoShus(dIds);
        if (i == dIds.size()) {
            return  ResponseEntity.success(i);
        }else{
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return  ResponseEntity.error();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<DoShuDto> findAll(String keyWord, String createTime, String endingTime, int limit, int offset) throws ServiceException {
        //根据关键字搜索
        List<DoShu> doShus = doShuMapper.selectAll(keyWord, createTime, endingTime, (limit - 1) * offset, offset);
        if (doShus.size()==0) {
            return  null;
        }else{
            List<DoShuDto> doShuDtoArrayList =new ArrayList<>();
            for (DoShu doShu:doShus) {
                DoShuDto doShuDto = new DoShuDto();
                BeanUtils.copyProperties(doShu,doShuDto);
                doShuDtoArrayList.add(doShuDto);
            }
            return  doShuDtoArrayList ;
        }

    }
}
