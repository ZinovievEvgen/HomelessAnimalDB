package ru.jun.al.haz.homeless.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jun.al.haz.homeless.animal.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
