package com.example.authentication.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    // handler = controller method

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        System.out.println("Incoming request method : "+request.getMethod() + "URI : "+request.getRequestURI());
        return true;
    }

   @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception{
       System.out.println("Response status : "+response.getStatus());
   }

//    IMPORTANT
/*
* postHandle() :
  Run's only on success.
  Doesn't have access to json response because after this method jackson does the serialization.

* afterCompletion() :
   Always runs.
   Runs once the response is flushed to the client.

TO MODIFY THE RESPONSE ALWAYS USE "FILTER"
*/


}
