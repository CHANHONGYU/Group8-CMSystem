package com.smart.cmsystem.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class MoneyDetailDto {
    private  Integer mdId;
    private  String monCoumityName;
    private String monDetProject;
    private  String ownerName;
    private BigDecimal monReceivable;
    private BigDecimal monFinal;
    private String monText;
    private String  updateTime;
    private  String   createTime;
    private  String  endingTime;
    private Integer monStatus;
}
