package pc.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pc.Data.UserRepository;
import pc.Model.User;

@Service
public class SecurityUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	private UserRepository userRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) {
		
		
		User user = userRepository.findUserByUsername(username);
		
		if(user!= null)
			return user;
		
		throw new UsernameNotFoundException("Username Not Found");
	} 
	
	
}