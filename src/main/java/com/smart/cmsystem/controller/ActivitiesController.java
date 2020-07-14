package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.ActivitiesDto;
import com.smart.cmsystem.domain.entity.Activities;
import com.smart.cmsystem.service.ActivitiesService;
import com.smart.cmsystem.utils.ErrorStatus;
import com.smart.cmsystem.utils.ResponseEntity;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.*;
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

    @GetMapping(value = "/list",produces = {"application/json;charset=UTF-8"})
    public ResponseEntity list(){
        return ResponseEntity.error();
    }

   @PutMapping(value = "/deleteActivities",produces ={"application/json;charset=UTF-8"} )
    public ResponseEntity deleteActivities(@RequestBody List<Integer> actIds){
        try{
            ResponseEntity responseEntity = activitiesService.deleteActivities(actIds);
            return responseEntity;
        }catch (Exception e){
           return ResponseEntity.error();
        }

    }

    @PostMapping(value = "saveActivities",produces ={"application/json;charset=UTF-8"})
    public ResponseEntity saveActivities(@RequestBody ActivitiesDto activitiesDto){
        try{
            ResponseEntity responseEntity = activitiesService.saveActivities(activitiesDto);
            return responseEntity;
        }catch (Exception e){
            return ResponseEntity.error();
        }

    }

    @PutMapping(value="updateAct",produces = {"application/json;charset=UTF-8"})
    public ResponseEntity updateActivities(@RequestBody ActivitiesDto actDto){
        try {
            ResponseEntity responseEntity = activitiesService.updateActivities(actDto);
            return responseEntity;
        }catch (Exception e){
            e.printStackTrace();return ResponseEntity.error(ErrorStatus.SYS_ERROR);}

    }
}
