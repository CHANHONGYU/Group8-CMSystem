package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Owner;
import com.smart.cmsystem.service.OwnerService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/owner")
@CrossOrigin(origins = "*",maxAge = 3600)
public class OwnerController {
    @Resource
    OwnerService ownerService;

    /**
     * 搜索所需业主信息
     *
     * @param search 封装的搜索类
     * @return ResponseEntity<List<Owner>>
     */
    @RequestMapping("/selectByDate")
    public ResponseEntity<List<Owner>>selectByDate(@RequestBody Search search){
        return ResponseEntity.success(ownerService.searchOwner(search));
    }
    /**
     * 添加一名业主信息
     * @param owner
     * @return
     */
    @RequestMapping("/addOwner")
    public ResponseEntity<Integer> addOwner(@RequestBody Owner owner){
        int count = ownerService.addOwner(owner);
        return ResponseEntity.success(count);
    }

    /**
     * 查询所有业主的信息
     * @return
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(method = RequestMethod.POST,value = "/selectAll")
    @ResponseBody
    public ResponseEntity<List<Owner>> selectAll(){
        List ownerLis =ownerService.selectAll();
        return ResponseEntity.success(ownerLis);
    }

    /**
     * 修改一名业主的信息
     * @param owner
     * @return
     */
    @RequestMapping("/modifyOwner")
    public ResponseEntity<Integer> modifyOwner(@RequestBody Owner owner){
        int count = ownerService.modifyOwner(owner);
        return ResponseEntity.success(count);
    }

    /**
     * 删除一名业主的信息
     *
     * @param owner
     * @return
     */
    @RequestMapping("/delOwner")
    public ResponseEntity<Integer> delOwner(@RequestBody Owner owner) {
        int count = ownerService.delOwner(owner);
        return ResponseEntity.success(count);
    }

    /**
     * 批量删除业主的信息（假删除）
     * @param ownerList
     * @return
     */
    @RequestMapping("/delOwners")
    public ResponseEntity<Integer> delOwners(@RequestBody List<Owner> ownerList){
        int count = ownerService.delOwners(ownerList);
        return ResponseEntity.success(count);
    }
}
