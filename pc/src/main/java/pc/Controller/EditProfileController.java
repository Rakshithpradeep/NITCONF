package pc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pc.Model.User;
import pc.Service.UserService;

@Controller
public class EditProfileController {

    private final UserService userService;

    public EditProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/editProfile")
    public String showEditProfilePage(Model model) {
        // Fetch the current user details from the database
        User currentUser = userService.getCurrentUser();

        // Pass the user object to the Thymeleaf template
        model.addAttribute("user", currentUser);

        return "editProfile";
    }

    @PostMapping("/editProfile")
    public String editProfile(@ModelAttribute("user") User updatedUser) {
        // Update the user details in the database
        userService.updateUser(updatedUser);

        // Redirect to the profile page or any other page as needed
        return "redirect:/profile";
    }
}
