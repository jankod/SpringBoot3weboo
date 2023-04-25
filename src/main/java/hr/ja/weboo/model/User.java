package hr.ja.weboo.model;

import hr.ja.weboo.lib.MyUtil;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@FieldNameConstants
@NoArgsConstructor
public class User {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private List<Role> roles;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    private static List<User> db = new ArrayList<>();
    private static Long idGen = 1L;

    public void save() {
        this.id = idGen++;
        db.add(this);
    }

    public static List<User> getAll() {
        return db;
    }
}
