package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Owner;
import com.smart.cmsystem.service.OwnerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Resource
    OwnerService ownerService;

    /**
     * 搜索所需业主信息
     *
     * @param search
     * @return
     */
    @RequestMapping("/selectByDate")
    public List<Owner> selectByDate(@RequestBody Search search){
        return ownerService.searchOwner(search);
    }
    /**
     * 添加一名业主信息
     * @param owner
     * @return
     */
    @RequestMapping("/addOwner")
    public int addOwner(@RequestBody Owner owner){
        int count = ownerService.addOwner(owner);
        return count;
    }

    /**
     * 查询所有业主的信息
     * @return
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Owner> selectAll(){
        return ownerService.selectAll();
    }

    /**
     * 修改一名业主的信息
     * @param owner
     * @return
     */
    @RequestMapping("/modifyOwner")
    public int modifyOwner(@RequestBody Owner owner){
        int count = ownerService.modifyOwner(owner);
        return count;
    }

    /**
     * 删除一名业主的信息
     *
     * @param owner
     * @return
     */
    @RequestMapping("/delOwner")
    public int delOwner(@RequestBody Owner owner) {
        int count = ownerService.delOwner(owner);
        return count;
    }

    /**
     * 批量删除业主的信息（假删除）
     * @param ownerList
     * @return
     */
    @RequestMapping("/delOwners")
    public int delOwners(@RequestBody List<Owner> ownerList){
        int count = ownerService.delOwners(ownerList);
        return count;
    }
}
