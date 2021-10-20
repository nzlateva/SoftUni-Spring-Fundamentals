package bg.softuni.shoppinglist.service.impl;

import bg.softuni.shoppinglist.model.entity.UserEntity;
import bg.softuni.shoppinglist.model.service.UserServiceModel;
import bg.softuni.shoppinglist.repository.UserRepository;
import bg.softuni.shoppinglist.service.UserService;
import bg.softuni.shoppinglist.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser
                .setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername());
    }

    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        UserEntity userEntity = userRepository.save(modelMapper
                .map(userServiceModel, UserEntity.class));

        return modelMapper
                .map(userEntity, UserServiceModel.class);
    }

    @Override
    public void logout() {
        currentUser
                .setId(null)
                .setUsername(null);
    }
}
