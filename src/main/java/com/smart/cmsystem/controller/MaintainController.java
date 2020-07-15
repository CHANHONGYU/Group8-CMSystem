package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.MaintainDto;
import com.smart.cmsystem.domain.entity.Maintain;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.service.MaintainService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping(value = "/maintain",produces = {"application/json;charset=UTF-8"})
public class MaintainController {
    @Resource
    MaintainService maintainService;

    @GetMapping(value = "/selectAllByKey",produces ={"application/json;charset=UTF-8"})
    public ResponseEntity<List<MaintainDto>> selectAllByKey(@RequestParam(required=false)String keyword,
                                                            @RequestParam(required=false)String startTime,
                                                            @RequestParam(required=false)String endTime,
                                                            @RequestParam(defaultValue = "1")int limit,
                                                            @RequestParam(defaultValue = "10")int offset) throws ServiceException {
        List<MaintainDto> maintainDtos=
                maintainService.selectAllByKey(keyword, startTime, endTime, limit, offset);
        return ResponseEntity.success(maintainDtos);
    }
    @PutMapping(value = "/deleteMaintain" ,produces ={"application/json;charset=UTF-8"})
    public ResponseEntity deleteMaintain(@RequestBody List<Integer> mids) throws ServiceException {
        ResponseEntity responseEntity = maintainService.deleteMaintain(mids);
        return responseEntity;
    }

    @PostMapping(value = "/saveMaintain",produces ={"application/json;charset=UTF-8"})
    public ResponseEntity savemaintain(@RequestBody MaintainDto maintainDto){
        ResponseEntity responseEntity = maintainService.insertMaintain(maintainDto);
        return responseEntity;
    }

    @PutMapping(value = "updateMatain",produces = {"application/json;charset=UTF-8"})
    public ResponseEntity updateMatain(@RequestBody MaintainDto maintainDto){
        ResponseEntity responseEntity = maintainService.updateMaintain(maintainDto);
        return responseEntity;
    }
}
