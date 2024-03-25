package pc.ApiControllers;

import org.springframework.web.bind.annotation.*;
import pc.Model.User;
import pc.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ApiEditProfile {

    private final UserService userService;

    @Autowired
    public ApiEditProfile(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/api/profile")
    public String updateProfile(@RequestBody User updatedUser) {
        // Update the user details in the database
        userService.updateUser(updatedUser);

        return "Profile updated successfully";
    }
}