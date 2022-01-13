package movier;

import movier.user.User;
import movier.user.UserRepository;
import movier.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService= userService;
    }

    @PostMapping("/api/register")
    String registerUser(@ModelAttribute User user) {
        return userService.registerUser(user);
    }
}
