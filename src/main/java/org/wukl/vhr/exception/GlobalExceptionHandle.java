package org.wukl.vhr.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.wukl.vhr.model.ResponseBean;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(SQLException.class)
    public ResponseBean errorBySqlException(SQLException ex)
    {
        if(ex instanceof SQLIntegrityConstraintViolationException)
        {
            return ResponseBean.responseError("该数据存在关联关系，操作失败");
        }
        return ResponseBean.responseError("数据库异常，操作失败");
    }
}
