package bg.softuni.mobilelele.model.service;

import bg.softuni.mobilelele.model.entity.enums.UserRoleEnum;

public class UserRoleServiceModel {

    private Long id;
    private UserRoleEnum role;

    public Long getId() {
        return id;
    }

    public UserRoleServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public UserRoleServiceModel setRole(UserRoleEnum role) {
        this.role = role;
        return this;
    }
}
