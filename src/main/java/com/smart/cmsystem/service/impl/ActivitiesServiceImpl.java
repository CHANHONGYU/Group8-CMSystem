package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.entity.Activities;
import com.smart.cmsystem.mapper.ActivitiesMapper;
import com.smart.cmsystem.service.ActivitiesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {
    @Resource
    ActivitiesMapper activitiesMapper;

    @Override
    public List<Activities> ActivitiesList(String keyword, String startTime, String endTime, int limit, int offset) {
        List<Activities> activities = activitiesMapper.selectAll(keyword, startTime, endTime, limit, offset);
        return activities;
    }
}
