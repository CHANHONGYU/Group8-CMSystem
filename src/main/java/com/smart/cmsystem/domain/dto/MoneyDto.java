package com.smart.cmsystem.domain.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MoneyDto {
private  Integer mId;
  private  String  mCoumityName;
  private  String monCoding;
    private String monProject;
    private String  createTime;
    private  String  endingTime;
  private  Integer dStatus;
}
