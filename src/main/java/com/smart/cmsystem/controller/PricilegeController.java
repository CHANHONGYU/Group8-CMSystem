package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.PrivilegeDto;
import com.smart.cmsystem.domain.entity.Privilege;
import com.smart.cmsystem.service.PrivilegeService;
import com.smart.cmsystem.utils.RUtity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pric")
public class PricilegeController {
    @Resource
    PrivilegeService privilegeService;

    @GetMapping(value = "/list/{page}/{size}",produces = {"application/json"})
    public RUtity<List<Privilege>> list(@PathVariable("page") int page,@PathVariable("size") int size){
        List<Privilege> privileges = privilegeService.queryAll(page, size);
        return RUtity.success(privileges);
    }

    @GetMapping(value = "/queryke",produces = {"application/json"})
    public RUtity<List<Privilege>> queryKe(@RequestParam String keyword){
        List<Privilege> privileges = privilegeService.queryByk(keyword);
        return RUtity.success(privileges);
    }
    @PostMapping(value = "/genx",produces = {"application/json"})
    public RUtity<Integer> GenX(@RequestBody PrivilegeDto privilegeDto){
        int modify = privilegeService.modify(privilegeDto);
        return RUtity.success(modify);
    }
    @PostMapping(value = "/add",produces = {"application/json"})
    public RUtity<Integer> addT(@RequestBody PrivilegeDto privilegeDto){
        int i = privilegeService.addDate(privilegeDto);
        return RUtity.success(i);
    }
    @PutMapping(value = "/delete",produces = {"application/json"})
    public RUtity<Integer> delete(@RequestParam int[] pid){
        int i = privilegeService.deleteById(pid);
        return RUtity.success(i);
    }
}
