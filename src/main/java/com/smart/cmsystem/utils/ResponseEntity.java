package com.smart.cmsystem.utils;

import lombok.Data;


@Data
public class ResponseEntity<T> {
    private int status;
    private String msg;
    private T data;

    /**
     * 在这里定义静态方法,就不需要自己在其它层用set方法一步一步设置值,就是封装
     * @param status
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> success(ErrorStatus status, T data) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setStatus(status.getStatus());
        entity.setMsg(status.getMsg());
        entity.setData(data);
        return entity;


    }
    public static <T> ResponseEntity<T> success(ErrorStatus status) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setStatus(status.getStatus());
        entity.setMsg(status.getMsg());
        return entity;


    }

    public static <T> ResponseEntity<T> error(ErrorStatus status) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setStatus(status.getStatus());
        entity.setMsg(status.getMsg());
        return entity;
    }
}
