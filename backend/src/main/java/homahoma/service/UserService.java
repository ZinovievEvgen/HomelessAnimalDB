package homahoma.service;

import homahoma.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    void addUser(User user);

    List<User> getAllUser();

    void deleteUserById(Long id);

    void updateUser(User user);
}
