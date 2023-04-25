package hr.ja.weboo.lib;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Data
public class Table<M> extends Widget {


    private String height = "400";
    private Layout layout = Layout.FIT_COLUMNS;
    private boolean autoColumns = false;

    private List<Column> columns = new ArrayList<>();
    private Collection<M> data;

    public Column column(String fieldName, String title) {
        Column column = new Column();
        column.setField(fieldName);
        column.setTitle(title);
        columns.add(column);
        return column;
    }

    @Override
    public String toHtml() {
        String json = MyUtil.toJson(this);

        String html = """
              <div id="{id}">
                            
              </div>
              <script defer>
                   const tab = new Tabulator("#{id}",
                   {json});
              </script>
                             
                            """;
        return MyUtil.qute(html, Map.of(
              "id", getId(),
              "json", json
        ));
    }

    public enum Layout {
        FIT_COLUMNS("fitColumns"),
        FIT_DATA("fitData"),
        FIT_DATA_FILL("fitDataFill"),
        FIT_DATA_STRETCH("fitDataStretch"),
        FIT_DATA_TABLE("fitDataTable");

        private final String realName;

        Layout(String realName) {
            this.realName = realName;
        }

        @JsonValue
        public String realName() {
            return realName;
        }

    }
}
