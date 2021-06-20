package alekseev.todo.service;

import alekseev.todo.model.UserProfile;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void add(UserProfile userProfile);
    UserProfile getByUsername(String username);

}
