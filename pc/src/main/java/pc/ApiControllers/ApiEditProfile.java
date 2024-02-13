package pc.ApiControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import pc.Model.User;
import pc.Service.UserService;

@RestController
public class ApiEditProfile {

    private final UserService userService;

    public ApiEditProfile(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/editProfile")
    public String showEditProfilePage(Model model) {
        // Fetch the current user details from the database
        User currentUser = userService.getCurrentUser();

        // Pass the user object to the Thymeleaf template
        model.addAttribute("user", currentUser);

        return "editProfile";
    }

    @PostMapping("/api/editProfile")
    public String editProfile(@ModelAttribute("user") User updatedUser) {
        // Update the user details in the database
        userService.updateUser(updatedUser);

        // Redirect to the profile page or any other page as needed
        return "redirect:/profile";
    }
}
