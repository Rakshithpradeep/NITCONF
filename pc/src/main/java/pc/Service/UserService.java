package pc.Service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pc.Model.User;
import pc.Data.UserRepository;

/**
 * Service class for managing user-related functionality.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructor with UserRepository injection.
     *
     * @param userRepository The repository for managing User entities.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves the current user from the security context.
     *
     * @return The current user.
     */
    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findUserByUsername(username);
    }

    /**
     * Updates the information of a user.
     *
     * @param updatedUser The updated User object.
     */
    public void updateUser(User updatedUser) {
        userRepository.save(updatedUser);
    }
}
