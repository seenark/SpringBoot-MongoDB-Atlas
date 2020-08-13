package demo.demo.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // CREATE 
    public void createUser(UserModel user) {
        userRepository.save(user);
    }

    // RETRIEVE
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<List<UserModel>> getUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
    public Optional<UserModel> getUserById(String id) {
        return this.userRepository.findById(id);
    }

    // UPDATE
    public void updateUser(UserModel user) {
        userRepository.save(user);
    }

    // DELETE
    public void deleteAll() {
        userRepository.deleteAll();
    }
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}