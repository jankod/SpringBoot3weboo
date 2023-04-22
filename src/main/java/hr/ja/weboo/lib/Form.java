package hr.ja.weboo.lib;

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

    public Form(HttpServletRequest request) {
        this("");
        errors = (BindingResult) request.getAttribute("errors");
    //    log.debug("errors: {}", errors);
//        if (errors != null) {
//            List<ObjectError> allErrors = errors.getAllErrors();
//            for (ObjectError err : allErrors) {
//                log.debug("Err '{}' '{}'", err.getObjectName(), err.getDefaultMessage());
//            }
//        }
    }

    public static void setError(BindingResult errors, HttpServletRequest request) {
        request.setAttribute("errors", errors);
    }

    public Form add(FormField filed) {
        super.add(filed);
        if (errors != null) {
//            log.debug("Errors {}", errors.getErrorCount());
//            log.debug("Get za field {}", filed.getName());

            List<FieldError> fieldErrors = errors.getFieldErrors(filed.getName());
            if (!CollectionUtils.isEmpty(fieldErrors)) {
                for (FieldError fieldError : fieldErrors) {
                    if (filed.getName().equals(fieldError.getField())) {
                        filed.addErrorMessage(fieldError.getDefaultMessage());
                    }
                }
            }

        }
        return this;
    }

    @Override
    public String toHtml() {
        return """
              <form id='%s' method='post' action='%s'>
                      %s
              </form>
              """.formatted(getId(), actionUrl, getChildrenHtml());
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

