package com.wzp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wzp.entities.Person;

@Controller
@RequestMapping("/json")
public class JsonTest {

	@ResponseBody
	@RequestMapping("/user")
	public Person testJson(){
		Person p = new Person();
		p.setAge(5);
		p.setName("wxp");
		return p;
	}
}
