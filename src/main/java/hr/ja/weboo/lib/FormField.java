package hr.ja.weboo.lib;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class FormField extends Widget {

    protected String name;
    protected String label;
    protected String value;

    protected String placeholder;

    private boolean autofocus = false;

    protected List<String> errorMessages = new ArrayList<>();

    public void addErrorMessage(String errorMessage) {
        errorMessages.add(errorMessage);
    }

    public void autofocus() {
        this.autofocus = true;
    }

    public String getErrorClass() {
        String errorClass = "";

        if (!CollectionUtils.isEmpty(errorMessages)) {
            errorClass = "is-invalid";
        }
        return errorClass;
    }
}
