package pc.Service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pc.Model.User;
import pc.Data.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username);
    }

    public void updateUser(User updatedUser) {
        userRepository.save(updatedUser);
    }
}
