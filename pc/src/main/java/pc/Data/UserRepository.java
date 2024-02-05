package pc.Data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pc.Model.User;

/**
 * Repository interface for managing User entities.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * Finds a user by username.
     *
     * @param username The username of the user to find.
     * @return The User object if found, or null if not found.
     */
    User findUserByUsername(String username);

    /**
     * Finds a user by their unique identifier (username).
     *
     * @param username The unique identifier of the user.
     * @return An Optional containing the User object if found, or an empty Optional if not found.
     */
    Optional<User> findById(String username);
}
