package hr.ja.weboo.lib;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Data
public class Table<M> extends Widget {

    private Collection<M> data;

    private List<Column> columns = new ArrayList<>();

    private int height = 200;
    private String layout = "fitColumns";

    public Column column(String fieldName, String title) {
        Column column = new Column();
        column.setField(fieldName);
        column.setTitle(title);
        columns.add(column);
        return column;
    }

//    public Column<M> column(String name, Function<M, Object> columnValue) {
//        Column<M> column = new Column<>(name, columnValue);
//        columns.add(column);
//        return column;
//    }


    @Override
    public String toHtml() {
        String json = MyUtil.toJson(this);

        String html = """
                            <div id="{id}">
                                          
                            </div>
                            <script>
                                 const tab = new Tabulator("#{id}",
                                 {json});
                            </script>
                                           
                                          """;
        return MyUtil.qute(html, Map.of(
              "id", getId(),
              "json", json
        ));
    }


//    class Tabulator {
//        public int height = 200;
//        public String layout = "fitColumns";
//        public ArrayList<Column> columns = new ArrayList<>();
//        public Object data;
//    }

}
