package hr.ja.weboo.demo;

import lombok.Data;

import java.util.List;

@Data
public class JtePage {
    String name;
    int age;

    private List<String> list = List.of("a", "b", "c");
}
