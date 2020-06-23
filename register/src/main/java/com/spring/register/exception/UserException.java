package com.spring.register.exception;


import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserException{

    @ResponseBody
    @ExceptionHandler(value = {BindException.class})
    public Map errorHandler(Exception e) {
        Map map = new HashMap();
        map.put("status","0");
        map.put("data","fail");
        map.put("error",e.getMessage());
        return map;
    }
}
