package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.ActivitiesDto;
import com.smart.cmsystem.domain.entity.Activities;
import com.smart.cmsystem.mapper.ActivitiesMapper;
import com.smart.cmsystem.service.ActivitiesService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {
    @Resource
    ActivitiesMapper activitiesMapper;

    @Override
    public List<Activities> ActivitiesList(String keyword, String startTime, String endTime, int limit, int offset) {
        List<Activities> activities = activitiesMapper.selectAll(keyword, startTime, endTime, (limit-1)*offset, offset);
        return activities;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<Integer> deleteActivities(List<Integer> actIds) {

        int i = activitiesMapper.deleteActivities(actIds);
        if (i == actIds.size()) {
            return ResponseEntity.success(i);
        } else {
            return ResponseEntity.error();
        }
    }

    @Override
    public ResponseEntity<Integer> saveActivities(ActivitiesDto activitiesDto) {
        Activities act=new Activities();
        BeanUtils.copyProperties(activitiesDto,act);
        int i = activitiesMapper.saveActivities(act);
        if (i==1){
            return ResponseEntity.success(i);
        }else {
            return ResponseEntity.error();
        }

    }

    @Override
    public ResponseEntity updateActivities(ActivitiesDto activitiesDto) {
        Activities act=new Activities();
        BeanUtils.copyProperties(activitiesDto,act);
        int i = activitiesMapper.updateActivities(act);
        if (i==1){
            return ResponseEntity.success(i);
        }
        return ResponseEntity.error();
    }

}
