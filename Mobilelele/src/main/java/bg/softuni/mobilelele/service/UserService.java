package bg.softuni.mobilelele.service;

public interface UserService {

    void initializeUsers();

    boolean login(String username, String password);
}
