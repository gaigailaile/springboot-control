package com.gai.shiro.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.AuthenticationException;

/**
 * Created by gaigaicoming on 2019/11/1.
 */
@ControllerAdvice
public class ExceptionCotroller {
    @ExceptionHandler(AuthenticationException.class)
    public ModelAndView error(AuthenticationException e){
        ModelAndView mv = new ModelAndView("unauthorized");
        mv.addObject("error",e.getMessage());
        return mv;
    }
}
