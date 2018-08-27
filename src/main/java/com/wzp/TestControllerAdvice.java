package com.wzp;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class TestControllerAdvice {

	@ExceptionHandler
	public ModelAndView testErrAdvice(Exception ex){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		System.out.println("in ControllerAdvice");
		return mv;
	}
}
