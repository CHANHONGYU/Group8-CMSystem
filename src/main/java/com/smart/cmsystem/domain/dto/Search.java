package com.smart.cmsystem.domain.dto;

import lombok.Data;

import java.util.Date;
@Data
public class Search {
    private Date startDay;
    private Date endDay;
    private String ownerName;
}
