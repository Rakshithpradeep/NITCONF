package apiControllerTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pc.ApiControllers.ApiEditProfile;
import pc.Model.User;
import pc.Service.UserService;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ApiProfileControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private ApiEditProfile apiEditProfile;

    @Test
    public void testUpdateProfile() {
        // Arrange
        User updatedUser = new User();
        updatedUser.setUsername("updatedUser");

        // Act
        String result = apiEditProfile.updateProfile(updatedUser);

        // Assert
        assertEquals("Profile updated successfully", result); // Assert return value

        // Verify that the UserService's updateUser method is called with the updatedUser object
        verify(userService, times(1)).updateUser(updatedUser);
    }
}