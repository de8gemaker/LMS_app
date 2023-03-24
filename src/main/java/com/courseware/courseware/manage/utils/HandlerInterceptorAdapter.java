package com.courseware.courseware.manage.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org. springframework.web.servlet.ModelAndView;

public abstract class HandlerInterceptorAdapter implements AsyncHandlerInterceptor {

    public HandlerInterceptorAdapter() {
    }

    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler)
            throws Exception {
        return true;
    }
    public void postHandler(HttpServletRequest request, HttpServletResponse response,Object handler,
                            ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion (HttpServletRequest request,HttpServletResponse response,
                                 Object handle, Exception ex) throws Exception {
    }

    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response,
                                               Object handler) throws Exception {
    }
}
