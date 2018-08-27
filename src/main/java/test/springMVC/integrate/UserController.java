package test.springMVC.integrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/integrate")
public class UserController {

	@Autowired
	public UserService userService;
	
	@RequestMapping("/save")
	public String save(@RequestBody @ModelAttribute User user){
		System.out.println(user);
		userService.save(user);
		return "hello";
	}
}
