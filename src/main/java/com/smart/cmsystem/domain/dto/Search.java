package com.smart.cmsystem.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * 前端传来搜索的DTO类
 */
@Data
public class Search {
    private Date startDay;
    private Date endDay;
    private String ownerName;
}
