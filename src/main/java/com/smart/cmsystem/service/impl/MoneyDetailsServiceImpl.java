package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.HousingDto;
import com.smart.cmsystem.domain.dto.MoneyDetailDto;
import com.smart.cmsystem.domain.entity.MoneyDetail;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.mapper.MoneyDetailMapper;
import com.smart.cmsystem.service.MoneyDetailService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MoneyDetailsServiceImpl implements MoneyDetailService {
    @Resource
    MoneyDetailMapper moneyDetailMapper;
    //插入字段
    @Override
    public ResponseEntity insertMoneyDetail(MoneyDetailDto moneyDetailDto) {
        MoneyDetail moneyDetail = new MoneyDetail();
        BeanUtils.copyProperties(moneyDetailDto ,moneyDetail);
        int insert = moneyDetailMapper.insert(moneyDetail);
        if (insert == 1) {
            return  ResponseEntity.success(insert);
        }
        return  ResponseEntity.error();
    }

    @Override
    public ResponseEntity alterMoneyDetailDto(MoneyDetailDto moneyDetailDto) {
        MoneyDetail moneyDetail = new MoneyDetail();
        BeanUtils.copyProperties(moneyDetailDto ,moneyDetail);
        int update = moneyDetailMapper.update(moneyDetail);
        if (update == 1) {
            System.out.println(update);
            return ResponseEntity.success(update);
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity delMoneyDetail(int mdId) {
        int delete = moneyDetailMapper.delete(mdId);
        if (delete == 1) {
            return  ResponseEntity.success(delete);
        }
        return  ResponseEntity.error();
    }

    @Override
    public ResponseEntity delMoneyDetails(List<Integer> mdIds) throws ServiceException {
        int i = moneyDetailMapper.deleteMoneyDetail(mdIds);
        if (i == mdIds.size()) {
            return  ResponseEntity.success(i);
        }else{
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return  ResponseEntity.error();

    }

    @Override
    public List<MoneyDetailDto> findAll(String keyWord, String updateTime, String createTime, String endingTime, int limit, int offset) throws ServiceException {
        List<MoneyDetail> moneyDetails =moneyDetailMapper.selectAll(keyWord, updateTime, createTime, endingTime, (limit- 1) * offset, offset);
        if (moneyDetails.size() ==0) {
            return  null;
        }else{
            List<MoneyDetailDto> moneyDetailDtos =new ArrayList<>();
            for (MoneyDetail moneyDetail:moneyDetails) {
                MoneyDetailDto moneyDetailDto = new MoneyDetailDto();
                BeanUtils.copyProperties(moneyDetailDto ,moneyDetail);
                moneyDetailDtos.add(moneyDetailDto);
            }
            return  moneyDetailDtos;
        }


    }
}
