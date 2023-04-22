package hr.ja.weboo.service;

import hr.ja.weboo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
@RequiredArgsConstructor
public class UserService {

    private final MemoryDatabase db;


    public Collection<User> findAllUsers() {
          return db.getUsers().values();
    }

    public void save(User u) {
        db.getUsers().put(u.getId(), u);
    }
}
