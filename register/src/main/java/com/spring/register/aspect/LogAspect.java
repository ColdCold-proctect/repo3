package com.spring.register.aspect;

import com.spring.register.pojo.RequestLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LogAspect {
    //先拿到日志
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    //定义切入点
    //拦截所有控制器
    @Pointcut("execution(* com.spring.register.controller.*.*(..))")
    public void log(){}

    //在切面前执行
    //括号在是上面定义的方法
    @Before("log()")

    public void dobefore(JoinPoint joinPoint){
        //拿到请求，请求里有ip和url
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String url=request.getRequestURL().toString();
        String ip=request.getRemoteAddr();
        String classMethod=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        RequestLog requestLog=new RequestLog(url,ip,classMethod,args);
        logger.info("Request:{}",requestLog);
    }

    @After("log()")
    public void doafter(){}

    //方法执行完之后拦截
    //定义返回参数returning = "result"
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doafterReturn(Object result){
        logger.info("result:{}",result);
    }
}

