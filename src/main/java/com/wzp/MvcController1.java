package com.wzp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class MvcController1 {
      
	//参数指定
	@RequestMapping("/reqParam")
	public String testRequestParam(@RequestParam("code")Integer id,@RequestParam(value="namen",required=false)String name){
		System.out.println(id+"  "+name);
		return "hello";
	}
	
	//controller内异常判定
	/*@ExceptionHandler
	public ModelAndView testError(Exception e){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("Exception", e);
		System.out.println("in testError!");
		return mv;
	}*/
	
	//产生异常
	@RequestMapping("/err")
	public String err(){
		int i=1/0;
		return "hello";
	}
}
