package com.smart.cmsystem.handler;

import com.smart.cmsystem.exception.DaoException;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.utils.ErrorStatus;
import com.smart.cmsystem.utils.RUtity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

/**
 * 两个注解
 * 在类上面使用 @RestControllerAdvice
 * 在方法上面使用 ExceptionHandler
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    //    @ExceptionHandler
//    public ResponseEntity handlerException(Exception ex) {
//        if (ex instanceof ServiceException) {
//            return ResponseEntity.error(ErrorStatus.SERVICE_ERROR);
//        } else if (ex instanceof DaoException) {
//            return ResponseEntity.error(ErrorStatus.DAO_ERROR);
//        }
//        return ResponseEntity.error();
//    }
    // 走异常通知
    @ExceptionHandler(Exception.class)
    public RUtity handlerException(DaoException ex) {
        return RUtity.error(ErrorStatus.SYS_ERROR);
    }

    // 走异常通知
    @ExceptionHandler(DaoException.class)
    public RUtity handlerDaoException(DaoException ex) {
        return RUtity.error(ErrorStatus.DAO_ERROR);
    }

    // 走异常通知
    public RUtity handlerServuceException(ServiceException ex) {
        return RUtity.error(ErrorStatus.SERVICE_ERROR);
    }
}
