package pc.Service;

import java.sql.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pc.Model.Email;
import pc.Model.ResetToken;
import pc.Model.User;
import pc.Data.ResetTokenRepository;
import pc.Data.UserRepository;

/**
 * Service class for managing user-related functionality.
 */
@Service
public class UserService {

    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResetTokenRepository resetTokenRepository;
    @Autowired
    private EmailService emailService;

    public void requestPasswordReset(String email) {
        User user = userRepository.findUserByUsername(email);
        if (user != null) {
            String token = UUID.randomUUID().toString();
            createResetTokenForUser(user, token);
            sendPasswordResetEmail(user, token);
        }
    }
    private void createResetTokenForUser(User user, String token) {
        ResetToken resetToken = new ResetToken();
        resetToken.setToken(token);
        resetToken.setUser(user);
        resetToken.setExpiryDate(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)); // 24 hours
        resetTokenRepository.save(resetToken);
    }
    private void sendPasswordResetEmail(User user, String token) {
        String resetLink = "http://localhost:8080/reset-password?token=" + token; // Example for local development
        // For production, replace "localhost:8080" with your actual domain name and port

        // Construct the email message with the reset link
        String emailMessage = "Hello,\n\n"
                + "You have requested to reset your password. Please click the link below to reset your password:\n\n"
                + resetLink + "\n\n"
                + "If you did not request a password reset, you can safely ignore this email.\n\n"
                + "Best regards,\n"
                + "Your Application Team";

        // Create an Email object and send it using the EmailService
        Email resetEmail = new Email();
        resetEmail.setTo(user.getUsername());
        resetEmail.setSubject("Password Reset Request");
        resetEmail.setMessage(emailMessage);
        emailService.sendMail(resetEmail);
    }


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
