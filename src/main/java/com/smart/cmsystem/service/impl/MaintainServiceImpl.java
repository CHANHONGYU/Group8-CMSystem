package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.MaintainDto;
import com.smart.cmsystem.domain.entity.Maintain;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.mapper.MaintainMapper;
import com.smart.cmsystem.service.MaintainService;
import com.smart.cmsystem.utils.ErrorStatus;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class MaintainServiceImpl implements MaintainService {
    @Resource
    MaintainMapper maintainMapper;


    @Override
    public List<MaintainDto> selectAllByKey(String keyword, String startTime, String endTime, int limit, int offset) throws ServiceException {

        List<Maintain> maintains = maintainMapper.selectAllByKey(keyword, startTime, endTime, (limit - 1) * offset, offset);
        if (maintains.size()==0){
            return null;
        }
        List<MaintainDto> maintainDtos =new ArrayList<>();

        for (Maintain maintain : maintains) {
            MaintainDto maintainDto =new MaintainDto();
            BeanUtils.copyProperties(maintain, maintainDto);
            maintainDtos.add(maintainDto);
        }
        return maintainDtos;
    }

    @Override
    @Transactional
    public ResponseEntity<Integer> deleteMaintain(List<Integer> mids) throws ServiceException{
        int i = maintainMapper.deleteMaintain(mids);
            if (i==mids.size()){
                return ResponseEntity.success(i);
            }else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.error();
            }
    }

    @Override
    public ResponseEntity insertMaintain(MaintainDto maintainDto) {
        Maintain maintain=new Maintain();
        BeanUtils.copyProperties(maintainDto,maintain);
        int i = maintainMapper.insertMaintain(maintain);
        if (i==1) {
           return ResponseEntity.success(i);
        }else {
           return ResponseEntity.error();
        }

    }

    @Override
    public ResponseEntity updateMaintain(MaintainDto maintainDto) {
        Maintain maintain=new Maintain();
        BeanUtils.copyProperties(maintainDto,maintain);
        int i = maintainMapper.updateMaintain(maintain);
        if (i==1){
            return ResponseEntity.success(i);
        }
        else return ResponseEntity.error();
    }
}
