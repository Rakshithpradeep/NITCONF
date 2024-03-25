package apiControllerTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import pc.ApiControllers.ApiLoginController;
import pc.ApiControllers.LoginRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ApiLoginControllerTest {

    @InjectMocks
    private ApiLoginController controller;

    @Test
    public void testLogin_Successful() {
        // Arrange
        LoginRequest validLoginRequest = new LoginRequest();
        validLoginRequest.setUsername("admin");
        validLoginRequest.setPassword("password");

        // Act
        ResponseEntity<String> responseEntity = controller.login(validLoginRequest);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Login successful", responseEntity.getBody());
    }

    @Test
    public void testLogin_Unsuccessful() {
        // Arrange
        LoginRequest invalidLoginRequest = new LoginRequest();
        invalidLoginRequest.setUsername("invalidUser");
        invalidLoginRequest.setPassword("invalidPassword");

        // Act
        ResponseEntity<String> responseEntity = controller.login(invalidLoginRequest);
        System.out.println(responseEntity.getBody());
        // Assert
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
        assertEquals("Login failed", responseEntity.getBody());
    }
   

}