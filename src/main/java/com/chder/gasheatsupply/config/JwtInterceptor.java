package com.chder.gasheatsupply.config;

import com.chder.gasheatsupply.utils.JwtUtils;
import com.chder.gasheatsupply.utils.SpringContextHolder;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    private static JwtUtils jwtUtils = SpringContextHolder.getBean(JwtUtils.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        try {
            String token = request.getHeader("Authorization");
            if (StringUtils.isEmpty(token)) {
                throw new RuntimeException("Token缺失");
            }
            Claims claims = jwtUtils.parseToken(token);
            request.setAttribute("user", claims.getSubject());
            return true;
        } catch (ExpiredJwtException e) {
            sendJsonResponse(response, 401, "Token已过期");
            return false;
        } catch (MalformedJwtException e) {
            sendJsonResponse(response, 401, "Token格式错误");
            return false;
        }
    }

    private void sendJsonResponse(HttpServletResponse response, int code, String msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println("{\"code\":" + code + ", \"msg\":\"" + msg + "\"}");
    }
}

