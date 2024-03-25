package pc.ApiControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiLogoutController {

    @GetMapping("/api/logout")
    public String logout() {
        // Perform logout-related operations here, such as clearing tokens
        // Note: In a real-world scenario, you might need to invalidate sessions, clear cookies, or perform other cleanup tasks.
        return "Logged out successfully";
    }
}