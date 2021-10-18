package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void login(Long id, String username);
}
