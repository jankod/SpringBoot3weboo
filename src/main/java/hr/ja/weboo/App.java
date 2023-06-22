package hr.ja.weboo;

import hr.ja.weboo.lib.js.JsCommand;
import hr.ja.weboo.model.User;
import hr.ja.weboo.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.Jar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Flow;


@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
@Controller
public class App {

    private final UserService userService;

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
        log.debug("http://localhost:8080");
    }

    @GetMapping(value = "/_custom.js", produces = "text/javascript")
    @ResponseBody()
    public String customJs() {
        return JsCommand.getAllJsCode();
    }


    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            User u = new User(i, "user " + i);
            userService.save(u);
        }
    }

}
