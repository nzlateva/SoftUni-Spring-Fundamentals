package bg.softuni.mobilelele.model.binding;

import bg.softuni.mobilelele.model.entity.UserRoleEntity;

import java.util.Set;

public class UserRegisterBindingModel {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private Set<UserRoleEntity> roles;

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserRegisterBindingModel setRoles(Set<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}
