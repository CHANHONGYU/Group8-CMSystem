package com.smart.cmsystem.exception;

import com.smart.cmsystem.utils.ErrorStatus;


public class ServiceException extends Exception{
    private String msg;
    private int status;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public ServiceException(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    public ServiceException(ErrorStatus status){
        this.msg=status.getMsg();
        this.status=status.getStatus();
    }
}
