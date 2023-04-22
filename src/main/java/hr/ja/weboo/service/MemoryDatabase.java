package hr.ja.weboo.service;


import hr.ja.weboo.model.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class MemoryDatabase {

    private Map<Long, User> users = new HashMap<>();

}
