package com.smart.cmsystem.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 接受前端传入的参数
 */
@Data
public class HousingDto  {

  private  Integer hId;
  private  String hCoumityName;
  private  String hDName;
  private  String hCongding;
  private  String hName;
  private  String hOwnerName;
  private  String  hOwnPhone;
  private  Integer hHome;
  private  Integer hCell;
  private  Integer hLevel;
  private  String hTxt;
  private  String  createTime;
  private  String endingTime;
  private  Integer hStatus;


}
