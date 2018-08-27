package test.springMVC.integrate;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	public UserService(){
		System.out.println("this is userService!");
	}
	
	public void save(User u){
		System.out.println("save user success!!");
	}
}
