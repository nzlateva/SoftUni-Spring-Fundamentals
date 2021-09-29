package bg.softuni.pathfinder.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String firstName;

    @ManyToMany
    private Set<UserRoleEntity> roles;
}
