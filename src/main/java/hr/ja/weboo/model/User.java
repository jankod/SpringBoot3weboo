package hr.ja.weboo.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

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
}
