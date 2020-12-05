package homahoma.service_impl;

import homahoma.model.User;
import homahoma.repository.UserRepository;
import homahoma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public void updateUser(User user) {

    }
}
