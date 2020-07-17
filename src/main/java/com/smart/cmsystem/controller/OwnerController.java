package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Owner;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.service.OwnerService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     * @param search 封装的搜索类
     * @return ResponseEntity<List<Owner>>
     */
    @PostMapping("/search")
    public ResponseEntity<List<Owner>> search(@RequestBody Search search) throws ServiceException {
        ResponseEntity<List<Owner>> responseEntity = null;
        if (search!=null) {
            responseEntity = ResponseEntity.success(ownerService.searchOwner(search));
        }
        return responseEntity;
    }
    /**
     * 添加一名业主信息
     * @param owner 业主实体类
     * @return 返回添加个数
     */
    @RequestMapping("/addOwner")
    public ResponseEntity<Integer> addOwner(@RequestBody Owner owner) throws ServiceException {
        int count = 0;
        if (owner!=null){
            count = ownerService.addOwner(owner);
        }
        return ResponseEntity.success(count);
    }

    /**
     * 查询所有业主的信息
     * @return 业主实体类list
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(method = RequestMethod.POST,value = "/ownerAll")
    @ResponseBody
    public ResponseEntity ownerAll() throws ServiceException {
        List ownerLis =ownerService.selectAll();
        return ResponseEntity.success(ownerLis);
    }

    /**
     * 修改一名业主的信息
     * @param owner 参数是业主实体类
     * @return 返回修改个数
     */
    @RequestMapping("/modifyOwner")
    public ResponseEntity<Integer> modifyOwner(@RequestBody Owner owner) throws ServiceException {
        int count=0;
        if (owner!=null) {
            count = ownerService.modifyOwner(owner);
        }
        return ResponseEntity.success(count);
    }

    /**
     * 删除一名业主的信息
     *
     * @param owner 参数是业主实体类
     * @return 返回删除个数
     */
    @RequestMapping("/delOwner")
    public ResponseEntity<Integer> delOwner(@RequestBody Owner owner) throws ServiceException {
        int count=0;
        if (owner!=null) {
            count = ownerService.delOwner(owner);
        }
        return ResponseEntity.success(count);
    }

    /**
     * 批量删除业主的信息（假删除）
     * @param ownerList 参数是业主实体类list
     * @return 业主实体类list
     */
    @RequestMapping("/delOwners")
    public ResponseEntity<Integer> delOwners(@RequestBody List<Owner> ownerList) throws ServiceException {
        int count=0;
        if (ownerList!=null) {
            count = ownerService.delOwners(ownerList);
        }
        return ResponseEntity.success(count);
    }
}
