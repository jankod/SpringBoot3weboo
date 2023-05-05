package hr.ja.weboo.lib;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Setter
@Getter
@Accessors(chain = true)
public class Column {
    private String title;
    private String field;
    private int width;
    private String formatter;
    private String sorter;
    private boolean visible = true;
    private HorizontalAlign hozAlign;


    public enum HorizontalAlign {
        left,
        center,
        right;
    }


//    private final Function<M, Object> columnValue;
//
//    public Column(String name, Function<M, Object> columnValue) {
//        this.name = name;
//        this.columnValue = columnValue;
//    }
}
