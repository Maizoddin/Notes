package com.example.Learn.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.example.Learn.exception.*.*(..))")
    public void validationPointcut() {
    }

    @Pointcut("execution(* com.example.Learn..*.*(..))")
    public void packagePointcut() {
    }

    @AfterReturning(
            pointcut = "validationPointcut()",
            returning = "response"
    )
    public void logValidationErrors(JoinPoint joinPoint, Object response) {
        MethodArgumentNotValidException exception = (MethodArgumentNotValidException) joinPoint.getArgs()[0];
        logger.error("Validation Failed : {} errors", exception.getBindingResult().getErrorCount());
        exception.getBindingResult().getFieldErrors().
                forEach((error) -> {
                    logger.error("Feild : {}, Value : {}, Message : {}", error.getField(), error.getRejectedValue(), error.getDefaultMessage());
                });
    }

    @Before("packagePointcut()")
    public void logRequest(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            logger.info("[Request] RequestType : {}, URL : {}, Method : {}, Arguments : {}",
                    request.getMethod(),
                    request.getRequestURI(),
                    joinPoint.getSignature().getName(),
                    Arrays.toString(joinPoint.getArgs())
            );
        } else {
            logger.info("[Request] Method : {}, Arguments : {}",
                    joinPoint.getSignature().getName(),
                    Arrays.toString(joinPoint.getArgs())
            );
        }
    }

    @AfterReturning(
            pointcut = "packagePointcut()",
            returning = "response"
    )
    public void logResponse(JoinPoint joinPoint, Object response) {
        logger.info("[Response] Method : {}, Response : {}",
                joinPoint.getSignature().getName(),
                response);
    }


}