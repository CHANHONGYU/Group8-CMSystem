package com.smart.cmsystem.domain.entity;

import lombok.Data;

@Data
public class Role {
    private Integer roleId;

    /**
    * admin   user  guest
    */
    private String roleName;
}