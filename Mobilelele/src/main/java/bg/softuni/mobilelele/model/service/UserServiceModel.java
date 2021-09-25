package bg.softuni.mobilelele.model.service;

import java.util.List;

public class UserServiceModel {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private Boolean isActive;
    private List<UserRoleServiceModel> roles;
    private String imageUrl;

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public UserServiceModel setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public List<UserRoleServiceModel> getRoles() {
        return roles;
    }

    public UserServiceModel setRoles(List<UserRoleServiceModel> roles) {
        this.roles = roles;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
