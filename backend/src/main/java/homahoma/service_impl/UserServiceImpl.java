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
    public User getUserById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void addUser(User user) {
        //заменить логгером
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            //заменить логгером
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateUser(User newUser) throws Exception {
        userRepository.findById(newUser.getId()).map(user -> {
            user.setLogin(newUser.getLogin());
            user.setPassword(newUser.getPassword());
            user.setEmail(newUser.getEmail());
            user.setSurname(newUser.getSurname());
            user.setName(newUser.getName());
            return userRepository.save(newUser);
        }).orElseThrow(Exception::new);
    }
}
