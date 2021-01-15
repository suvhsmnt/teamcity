package ai.fluid.teamcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/user")
public class UserDetailsController {

	@Autowired
	private UserDetailsService userService;
	
	@GetMapping
	public String hello()
	{
		System.out.println("Hellow");
		return "Yes it's working ";
	}

	@PostMapping(value = "/addUser")
	public UserDetails addUser(@RequestBody UserWrapper userWrapper) {
		return userService.addUser(new UserDetails(userWrapper));
	}

	@GetMapping(value = "/getAllUsers")
	public List<UserDetails> getAllUser() {
		return userService.getAllUsers();
	}
	
	@GetMapping(value = "/getUser")
	public UserDetails getUser(@RequestParam Long id) {
		return userService.userById(id);
	}

	@DeleteMapping(value = "/deleteUser")
	public boolean deleteUser(@RequestBody IdWrapper idWrapper) {
		return userService.deletUser(idWrapper.getId());
	}
}
