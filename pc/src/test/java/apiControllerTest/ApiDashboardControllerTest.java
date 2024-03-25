package apiControllerTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pc.ApiControllers.ApiDashboardController;
import pc.Data.UserRepository;
import pc.Model.User;
import java.security.Principal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApiDashboardControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ApiDashboardController controller;

    @Test
    public void testGetDashboardInfo_UserFound() {
        // Arrange
        String username = "testUser";
        User mockUser = new User();
        mockUser.setUsername(username);
        when(userRepository.findUserByUsername(username)).thenReturn(mockUser);

        // Mock Principal
        Principal principal = () -> username;

        // Act
        User result = controller.getDashboardInfo(principal);

        // Assert
        assertEquals(username, result.getUsername());
    }

    @Test
    public void testGetDashboardInfo_UserNotFound() {
        // Arrange
        String username = "nonExistingUser";
        when(userRepository.findUserByUsername(username)).thenReturn(null);

        // Mock Principal
        Principal principal = () -> username;

        // Act and Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            controller.getDashboardInfo(principal);
        });

        assertEquals("User not found", exception.getMessage());
    }
}