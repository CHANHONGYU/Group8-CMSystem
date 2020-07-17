package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.HousingDto;
import com.smart.cmsystem.domain.dto.MoneyDetailDto;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.service.MoneyDetailService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收费详情表的控制层
 */
@RestController
@RequestMapping("/moneydetail")
public class MoneyDetailController {
    @Resource
    MoneyDetailService moneyDetailService;
    //添加用户
    @PostMapping( value = "/savemoneydetail" ,produces = {"application/json;charset=UTF-8"})
    public ResponseEntity saveHousing(@RequestBody MoneyDetailDto moneyDetailDto) {
        ResponseEntity responseEntity = moneyDetailService.insertMoneyDetail(moneyDetailDto);
        return responseEntity;
    }

    //修改用户
    @PostMapping( value = "/updatemoneydetail",produces = {"application/json;charset=UTF-8"})
    public ResponseEntity updateHousing(@RequestBody MoneyDetailDto moneyDetailDto) {
        ResponseEntity responseEntity = moneyDetailService.alterMoneyDetailDto(moneyDetailDto);
        return responseEntity;
    }

    //删除用户
    @GetMapping(value = "/delete/{mdId}",produces = {"application/json;charset=UTF-8"})
    public ResponseEntity deleteHousing(@PathVariable int mdId) {
        ResponseEntity responseEntity = moneyDetailService.delMoneyDetail(mdId);
        return responseEntity;
    }

    //显示所有
    @GetMapping(value = "/selectAll", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<List<MoneyDetailDto>> selectAll(@RequestParam(required = false) String keyWord,
                                                      @RequestParam(required = false)  String updateTime,
                                                      @RequestParam(required = false) String createTime,
                                                      @RequestParam(required = false) String endingTime,
                                                      @RequestParam(defaultValue = "1") int limit,
                                                      @RequestParam(defaultValue = "5") int offset) throws ServiceException {
        List<MoneyDetailDto> moneyDetailDtos =
                moneyDetailService.findAll(keyWord,updateTime, createTime, endingTime, limit, offset);
        return ResponseEntity.success(moneyDetailDtos);
    }

    //批量删除
    @PostMapping(value = "/deletemoneydetail", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity deleteHousings(@RequestBody List<Integer> mdIds) throws ServiceException {
        ResponseEntity responseEntity = moneyDetailService.delMoneyDetails(mdIds);
        return responseEntity;
    }
}
