package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.UserLoginBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginConfirm(UserLoginBindingModel userLoginBindingModel) {

        return "redirect:/index";
    }
}