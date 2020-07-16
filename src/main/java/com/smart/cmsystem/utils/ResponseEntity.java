package com.smart.cmsystem.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseEntity<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    /**
     * 成功默认的执行方法
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> success(T data) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setData(data);
        responseEntity.setStatus(ErrorStatus.SUCCESS.getStatus());
        responseEntity.setMsg(ErrorStatus.SUCCESS.getMsg());
        return responseEntity;
    }

    /**
     * 指定状态的成功方法
     * @param status
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> success(ErrorStatus status,T data) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setData(data);
        responseEntity.setStatus(status.getStatus());
        responseEntity.setMsg(status.getMsg());
        return responseEntity;
    }

    /**
     * 默认失败方法
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> error() {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setMsg(ErrorStatus.SYS_ERROR.getMsg());
        responseEntity.setStatus(ErrorStatus.SYS_ERROR.getStatus());
        responseEntity.setData(new Object());
        return responseEntity;
    }

    /**
     * 指定状态的失败方法
     * @param <T>
     * @return
     */

    public static <T> ResponseEntity<T> error(ErrorStatus status) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setMsg(status.getMsg());
        responseEntity.setStatus(status.getStatus());
        responseEntity.setData(new Object());
        return responseEntity;
    }

}
