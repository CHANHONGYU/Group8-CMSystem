package com.smart.cmsystem.controller;


import com.smart.cmsystem.domain.dto.ComplaintsDto;
import com.smart.cmsystem.domain.dto.MaintainDto;
import com.smart.cmsystem.service.ComplaintsService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RequestMapping("/complaints")
public class ComplaintsController {
    @Resource
    ComplaintsService complaintsService;

    @GetMapping(value = "/selectComplaints", produces = {"application/json"})
    public ResponseEntity<List<ComplaintsDto>> selectComplaintsByKey(@RequestParam(required = false) String keyword, @RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime, @RequestParam(defaultValue = "1") int limit, @RequestParam(defaultValue = "10") int offset) throws Exception {
        List<ComplaintsDto> complaintsDtoList = complaintsService.selectAllComplaintsByKey(keyword, startTime, endTime, limit, offset);
        ResponseEntity<List<ComplaintsDto>> ComplaintsDtos = ResponseEntity.success(complaintsDtoList);
        return ComplaintsDtos;
    }

    /**
     * 通过id批量删除
     *
     * @param comIds
     * @return
     */
    @PutMapping(value = "deleteComplaint", produces = {"application/json"})
    public ResponseEntity deleteComplaint(@RequestBody List<Integer> comIds) {
        ResponseEntity responseEntity = complaintsService.deleteComplaintsById(comIds);
        return responseEntity;
    }

    /**
     * 添加一个投诉建议
     */
    @PostMapping(value = "saveComplaint", produces = {"application/json"})
    public ResponseEntity saveComplaints(@RequestBody ComplaintsDto complaintsDto) {
        ResponseEntity responseEntity = complaintsService.saveComplaint(complaintsDto);
        return responseEntity;
    }
    /**
     * 修改信息
     */
    @PutMapping(value = "updateComplaint",produces = {"application/json;charset=UTF-8"})
    public ResponseEntity updateComplaint(@RequestBody ComplaintsDto complaintsDto){
        ResponseEntity responseEntity = complaintsService.updateComplaint(complaintsDto);
        return responseEntity;
    }
}