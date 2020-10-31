package ru.jun.al.haz.homeless.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jun.al.haz.homeless.animal.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
