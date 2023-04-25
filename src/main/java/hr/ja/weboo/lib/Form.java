package hr.ja.weboo.lib;

import hr.ja.weboo.lib.js.JsCommand;
import hr.ja.weboo.model.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Slf4j
public class Form extends Widget {

    private final String actionUrl;
    private BindingResult errors;


    public Form(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public Form() {
        this("");
    }

    public static AjaxFormResult replaceRequestForm(String html) {
        return AjaxFormResult.commands(new JsCommand.ReplaceHtmlJsCommand("#" + getFormId(), html));
    }


    public Form add(FormField filed) {
        super.add(filed);
        return this;
    }

    @Override
    public String toHtml() {

        return """
              <form id='%s' method='post' action='%s'>
                  <input type='hidden' name='_form_id' value='%s'>
                      %s
              </form>
              """.formatted(getId(), actionUrl, getId(), getChildrenHtml());
    }

    public static String getFormId() {
        return MyUtil.request().getParameter("_form_id");
    }

    public TextField text(String name, String label) {
        TextField textField = new TextField(name, label);
        add(textField);
        return textField;
    }

    public Select select(String fieldName, String label) {
        Select select = new Select(fieldName, label);
        add(select);
        return select;
    }

    public Select selectMultiple(String fieldName, String label) {
        Select select = select(fieldName, label);
        select.setMultiselect(true);
        return select;
    }
}

