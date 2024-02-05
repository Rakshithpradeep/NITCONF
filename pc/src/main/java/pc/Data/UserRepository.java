package pc.Data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pc.Model.User;


@Repository
public interface UserRepository extends JpaRepository<User,String>{
	
	User findByUsername(String username);
	
	Optional<User> findById(String username);
	
	

}
