package hr.ja.weboo;

import hr.ja.weboo.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class InitData {

    @PostConstruct
    public void initUser() {
        for (int i = 0; i < 32; i++) {
            User u = new User(i, "user " + i);
            u.save();
        }
    }
}
