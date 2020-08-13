package demo.demo.Home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    
    @GetMapping
    public List<Home> getHome() {
        List<Home> homes = new ArrayList<>();
        homes.add(new Home("explain", "", "Powered by Spring Boot & MongoDB Atlas"));
        homes.add(new Home("getAll", "https://fathomless-cove-54226.herokuapp.com/api/users/", "hostname/api/users"));
        homes.add(new Home("getById", "https://fathomless-cove-54226.herokuapp.com/api/users/findById/5f3584030ad01b3e4e27e964", "hostname/api/users/findById/{id}"));
        homes.add(new Home("getByFirstName", "https://fathomless-cove-54226.herokuapp.com/api/users/findByFirstName/Luffy", "hostname/api/users/findByFirstName/{firstName}"));
        UserExample luffy = new UserExample("luffy@gmail.com", "Luffy", "Monkey D", 20);
        homes.add(new Home("addLuffy", "https://fathomless-cove-54226.herokuapp.com/api/users", "hostname/api/users",luffy));
        UserExample newLuffy = new UserExample("luffy@outlook.com", "new Luffy", "new Monkey D", 40);
        homes.add(new Home("updateUserById","https://fathomless-cove-54226.herokuapp.com/api/users/5f3583af0ad01b3e4e27e961","hostname/api/users",newLuffy));
        homes.add(new Home("deleteUserById", "https://fathomless-cove-54226.herokuapp.com/api/users/5f3583af0ad01b3e4e27e961", "hostname/api/users"));


        return homes;
    }
}