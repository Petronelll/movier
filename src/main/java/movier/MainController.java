package movier;

import movier.user.User;
import movier.user.UserRepository;
import movier.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService= userService;
    }

    @GetMapping(value = "/signup", produces = "text/html")
    String signupUser() {
        return "signup";
    }

    @PostMapping(value = "/signup", produces = "text/html")
    String registerUser(@ModelAttribute User user, Model model) {
        String message = userService.registerUser(user);
        if (message.equals("ok")) return "success";
        else {
            model.addAttribute("reason", message);
            return "error";
        }
    }
}
