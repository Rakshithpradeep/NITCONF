package ControllersTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pc.Controller.EditProfileController;
import pc.Model.User;
import pc.Service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class editProfileTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private EditProfileController editProfileController;

    @Mock
    private Model model;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
<<<<<<< Upstream, based on branch 'main' of git@github.com:Rakshithpradeep/NITCONF.git
    @Test
    public void testShowEditProfilePage() {
        // Mock data
        User currentUser = new User("rakshith", "password", "rakshith");
        when(userService.getCurrentUser()).thenReturn(currentUser);

        // Call controller method
        String viewName = editProfileController.showEditProfilePage(model);

        // Verify that correct user object is added to the model
        verify(model, times(1)).addAttribute("user", currentUser);

        // Verify that the correct view name is returned
        assertEquals("editProfile", viewName);
    }
=======
>>>>>>> 01c1abf test controller

    @Test
    public void testEditProfile() {
        // Mock data
        User currentUser = new User("testUser", "password", "John Doe");
        User updatedUser = new User("testUser", "newPassword", "Jane Doe");

<<<<<<< Upstream, based on branch 'main' of git@github.com:Rakshithpradeep/NITCONF.git
        // Call controller method
        String viewName = editProfileController.editProfile(updatedUser);

        // Verify that updateUser method of UserService is called
        verify(userService, times(1)).updateUser(updatedUser);

        // Verify that correct redirect view name is returned
        assertEquals("redirect:/profile", viewName);
    }
    @Test
    public void testUserEditProfile() {
        // Mock data
        User currentUser = new User("rakshith", "password", "rakshith");
        User updatedUser = new User("rakshith", "newPassword", "rakshith");

        // Mock UserService behavior
        when(userService.getCurrentUser()).thenReturn(currentUser);

        // Call controller method
        String viewName = editProfileController.editProfile(updatedUser);

        // Verify that updateUser method of UserService is called with the updated user
        verify(userService, times(1)).updateUser(updatedUser);

        // Verify that the updated user object matches the one passed to updateUser method
        verify(userService).updateUser(argThat(argument -> argument.getUsername().equals(updatedUser.getUsername()) &&
                                                           argument.getPassword().equals(updatedUser.getPassword()) &&
                                                           argument.getName().equals(updatedUser.getName())));

        // Verify that correct redirect view name is returned
        assertEquals("redirect:/profile", viewName);
    }
//    @Test
//    public void testFailEditProfile() {
//        // Mock data
//        User currentUser = new User("rakshith", "password", "rakshith");
//        User updatedUser = new User("rakshith", "newPassword", "rakshith");
//
//        // Mock UserService behavior
//        when(userService.getCurrentUser()).thenReturn(currentUser);
//
//        // Call controller method
//        String viewName = editProfileController.editProfile(updatedUser);
//
//        // Verify that updateUser method of UserService is called with the updated user
//        verify(userService, times(1)).updateUser(updatedUser);
//
//        // Verify that the updated user object matches the one passed to updateUser method
//        verify(userService).updateUser(argThat(argument -> argument.getUsername().equals(updatedUser.getUsername()) &&
//                                                           argument.getPassword().equals(updatedUser.getPassword()) &&
//                                                           argument.getName().equals(updatedUser.getName())));
//
//        // Verify that correct redirect view name is returned
//        assertEquals("redirect:/profile", viewName);
//
//        // Modify the updatedUser object to simulate incorrect update
//        updatedUser.setPassword("incorrectPassword");
//
//        // Call the controller method again
//        viewName = editProfileController.editProfile(updatedUser);
//
//        // Verify that updateUser method of UserService is called with the updated user
//        verify(userService, times(2)).updateUser(updatedUser);
//
//        // Verify that the updated user object doesn't match the one passed to updateUser method
//        verify(userService, never()).updateUser(argThat(argument -> argument.getUsername().equals(updatedUser.getUsername()) &&
//                                                                    argument.getPassword().equals(updatedUser.getPassword()) &&
//                                                                    argument.getName().equals(updatedUser.getName())));
//
//        // Verify that correct redirect view name is returned
//        assertEquals("redirect:/profile", viewName); // This will fail as the password is incorrect
//    }
=======
        // Mock UserService behavior
        when(userService.getCurrentUser()).thenReturn(currentUser);

        // Call controller method
        String viewName = editProfileController.editProfile(updatedUser);

        // Verify that updateUser method of UserService is called with the updated user
        verify(userService, times(1)).updateUser(updatedUser);

        // Verify that the updated user object matches the one passed to updateUser method
        verify(userService).updateUser(argThat(argument -> argument.getUsername().equals(updatedUser.getUsername()) &&
                                                           argument.getPassword().equals(updatedUser.getPassword()) &&
                                                           argument.getName().equals(updatedUser.getName())));

        // Verify that correct redirect view name is returned
        assertEquals("redirect:/profile", viewName);

        // Modify the updatedUser object to contain correct password information
        updatedUser.setPassword("password");

        // Call the controller method again
        viewName = editProfileController.editProfile(updatedUser);

        // Verify that updateUser method of UserService is called with the updated user
        verify(userService, times(2)).updateUser(updatedUser);

        // Verify that the updated user object matches the one passed to updateUser method
        verify(userService).updateUser(argThat(argument -> argument.getUsername().equals(updatedUser.getUsername()) &&
                                                           argument.getPassword().equals(updatedUser.getPassword()) &&
                                                           argument.getName().equals(updatedUser.getName())));

        // Verify that correct redirect view name is returned
        assertEquals("redirect:/profile", viewName); // This should pass now
    }
>>>>>>> 01c1abf test controller
}
