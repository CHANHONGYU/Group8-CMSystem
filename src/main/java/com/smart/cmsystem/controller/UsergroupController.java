package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.UsergroupDto;
import com.smart.cmsystem.domain.entity.Usergroup;
import com.smart.cmsystem.service.UsergroupService;
import com.smart.cmsystem.utils.RUtity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/userg")
public class UsergroupController {
    @Resource
    UsergroupService usergroupService;
    @GetMapping(value = "/ulist",produces = {"application/json"})
    public RUtity<List<Usergroup>> ulist(){
        List<Usergroup> query = usergroupService.query();
        return RUtity.success(query);
    }
    @GetMapping(value = "/ubyword",produces = {"application/json"})
    public RUtity<List<Usergroup>> byword(@RequestParam String keyword){
        List<Usergroup> usergroups = usergroupService.queryBykeyword(keyword);
        return RUtity.success(usergroups);
    }
    @PostMapping(value = "umod",produces = {"application/json"})
    public RUtity<Integer> umodify(@RequestBody UsergroupDto usergroupDto){
        int modify = usergroupService.modify(usergroupDto);
        return RUtity.success(modify);
    }
    @PostMapping(value = "/uadd",produces = {"application/json"})
    public RUtity<Integer> uadd(@RequestBody UsergroupDto usergroupDto){
        int i = usergroupService.addDate(usergroupDto);
        return RUtity.success(i);
    }
    @PutMapping(value = "udelete",produces = {"application/json"})
    public RUtity<Integer> udetele(@RequestBody int[] ints){
        int i = usergroupService.deteleDate(ints);
        return RUtity.success(i);
    }
}
