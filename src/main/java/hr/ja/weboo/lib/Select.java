package hr.ja.weboo.lib;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class MultiSelect<M> extends FormField<M> {

    private final String fieldName;

    private final String label;

    private List<SelectKeyValue> keyValues;

    public MultiSelect(String fieldName, String label, List<SelectKeyValue> keyValues) {
        this.fieldName = fieldName;
        this.label = label;
        this.keyValues = keyValues;
    }

    @Override
    public String toHtml() {
        String h = """
              <div class="mb-3">
              <label for="{fieldName}" class="form-label" id="{id}">{label}</label>
              <select class="form-select" multiple name="{fieldName}" id="{fieldName}">
                 {#for item in values}
                       <option value='{item.key}' {item.getSelectedParam()}>{item.value}</option>
                  {/for}
              </select>
              </div>
              """;
        return MyUtil.qute(h, Map.of(
              "fieldName", fieldName,
              "label", label,
              "id", getId(),
              "values", keyValues
        ));
    }

    @Data
    public static class SelectKeyValue {
        String key;
        String value;
        boolean selected;

        public SelectKeyValue(String value) {
            this.key = value;
            this.value = value;
        }

        public String getSelectedParam() {
            if (selected) return "selected";
            return "";
        }
    }
}

