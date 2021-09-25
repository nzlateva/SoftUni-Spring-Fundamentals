package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void initializeUsers() {
        if (userRepository.count() == 0) {
            UserEntity admin = new UserEntity();
            admin
                    .setUsername("admin")
                    .setPassword(passwordEncoder.encode("123"))
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setActive(true);

            userRepository.save(admin);

            UserEntity user = new UserEntity();
            user
                    .setUsername("user")
                    .setPassword(passwordEncoder.encode("123"))
                    .setFirstName("User")
                    .setLastName("Userov")
                    .setActive(true);

            userRepository.save(user);
        }
    }

    @Override
    public boolean login(String username, String password) {

        return false;
    }
}
