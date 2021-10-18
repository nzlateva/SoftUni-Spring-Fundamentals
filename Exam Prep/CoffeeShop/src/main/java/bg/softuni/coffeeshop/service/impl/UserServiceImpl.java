package bg.softuni.coffeeshop.service.impl;

import bg.softuni.coffeeshop.model.entity.UserEntity;
import bg.softuni.coffeeshop.model.service.UserServiceModel;
import bg.softuni.coffeeshop.model.view.UserViewModel;
import bg.softuni.coffeeshop.repository.UserRepository;
import bg.softuni.coffeeshop.service.UserService;
import bg.softuni.coffeeshop.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        UserEntity userEntity = userRepository
                .findByUsernameAndPassword(username, password)
                .orElse(null);

        if (userEntity == null) {
            return null;
        }

        return modelMapper
                .map(userEntity, UserServiceModel.class);
    }

    @Override
    public void logout() {
        currentUser
                .setId(null)
                .setUsername(null);
    }

    @Override
    public List<UserViewModel> findAllUsersByCountOfOrdersDesc() {
        return userRepository
                .findAllByOrdersCountDesc()
                .stream()
                .map(userEntity -> modelMapper.map(userEntity, UserViewModel.class))
                .collect(Collectors.toList());
    }
}
