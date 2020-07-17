package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.HousingDto;
import com.smart.cmsystem.domain.dto.MoneyDto;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.service.MoneyService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * 项目控制层
 */
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/money")
public class MoneyController {
    @Resource
    MoneyService moneyService;

    //添加金钱
    @PostMapping(value = "/saveMoney",produces = {"application/json;charset=UTF-8"})
    public ResponseEntity saveMemory(@RequestBody MoneyDto moneyDto) {
        ResponseEntity responseEntity = moneyService.insertMoney(moneyDto);
        return responseEntity;
    }

    //修改
    @PostMapping( value = "/updateMoney",produces = {"application/json;charset=UTF-8"})
    public ResponseEntity updateMoney(@RequestBody MoneyDto moneyDto) {
        ResponseEntity responseEntity = moneyService.alterMoney(moneyDto);
        return responseEntity;
    }

    //删除
    @GetMapping( value = "/delete/{mId}",produces = {"application/json;charset=UTF-8"})
    public ResponseEntity deleteMoney(@PathVariable int mId) {
        ResponseEntity responseEntity = moneyService.delMoney(mId);
        return responseEntity;
    }

    //批量删除
    @PostMapping(value = "/deleteMoney", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity deleteMoneys(@RequestBody List<Integer> mIds) throws ServiceException {
        ResponseEntity responseEntity = moneyService.deleteMoneys(mIds);
        return responseEntity;
    }

    //显示所有
    @GetMapping(value = "/selectAll", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<List<MoneyDto>> selectAll(@RequestParam(required = false) String keyWord,
                                                    @RequestParam(required = false) String createTime,
                                                    @RequestParam(required = false) String endingTime,
                                                    @RequestParam(defaultValue = "1") int limit,
                                                    @RequestParam(defaultValue = "5") int offset) throws ServiceException {
        List<MoneyDto> moneyDtos =
                moneyService.findAll(keyWord, createTime, endingTime, limit, offset);
        return ResponseEntity.success(moneyDtos);
    }
}