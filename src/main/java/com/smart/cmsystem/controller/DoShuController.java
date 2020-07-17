package com.smart.cmsystem.controller;
/**
 * 栋数控制层
 */

import com.smart.cmsystem.domain.dto.DoShuDto;
import com.smart.cmsystem.domain.dto.HousingDto;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.mapper.DoShuMapper;
import com.smart.cmsystem.service.DoShuService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/doShu")
public class DoShuController {
    @Resource
    DoShuService doShuService;

    //添加用户
    @PostMapping( value = "/savedoshu" ,produces = {"application/json;charset=UTF-8"})
    public ResponseEntity saveHousing(@RequestBody DoShuDto doShuDto) {
        ResponseEntity responseEntity = doShuService.insertDoShu(doShuDto);
        return responseEntity;
    }

    //修改用户
    @PostMapping( value = "/updatedoshu" ,produces = {"application/json;charset=UTF-8"})
    public ResponseEntity updateHousing(@RequestBody DoShuDto doShuDto) {
        ResponseEntity responseEntity = doShuService.alterDoShu(doShuDto);
        return responseEntity;
    }

    //删除用户
    @GetMapping(value = "/delete/{dId}",produces = {"application/json;charset=UTF-8"})
    public ResponseEntity deleteHousing(@PathVariable int dId) {
        ResponseEntity responseEntity = doShuService.delDoShu(dId);
        return responseEntity;
    }

    //显示所有
    @GetMapping(value = "/selectAll", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<List<DoShuDto>> selectAll(@RequestParam(required = false) String keyWord,
                                                    @RequestParam(required = false) String createTime,
                                                    @RequestParam(required = false) String endingTime,
                                                    @RequestParam(defaultValue = "1") int limit,
                                                    @RequestParam(defaultValue = "10") int offset) throws ServiceException {
        List<DoShuDto> doShuDtos =
                doShuService.findAll(keyWord, createTime, endingTime, limit, offset);
        return ResponseEntity.success(doShuDtos);
    }

    //批量删除
    @PostMapping(value = "/deleteAll", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity deleteHousings(@RequestBody List<Integer> hIds) throws ServiceException {
        ResponseEntity responseEntity = doShuService.delDoShuAll(hIds);
        return responseEntity;
    }
}