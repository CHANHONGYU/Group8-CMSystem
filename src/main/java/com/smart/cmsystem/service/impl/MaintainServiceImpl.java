package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.MaintainDto;
import com.smart.cmsystem.domain.entity.Maintain;
import com.smart.cmsystem.mapper.MaintainMapper;
import com.smart.cmsystem.service.MaintainService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class MaintainServiceImpl implements MaintainService {
    @Resource
    MaintainMapper maintainMapper;


    @Override
    public List<MaintainDto> selectAllByKey(String keyword, String startTime, String endTime, int limit, int offset) {

        List<Maintain> maintains = maintainMapper.selectAllByKey(keyword, startTime, endTime, (limit - 1) * offset, offset);
        if (maintains.size()==0){
            return null;
        }
        List<MaintainDto> maintainDtos =new ArrayList<>();
        MaintainDto maintainDto =new MaintainDto();
        for (Maintain maintain : maintains) {
            BeanUtils.copyProperties(maintain, maintainDto);
            maintainDtos.add(maintainDto);
        }
        return maintainDtos;
    }
}
