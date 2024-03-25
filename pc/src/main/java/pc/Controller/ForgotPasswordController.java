//package pc.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import pc.Service.UserService;
//
//@Controller
//public class ForgotPasswordController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/forgotpassword")
//    public String forgotPassword(@RequestParam("email") String email) {
//        userService.requestPasswordReset(email);
//        // Redirect to a confirmation page or display a message that the reset link has been sent
//        return "redirect:/forgotpassword";
//    }
//}
