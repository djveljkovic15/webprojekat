package database.user;

import java.util.List;

@SuppressWarnings("Duplicates")
public class UserService {

    public User save(User user){
        return UserRepository.save(user);
    }
    public User update(User user){
        return UserRepository.update(user);
    }
    public void deleteById(Long id) throws Exception {
        UserRepository.deleteById(id);
    }
    public User findById(Long id) throws Exception {
        return UserRepository.findById(id);
    }
    public List<User> findAll(){
        return UserRepository.findAll();
    }

    public User login(String username, String password){
        return UserRepository.findAll().stream()
                .filter(user ->
                        user.getUsername().equals(username)&&user.getPassword().equals(password))
                .findFirst().orElse(null);
    }

}

