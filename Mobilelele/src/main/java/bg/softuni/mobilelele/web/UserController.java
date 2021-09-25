package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.UserLoginBindingModel;
import bg.softuni.mobilelele.model.binding.UserRegisterBindingModel;
import bg.softuni.mobilelele.model.entity.enums.UserRoleEnum;
import bg.softuni.mobilelele.model.service.UserServiceModel;
import bg.softuni.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserController.class);

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginConfirm(UserLoginBindingModel userLoginBindingModel) {

        UserServiceModel userServiceModel = modelMapper
                .map(userLoginBindingModel, UserServiceModel.class);

        boolean loginSuccessful = userService.login(userServiceModel);

        LOGGER.info("User with name {} tried to login. Login successful = {}",
                userServiceModel.getUsername(),
                loginSuccessful);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerConfirm(UserRegisterBindingModel userRegisterBindingModel) {

        UserServiceModel userServiceModel = modelMapper
                .map(userRegisterBindingModel, UserServiceModel.class);

        userService.register(userServiceModel);

        return "redirect:/";
    }
}
