package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.HousingDto;
import com.smart.cmsystem.domain.entity.Housing;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.service.HousingService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房产管理表
 */
@RestController
@RequestMapping("/housing")
public class HousingController {
    @Resource
    HousingService housingService;

    //添加用户
    @PostMapping(value = "/saveHousing" ,produces = {"application/json;charset=UTF-8"})
    public ResponseEntity saveHousing(@RequestBody HousingDto housingDto) {
        ResponseEntity responseEntity = housingService.insertHousing(housingDto);
        return responseEntity;
    }

    //修改用户
    @PostMapping(value = "/updateHousing" ,produces = {"application/json;charset=UTF-8"})
    public ResponseEntity updateHousing(@RequestBody HousingDto housingDto) {
        ResponseEntity responseEntity = housingService.alterHousing(housingDto);
        return responseEntity;
    }

    //删除用户
    @GetMapping(value = "/delete/{hId}" ,produces = {"application/json;charset=UTF-8"})
    public ResponseEntity deleteHousing(@PathVariable int hId) {
        ResponseEntity responseEntity = housingService.delHousing(hId);
        return responseEntity;
    }

    //显示所有
    @GetMapping(value = "/selectAll", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<List<HousingDto>> selectAll(@RequestParam(required = false) String keyWord,
                                                      @RequestParam(required = false) String createTime,
                                                      @RequestParam(required = false) String endingTime,
                                                      @RequestParam(defaultValue = "1") int limit,
                                                      @RequestParam(defaultValue = "5") int offset) throws ServiceException {
        List<HousingDto> housingDtos =
                housingService.findAll(keyWord, createTime, endingTime, limit, offset);
        return ResponseEntity.success(housingDtos);
    }

    //批量删除
    @PostMapping(value = "/deleteHousing", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity deleteHousings(@RequestBody List<Integer> hIds) throws ServiceException {
        ResponseEntity responseEntity = housingService.delHousings(hIds);
        return responseEntity;
    }
}