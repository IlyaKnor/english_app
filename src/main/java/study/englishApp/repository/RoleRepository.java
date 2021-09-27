package study.englishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.englishApp.models.enums.ERole;
import study.englishApp.models.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsByName(ERole name);
    Role findByName(ERole name);
}
