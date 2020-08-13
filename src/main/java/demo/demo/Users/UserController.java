package demo.demo.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.demo.Exception.UserException;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/findByFirstName/{firstName}")
    public UserModel getUserByFirstName(@PathVariable(name = "firstName") String firstName) {
        Optional<UserModel> user = userService.getUserByFirstName(firstName);
        if (user.isPresent()) {
            return user.get();
        }else{
            throw new UserException(firstName);
        }
    }

    @GetMapping(path = "/findById/{id}")
    public UserModel getUserById(@PathVariable(name = "id") String id) {
        Optional<UserModel> user = this.userService.getUserById(id);
        if (user.isPresent()) {
            return user.get();
        }else{
            throw new UserException(id);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addUser(@RequestBody UserModel user) {
        this.userService.createUser(user);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/{id}")
    public void updateUser(@PathVariable(name = "id") String id, @RequestBody UserModel user) {
        if (this.userService.getUserById(id).isPresent()) {
            UserModel newUser = new UserModel(id, user.firstName, user.lastName, user.email, user.age);
            this.userService.updateUser(newUser);
        }else{
            throw new UserException(id);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable(name = "id") String id) {
        if (this.userService.getUserById(id).isPresent()) {
            this.userService.deleteUserById(id);
        }else{
            throw new UserException(id);
        }
        
    }

    
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        this.userService.deleteAll();
    }



}