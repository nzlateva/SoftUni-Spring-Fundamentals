package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.service.UserServiceModel;

public interface UserService {

    void initializeUsers();

    boolean login(UserServiceModel userServiceModel);

    void register(UserServiceModel userServiceModel);

    void logout();

    boolean existsByUsername(String username);
}
