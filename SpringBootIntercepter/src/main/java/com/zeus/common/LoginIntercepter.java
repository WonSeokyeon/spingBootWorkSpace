package com.zeus.common;


import java.lang.reflect.Method;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class LoginIntercepter implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	log.info("/login~~ preHandle()"+request.getRequestURI());
	HandlerMethod method =(HandlerMethod)handler;
	Method methodobj = method.getMethod();
	
	log.info("/login~~ preHandle() bean"+method.getBean());
	log.info("/login~~ preHandle() method"+methodobj);
	// 세션이 존재유무 체크 : 세션(전역객체 MAP ->키값 : 밸류객체)
    HttpSession session = request.getSession();
    if (session.getAttribute("userInfo") != null) {
        session.removeAttribute("user_info");
    }
    return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
		log.info("/login~~ postHandle()"+request.getRequestURI());
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		HandlerMethod method =(HandlerMethod)handler;
		
		Method methodobj = method.getMethod();
		
		log.info("/login~~ postHandle() bean"+method.getBean());
		log.info("/login~~ postHandle() method"+methodobj);
		
		  HttpSession session = request.getSession();
		  ModelMap modelMap= modelAndView.getModelMap();
		  Object member = modelMap.get("member"); 

		  if (member !=null)
		     log.info("/log~~postHandle() member = " + member);
		     session.setAttribute("userInfo", member);
		     response.sendRedirect("/home");
		  }

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		
		log.info("/login~~ afterCompletion()");
		HandlerMethod method =(HandlerMethod)handler;
		Method methodobj = method.getMethod();
		log.info("/login~~ afterCompletion() bean"+method.getBean());
		log.info("/login~~ afterCompletion() method"+methodobj);

	}




}
