package ai.fluid.teamcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsDao userDao;

	public UserDetails addUser(UserDetails userDetails) {
		return userDao.save(userDetails);
	}

	public List<UserDetails> getAllUsers() {
		return userDao.findAll();
	}

	public boolean deletUser(long id) {
		return true;
	}

	// Error code -> UDS00(01-10)
	public UserDetails userById(long id) {
		UserDetails userDetails=userDao.findById(id);
		if(userDetails == null)
		{
			throw new GenericException(500, "UDS0001", "Sorry No user found with id: "+id);
		}
		return userDetails;
	}

}
