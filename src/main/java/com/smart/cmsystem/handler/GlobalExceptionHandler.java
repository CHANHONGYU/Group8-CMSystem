package com.smart.cmsystem.handler;

import com.smart.cmsystem.exception.DaoException;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.utils.ErrorStatus;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

/**
 * 两个注解
 * 在类上面使用@RestControllerAdvice
 * 在方法上面使用ExceptionHandler
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    Logger logger;
    @ExceptionHandler
    public ResponseEntity handlerException(Exception e){
        if (e instanceof ServiceException){
            return ResponseEntity.error(ErrorStatus.SERVICE_ERROR);
        } else if (e instanceof DaoException){
            return ResponseEntity.error(ErrorStatus.DAO_ERROR);
        }
        return ResponseEntity.error();
    }
}
