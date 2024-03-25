package pc.ApiControllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/")
public class ApiLoginController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ApiLoginController.class);

    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Implement your login logic here
        // Check credentials, validate user, etc.
        if (loginSuccessful(loginRequest.getUsername(), loginRequest.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    private boolean loginSuccessful(String username, String password) {
        // Dummy method, replace with actual login logic
        return "admin".equals(username) && "password".equals(password);
    }
}

 
    // Getters and setters