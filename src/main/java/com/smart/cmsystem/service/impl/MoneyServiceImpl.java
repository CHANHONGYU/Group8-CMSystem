package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.MoneyDto;
import com.smart.cmsystem.domain.entity.Money;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.mapper.MoneyMapper;
import com.smart.cmsystem.service.MoneyService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/*
项目的类
 */
@Service
public class MoneyServiceImpl implements MoneyService {
    @Resource
    MoneyMapper moneyMapper;
    //增加的业务
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity insertMoney(MoneyDto moneyDto) {
        Money money = new Money();
        BeanUtils.copyProperties(moneyDto,money);
        int insert = moneyMapper.insert(money);
        if (insert == 1) {
            return  ResponseEntity.success(insert);
        }
        return  ResponseEntity.error();
    }
//修改
    @Override
    public ResponseEntity alterMoney(MoneyDto moneyDto) {
        Money money = new Money();
        BeanUtils.copyProperties(moneyDto,money);
        int update = moneyMapper.update(money);
        if (update == 1){
            return  ResponseEntity.success(update);
        }
        return  ResponseEntity.error();
    }

    @Override
    public ResponseEntity delMoney(int mId) {
        int delete = moneyMapper.delete(mId);
        if (delete == 1) {
            return  ResponseEntity.success(delete);
        }
        return ResponseEntity.error();
    }

    @Override
    public ResponseEntity deleteMoneys(List<Integer> mIds) throws ServiceException {
        int i = moneyMapper.deleteMoneys(mIds);
        if (i == mIds.size()) {
            return ResponseEntity.success(i);
        }else{
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }
        return  ResponseEntity.error();
    }
//显示全部的页面
    @Override
    public List<MoneyDto> findAll(String keyWord, String createTime, String endingTime, int limit, int offset) throws ServiceException {
   List<Money> moneyList=    moneyMapper.selectAll( keyWord, createTime, endingTime, (limit - 1) * offset, offset);
        if (moneyList.size() ==0 ) {
            return  null;
        }else{
            List<MoneyDto> moneyDtos =new ArrayList<>();
            for (Money money:moneyList) {
                MoneyDto moneyDto = new MoneyDto();
                BeanUtils.copyProperties(money,moneyDtos);
                moneyDtos.add(moneyDto);
            }
            return  moneyDtos;
        }


    }
}
