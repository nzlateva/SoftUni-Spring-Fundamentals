package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.model.service.UserServiceModel;
import bg.softuni.coffeeshop.model.view.UserViewModel;

import java.util.List;

public interface UserService {

    void login(UserServiceModel userServiceModel);

    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void logout();

    List<UserViewModel> findAllUsersByCountOfOrdersDesc();
}
