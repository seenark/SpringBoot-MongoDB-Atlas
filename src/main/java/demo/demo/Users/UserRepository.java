package demo.demo.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String>{
    public Optional<List<UserModel>> findByFirstName(String name);
}