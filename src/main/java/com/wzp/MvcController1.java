package com.wzp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class MvcController1 {
      
	//����ָ��
	@RequestMapping("/reqParam")
	public String testRequestParam(@RequestParam("code")Integer id,@RequestParam(value="namen",required=false)String name){
		System.out.println(id+"  "+name);
		return "hello";
	}
	
	//controller���쳣�ж�
	/*@ExceptionHandler
	public ModelAndView testError(Exception e){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("Exception", e);
		System.out.println("in testError!");
		return mv;
	}*/
	
	//�����쳣
	@RequestMapping("/err")
	public String err(){
		int i=1/0;
		return "hello";
	}
}
