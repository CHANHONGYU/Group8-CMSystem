package com.smart.cmsystem.utils;

import lombok.Data;

@Data
public class RUtity<T> {
    private int status;
    private String msg;
    private T data;

    public static <T> RUtity<T> success(T data) {
        RUtity<T> entity = new RUtity<>();
        entity.setData(data);
        entity.setMsg(ErrorStatus.SUCCESS.getMsg());
        entity.setStatus(ErrorStatus.SUCCESS.getStatus());
        return entity;
    }

    public static <T> RUtity<T> success(ErrorStatus status, T data) {
        RUtity<T> entity = new RUtity<>();
        entity.setData(data);
        entity.setMsg(status.getMsg());
        entity.setStatus(status.getStatus());
        return entity;
    }

    public static <T> RUtity<T> error() {
        RUtity<T> entity = new RUtity<>();
        entity.setMsg(ErrorStatus.SYS_ERROR.getMsg());
        entity.setStatus(ErrorStatus.SYS_ERROR.getStatus());
        return entity;
    }

    public static <T> RUtity<T> error(ErrorStatus status) {
        RUtity<T> entity = new RUtity<>();
        entity.setMsg(status.getMsg());
        entity.setStatus(status.getStatus());
        return entity;
    }
}
