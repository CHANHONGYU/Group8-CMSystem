package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.ComplaintsDto;
import com.smart.cmsystem.domain.dto.MaintainDto;
import com.smart.cmsystem.domain.entity.Activities;
import com.smart.cmsystem.domain.entity.Complaints;
import com.smart.cmsystem.exception.DaoException;
import com.smart.cmsystem.mapper.ComplaintsMapper;
import com.smart.cmsystem.service.ComplaintsService;
import com.smart.cmsystem.utils.ErrorStatus;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class ComplaintsServiceImpl implements ComplaintsService {
    @Resource
    ComplaintsMapper complaintsMapper;
    /**
     * @param keyword   关键字
     * @param startTime 区间开始
     * @param endTime   区间结束
     * @param limit     分页
     * @param offset    分页大小
     * @return
     */
    @Override
    public List<ComplaintsDto> selectAllComplaintsByKey(String keyword, String startTime, String endTime, int limit, int offset) {
        List<Complaints> complaints = complaintsMapper.selectAll(keyword, startTime, endTime, limit, offset);
        List<ComplaintsDto> complaintsDtos=new ArrayList<>();
        for (Complaints complaint : complaints) {
            ComplaintsDto complaintsDto=new ComplaintsDto();
            BeanUtils.copyProperties(complaint,complaintsDto);
//            判断是否需要匿名,需要就把名字设置为匿名.
            if(complaintsDto.getCStatus()==1){
                complaintsDto.setOwnerName("匿名");
            }
            complaintsDtos.add(complaintsDto);
        }
        return complaintsDtos;
    }

    @Override
    @Transactional
    public ResponseEntity deleteComplaintsById(List<Integer> comIds) {

        if (comIds.size()>0){
            int i = complaintsMapper.deleteComplaintsById(comIds);
            if(i==comIds.size()){
                return ResponseEntity.success(i);
            }else {
                return ResponseEntity.error(ErrorStatus.DAO_ERROR);
            }
        }else{
            return ResponseEntity.error(ErrorStatus.REQUEST_ERROR);
        }

    }

    @Override
    public ResponseEntity saveComplaint(ComplaintsDto complaintsDto) {
        if (complaintsDto!=null){
            Complaints complaints=new Complaints();
            BeanUtils.copyProperties(complaintsDto,complaints);
            int i = complaintsMapper.saveComplaint(complaints);
            if (i==1){
                return ResponseEntity.success(i);
            }else {
                return ResponseEntity.error(ErrorStatus.DAO_ERROR);
            }
        }
        return ResponseEntity.error(ErrorStatus.REQUEST_ERROR);
    }

    @Override
    public ResponseEntity updateComplaint(ComplaintsDto complaintsDto) {
        if (complaintsDto!=null){
            Complaints complaints=new Complaints();
            BeanUtils.copyProperties(complaintsDto,complaints);
            int i = complaintsMapper.updateComplaint(complaints);
            if (i==1){
                return ResponseEntity.success(i);
            }
            return ResponseEntity.error(ErrorStatus.DAO_ERROR);
        }
        return ResponseEntity.error(ErrorStatus.REQUEST_ERROR);
    }

}
