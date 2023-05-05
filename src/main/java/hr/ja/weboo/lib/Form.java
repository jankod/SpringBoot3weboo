package hr.ja.weboo.lib;

import hr.ja.weboo.lib.js.JsCommand;
import hr.ja.weboo.service.SessionManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.validation.BindingResult;

import java.util.function.Consumer;


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
              """.formatted(getId(), actionUrl, getId(), toChildrenHtml());
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


    public void onSubmit(FormSubmitConsumer consumer) {

        SessionManager.onSubmit(consumer, this.getId());
        log.debug("consumer {}", consumer.hashCode());
        //consumer.accept(new FormSubmitEvent());
    }
}

