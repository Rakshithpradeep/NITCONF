package ControllersTest;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;
import pc.Controller.MailController;
import pc.Model.Email;
import pc.Service.EmailService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MailControllerTest {

    @Mock
    private EmailService emailService;

    @Mock
    private HttpSession httpSession;

    @Test
    void sendMailPageTest() {
        MailController controller = new MailController(emailService);
        assertEquals("sendMail", controller.sendMailPage());
    }

    @Test
    void sendMailTest() {
        MailController controller = new MailController(emailService);
        Email email = new Email();
        email.setTo("recipient@example.com");
        email.setSubject("Test Subject");
        email.setMessage("Test Message");

        String result = controller.sendMail(email, httpSession);

        Mockito.verify(emailService, Mockito.times(1)).sendMail(email);
        Mockito.verify(httpSession, Mockito.times(1)).setAttribute("msg", "Email sent successfully");
        assertEquals("sendMail", result);
    }
}
