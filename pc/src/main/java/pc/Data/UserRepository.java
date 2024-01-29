package pc.Data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pc.Model.User;


@Repository
public interface UserRepository extends CrudRepository<User,String>{
	
	User findUserByUsername(String username);
	
	Optional<User> findById(String username);
	
	

}
