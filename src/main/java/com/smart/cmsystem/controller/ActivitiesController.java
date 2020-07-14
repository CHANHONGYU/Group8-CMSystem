package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.entity.Activities;
import com.smart.cmsystem.service.ActivitiesService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/service")
public class ActivitiesController {
    @Resource
    ActivitiesService activitiesService;
//produces = {"application/json;charset=UTF-8"} 解决乱码
    @GetMapping(value = "/listActivities",produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<List<Activities>> listActivities(@RequestParam(required=false)String keyword,@RequestParam(required=false)String startTime,@RequestParam(required=false)String endTime,@RequestParam(defaultValue = "1")int limit,@RequestParam(defaultValue = "10") int offset){
        try {

            List<Activities> activities = activitiesService.ActivitiesList(keyword, startTime, endTime, limit, offset);
            return ResponseEntity.success(activities);
        }
        catch (Exception e){
            e.printStackTrace();
        }
       return ResponseEntity.error();
    }

    @GetMapping("list")
    public ResponseEntity<List<Activities>> list(){
        return ResponseEntity.error();
    }
}
