package com.cy.exception;

import com.cy.entity.EmployeeException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        // 解析出异常类型
        EmployeeException customException = null;
        // 若该异常类型是系统自定义的异常，直接取出异常信息在错误页面展示即可。
        if (e instanceof EmployeeException) {
            customException = (EmployeeException)e;
        } else {
            // 如果不是系统自定义异常，构造一个系统自定义的异常类型，信息为“未知错误”
            customException = new EmployeeException("未知错误");
        }
        //错误信息
        String message = customException.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        //将错误信息传到页面
        modelAndView.addObject("message", message);
        //指向错误页面
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
