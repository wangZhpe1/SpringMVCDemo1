package com.wzp;

import java.beans.PropertyEditor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HttpServletBean;

import com.wzp.binder.DateEditor;
import com.wzp.entities.Person;

@Controller
@RequestMapping("/mvc")
public class MvcController {
 
	@RequestMapping("/hello.do")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping("/person1")
	public String toPerson(Person p){
		System.out.println(p.toString());
		return "hello";
	}
	
	@RequestMapping("/date")
	public String toDate(Date date){
		System.out.println(date);
		return "hello";
	}
	
	@RequestMapping("/integer")
	public String toIngeger(Integer i){
		System.out.println(i);
		return "hello";
	}
	
	@InitBinder
	public void intBinder(ServletRequestDataBinder bind){
		bind.registerCustomEditor(Date.class, new DateEditor());
	}

	@RequestMapping("/show")
	public String showPerson(Map<String, Object> p){
		Person person = new Person();
		person.setAge(22);
		person.setName("wzp");
		p.put("pp", person);
		return "show";
	}
	
	
	//测试ajax请求数据
	@RequestMapping("/getPerson")
	public void getPerson(String name,PrintWriter pw){
		pw.write("hello,"+name);
	}
	
	//重定向
	@RequestMapping("/redirect")
	public String redirect(){
		return "redirect:hello.do";
	}
	
	//文件上传
	@RequestMapping(value="upload",method=RequestMethod.POST)
	public String upload(HttpServletRequest req) throws Exception{
		MultipartHttpServletRequest mrq=(MultipartHttpServletRequest) req;
		MultipartFile file = mrq.getFile("file");
		String filename = file.getOriginalFilename();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String str=req.getSession().getServletContext().getRealPath("/")+"upload/"+format.format(new Date());
		str+=filename.substring(filename.lastIndexOf('.'));
		FileOutputStream fileOutputStream = new FileOutputStream(str);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.flush();
		fileOutputStream.close();
		return "hello";
	}
	
}
