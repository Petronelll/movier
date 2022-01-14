package movier.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(User user) {
        String message;
        if (userRepository.findUserByUsername(user.getUsername()) != null)
            message = "Invalid username";
        else if (userRepository.findUserByEmail(user.getEmail()) != null)
            message = "Invalid email";
        else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            //userRepository.save(user);
            userRepository.insertUser(user.getUsername(), user.getEmail(), user.getPassword());
            message = "Ok";
        }
        return message;
    }
}
