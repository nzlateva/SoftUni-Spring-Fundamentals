package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entity.UserRoleEntity;
import bg.softuni.pathfinder.model.entity.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    Optional<UserRoleEntity> findByRole(UserRoleEnum role);
}
