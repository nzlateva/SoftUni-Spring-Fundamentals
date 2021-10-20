package bg.softuni.shoppinglist.service;

import bg.softuni.shoppinglist.model.service.UserServiceModel;

public interface UserService {
    
    UserServiceModel findByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    UserServiceModel register(UserServiceModel userServiceModel);

    void logout();
}
