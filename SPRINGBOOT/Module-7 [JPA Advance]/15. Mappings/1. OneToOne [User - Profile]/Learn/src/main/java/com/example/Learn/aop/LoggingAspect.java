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


    @Pointcut("execution(* com.example.Learn.exception.GlobalExceptionHandler.*(..))")
    public void validationExceptionHandler() {
    }

    @AfterReturning(
            pointcut = "validationExceptionHandler()",
            returning = "response"
    )
    public void logValidationErrors(JoinPoint joinPoint, Object response) {
        MethodArgumentNotValidException exception = (MethodArgumentNotValidException) joinPoint.getArgs()[0];
        logger.error("Validation failed : {} errors", exception.getBindingResult().getErrorCount());
        exception.getBindingResult().getFieldErrors().forEach((error) -> {
            logger.error("Field : '{}', Rejected Value : '{}', Message : '{}'",
                    error.getField(),
                    error.getRejectedValue(),
                    error.getDefaultMessage());
        });
    }

    /*
     * All Request and Response Logging
     * */

    @Pointcut("execution(* com.example..*.*(..))")
    public void applicationPackagePointcut() {
    }


    @Before("applicationPackagePointcut()")
    public void logRequest(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes != null) {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            logger.info("[Request] {} {} - args : {}", request.getMethod(), request.getRequestURI(), Arrays.toString(joinPoint.getArgs()));
        } else {
            logger.info("[Request] Method : {} - args : {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }
    }

    @AfterReturning(
            pointcut = "applicationPackagePointcut()",
            returning = "response"
    )
    public void logResponse(JoinPoint joinPoint, Object response) {
        logger.info("[Response] Method : {} - Result : {}", joinPoint.getSignature().getName(), response);
    }

}
