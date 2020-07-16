package com.smart.cmsystem.domain.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
@Data
public class ManagerDto {
    /**
     * 管理员ID
     */
    private Integer mId;
    /**
     * 管理员名字
     */
    private String mName;

    /**
     * 管理员手机
     */
    private Integer mPhone;

    /**
     * 管理员邮箱
     */
    private String mEmils;

    /**
     * 管理员权限
     */
    private String mRole;

    /**
     * 管理员密码
     */
    private String mPassword;

    /**
     * 加入时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date mJoiningtime;

    /**
     * 是否启用 1为启用，0为停用
     */
    private Integer mState;
}
