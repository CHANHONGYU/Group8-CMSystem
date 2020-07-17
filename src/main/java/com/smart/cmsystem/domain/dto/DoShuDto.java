package com.smart.cmsystem.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

@Data
public class DoShuDto   {
//搜索的关键字  栋数名字
    private  Integer dId;
    private  String  dCoumityName;
    private String dCoding;
    private  String  dName;
    private  Integer dSum;
    private  String dTxt;
    private String  createTime;
    private  String  endingTime;
    private  Integer dStatus;


}
