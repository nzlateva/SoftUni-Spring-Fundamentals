package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.entity.UserRoleEntity;
import bg.softuni.mobilelele.model.entity.enums.UserRoleEnum;
import bg.softuni.mobilelele.model.service.UserServiceModel;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.service.UserService;
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

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
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
            return false;
        }

        return passwordEncoder.matches(
                userServiceModel.getPassword(),
                userEntity.get().getPassword()
        );
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        Optional<UserEntity> userEntity = userRepository
                .findByUsername(userServiceModel.getUsername());

        if (userEntity.isPresent()) {
            throw new IllegalStateException(
                    "User with username " + userServiceModel.getUsername() + " already exists!"
            );
        }

        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        UserRoleEntity userRole = userRoleRepository
                .findByRole(UserRoleEnum.USER)
                .orElse(null);

        user
                .setPassword(passwordEncoder.encode(userServiceModel.getPassword()))
                .setActive(true)
                .setRoles(Set.of(userRole));

        userRepository.save(user);
    }
}
