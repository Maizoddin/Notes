package com.example.authentication.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CorsFilter extends OncePerRequestFilter {
    Set<String> allowedOrigins = new HashSet<>();


    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String origin = request.getHeader("Origin");
        if(isAllowedOrigin(origin)){
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, X-API-KEY");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Max-Age", "3600");

            if("OPTIONS".equalsIgnoreCase(request.getMethod())){
                response.setStatus(HttpServletResponse.SC_OK);
                return;
            }else{
                chain.doFilter(request, response);
            }

        }else{
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
    }

    public boolean isAllowedOrigin(String origin){
        return allowedOrigins.contains(origin);
    }
}
