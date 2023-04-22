package hr.ja.weboo;

import hr.ja.weboo.model.User;
import hr.ja.weboo.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class App {

    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.debug("http://localhost:8080");
    }


    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            User u = new User(i, "user " + i);
            userService.save(u);
        }
    }

}
