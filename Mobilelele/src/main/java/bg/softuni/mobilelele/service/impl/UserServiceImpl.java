package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.entity.UserRoleEntity;
import bg.softuni.mobilelele.model.entity.enums.UserRoleEnum;
import bg.softuni.mobilelele.model.service.UserServiceModel;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void initializeUsers() {
        if (userRepository.count() == 0) {
            UserRoleEntity adminRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN)
                    .orElseThrow(IllegalArgumentException::new);

            UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER)
                    .orElseThrow(IllegalArgumentException::new);

            UserEntity admin = new UserEntity();
            admin
                    .setUsername("admin")
                    .setPassword(passwordEncoder.encode("123"))
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setActive(true)
                    .setRoles(Set.of(adminRole, userRole));

            userRepository.save(admin);

            UserEntity user = new UserEntity();
            user
                    .setUsername("user")
                    .setPassword(passwordEncoder.encode("123"))
                    .setFirstName("User")
                    .setLastName("Userov")
                    .setActive(true)
                    .setRoles(Set.of(userRole));

            userRepository.save(user);
        }
    }

    @Override
    public boolean login(UserServiceModel userServiceModel) {

        Optional<UserEntity> userEntity = userRepository
                .findByUsername(userServiceModel.getUsername());

        if (userEntity.isEmpty()) {
            logout();
            return false;
        }

        boolean success = passwordEncoder.matches(
                userServiceModel.getPassword(),
                userEntity.get().getPassword());

        if (success) {
            UserEntity loggedInUser = userEntity.get();
            login(loggedInUser);
        }

        return success;
    }

    @Override
    public void logout() {
        currentUser.clear();
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);

        userEntity.setPassword(
                passwordEncoder.encode(userServiceModel.getPassword()));

        userEntity.setActive(true);

        UserRoleEntity userRole = userRoleRepository
                .findByRole(UserRoleEnum.USER)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));
        userEntity.setRoles(Set.of(userRole));

        UserEntity newUser = userRepository.save(userEntity);

        login(newUser);
    }


    @Override
    public boolean existsByUsername(String username) {
        return userRepository
                .findByUsernameIgnoreCase(username)
                .isPresent();
    }


    private void login(UserEntity loggedInUser) {
        currentUser
                .setLoggedIn(true)
                .setUsername(loggedInUser.getUsername())
                .setFirstName(loggedInUser.getFirstName())
                .setLastName(loggedInUser.getLastName());

        loggedInUser
                .getRoles()
                .forEach(role -> currentUser.addRole(role.getRole()));
    }
}
