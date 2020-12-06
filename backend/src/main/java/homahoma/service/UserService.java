package homahoma.service;

import homahoma.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id) throws Exception;

    void addUser(User user);

    List<User> getAllUser();

    void deleteUserById(Long id);

    void updateUser(User user) throws Exception;
}
