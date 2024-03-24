package tortora.spring.security.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encoder {

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
