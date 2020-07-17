package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.HousingDto;
import com.smart.cmsystem.domain.entity.Housing;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.mapper.HousingMapper;
import com.smart.cmsystem.service.HousingService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class HousingServiceImpl implements HousingService {
    @Resource
    HousingMapper housingMapper;
    //插入字段
    @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity insertHousing(HousingDto housingDto) {
        Housing housing = new Housing();
        BeanUtils.copyProperties(housingDto,housing);
        int insert = housingMapper.insert(housing);
        if (insert == 1) {
            return  ResponseEntity.success(insert);
        }
        return ResponseEntity.error();
    }
//修改
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity alterHousing(HousingDto housingDto) {
        Housing housing = new Housing();
        BeanUtils.copyProperties(housingDto,housing);
        int update = housingMapper.update(housing);
        if (update == 1) {
            System.out.println(update);
            return ResponseEntity.success(update);
        }
        return ResponseEntity.error();
    }
//单个删除
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity delHousing(int hId) {

        int delete = housingMapper.delete(hId);
        if (delete == 1) {
            return  ResponseEntity.success(delete);
        }


        return  ResponseEntity.error();
    }
//批量删除
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity delHousings(List<Integer> hIds) throws ServiceException {
        int i = housingMapper.deleteHousing(hIds);
        if (i == hIds.size()) {
            return  ResponseEntity.success(i);
        }else{
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return  ResponseEntity.error();
    }

//显示全部页面
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<HousingDto> findAll(String keyWord, String createTime, String endingTime, int limit, int offset) throws ServiceException {
        //根据关键字搜索
        List<Housing> housings = housingMapper.selectAll(keyWord, createTime, endingTime, (limit - 1) * offset, offset);
        if (housings.size()==0) {
            return  null;
        }else{
            List<HousingDto> housingDtos =new ArrayList<>();
            for (Housing housing:housings) {
                HousingDto housingDto = new HousingDto();
                BeanUtils.copyProperties(housing,housingDto);
                housingDtos.add(housingDto);
            }
            return  housingDtos;
        }



    }
}