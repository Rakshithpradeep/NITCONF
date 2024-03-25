package apiControllerTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import pc.ApiControllers.ApiLogoutController;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ApiLogoutControllerTest {

    @InjectMocks
    private ApiLogoutController apiLogoutController;

    @Test
    public void testLogout() {
        // Act
        String result = apiLogoutController.logout();

        // Assert
        assertEquals("Logged out successfully", result); // Assert return value
    }
}