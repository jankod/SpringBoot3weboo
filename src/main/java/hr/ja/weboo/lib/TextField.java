package hr.ja.weboo.lib;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.defaultIfEmpty;

@Slf4j
public class TextField extends FormField {

    @Setter
    @Getter
    private String value = "";

    public TextField(String name, String label) {
        this.name = name;
        this.label = label;
    }


    @Override
    public String toHtml() {

        String html = """
               <div class="mb-3" id='field_{id}'>
                  <label for="{name}" class="form-label">{label}</label>
                  <input type="text" class="form-control {errorClass}" id="{name}" name="{name}" {autofocus}  x-model='{name}'>
                  {#for err in errMsgs}
                  <div class="invalid-feedback">
                      {err}
                  </div>
                  {/for}
                </div>
                
              """;
        return MyUtil.qute(html, Map.of(
              "id", getId(),
              "name", name,
              "label", label,
              "errMsgs", errorMessages,
              "errorClass", getErrorClass(),
              "value", value,
              "autofocus", isAutofocus() ? "autofocus" : ""
        ));

    }

}
