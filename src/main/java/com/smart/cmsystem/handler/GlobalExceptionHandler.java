package com.smart.cmsystem.handler;

import com.smart.cmsystem.exception.DaoException;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.utils.ErrorStatus;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public ResponseEntity handlerException(Exception ex) {
        if (ex instanceof ServiceException) {
            return ResponseEntity.error(ErrorStatus.SERVICE_ERROR);
        } else if (ex instanceof DaoException) {
            return ResponseEntity.error(ErrorStatus.DAO_ERROR);
        }
        return ResponseEntity.error();
    }

}
