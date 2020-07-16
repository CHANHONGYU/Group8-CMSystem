package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.ManagerDto;
import com.smart.cmsystem.domain.entity.Managers;
import com.smart.cmsystem.service.ManagersService;
import com.smart.cmsystem.utils.RUtity;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员表
 */
@RestController
@RequestMapping("/manager")
public class ManagersController {
    @Resource
    ManagersService managersService;
    @GetMapping(value = "/list",produces = {"application/json"})
    public RUtity<List<Managers>> list(){
        List<Managers> managers = managersService.queryAll();
        return RUtity.success(managers);
    }
    @GetMapping(value = "/keyword",produces = {"application/json"})
    public RUtity<List<Managers>> keyword(@RequestParam() String keyword){
        List<Managers> list = managersService.queryByKeyword(keyword);
        return RUtity.success(list);
    }

    @PostMapping(value = "/add",produces = {"application/json"})
    public RUtity<Integer> add(@RequestBody ManagerDto managerDto){
        int i = managersService.addData(managerDto);
        return RUtity.success(i);
    }

    @PostMapping(value = "/updated",produces = {"application/json"})
    public RUtity<Integer> updated(@RequestBody ManagerDto managerDto){
        int i = managersService.modifyData(managerDto);
        return RUtity.success(i);
    }

    @PutMapping(value = "/",produces = {"application/json"})
    public RUtity<Integer> Deleted(@RequestBody int[] ints){
        int i = managersService.DeleteInformation(ints);
        return RUtity.success(i);
    }
}
