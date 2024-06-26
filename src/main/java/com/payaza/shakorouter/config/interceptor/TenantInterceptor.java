package com.payaza.shakorouter.config.interceptor;

import com.payaza.shakorouter.config.multitenant.TenantContext;
import com.payaza.shakorouter.util.exception.MissingHeaderAttributeException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TenantInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object object) {
        String tenantId = request.getHeader("X-Country-Code");
        if (tenantId == null || tenantId.isEmpty()) throw new MissingHeaderAttributeException("X-Country-Code header is required");
        TenantContext.setTenantId(tenantId);
        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                           @NonNull Object handler, ModelAndView modelAndView) {
        TenantContext.clear();
    }
}
