package hr.ja.weboo.lib;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Select extends FormField {
    private List<Option> options = new ArrayList<>(5);

    private boolean multiselect = false;

    public Select(String fieldName, String label) {
        super();
        this.name = fieldName;
        this.label = label;
    }

    public Select(String fieldName, String label, List<Option> options) {
        super();
        this.name = fieldName;
        this.label = label;
        this.options = options;
    }

    @Override
    public String toHtml() {
        String h = """
              <div class="mb-3" id="{id}">
              <label for="{name}" class="form-label" id="{id}">{label}</label>
              <select class="form-select {errorClass}" {multiselect ? 'multiple' : ''} name="{name}" id="{name}" {autofocus}>
                 {#for item in options}
                       <option value='{item.key}' {item.selected ? 'selected' : ''} {item.disable ? 'disabled' : ''}  >{item.label}</option>
                  {/for}
              </select>
                 {#for err in errMsgs}
                  <div class="invalid-feedback">
                      {err}
                  </div>
                  {/for}
              </div>
              """;
        return MyUtil.qute(h, Map.of(
              "name", name,
              "label", label,
              "id", getId(),
              "options", options,
              "multiselect", multiselect,
              "errorClass", getErrorClass(),
              "errMsgs", errorMessages,
              "autofocus", isAutofocus() ? "autofocus" : ""
        ));
    }


    public Select addOption(Object key, String value, boolean selected) {
        options.add(new Option(key.toString(), value, selected));
        return this;
    }



    public Select addOption(Object key, String value) {
        return addOption(key, value, false);
    }

    public Select addOption(String keyValue) {
        return addOption(keyValue, keyValue, false);
    }

    public Select addOptionSelected(String keyValue) {
        return addOption(keyValue, keyValue, false);
    }

    public Select addOptionSelected(String key, String value) {
        return addOption(key, value, false);
    }

    public Select addOptionSelectedDisabled(String value) {
        Option option = new Option(value, value, true);
        option.setDisable(true);
        options.add(option);
        return this;

    }
}

