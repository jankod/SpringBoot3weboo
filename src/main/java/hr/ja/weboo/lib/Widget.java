package hr.ja.weboo.lib;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Widget implements HashId {

    @JsonIgnore
    @Getter
    private final String id = RandomStringUtils.randomAlphanumeric(10);

    @JsonIgnore
    @Getter
    private List<String> clasess = new ArrayList<>(4);

    @JsonIgnore
    @Getter
    private List<Widget> children = new ArrayList<>(6);

    public Widget add(Widget widget) {
        children.add(widget);
        return this;
    }

    public void addAll(Widget... widgets) {
        Collections.addAll(children, widgets);
    }

    public abstract String toHtml();

    public String getChildrenHtml() {
        return MyUtil.toHtml(getChildren());
    }

    public Widget addClass(String clazz) {
        clasess.add(clazz);
        return this;
    }

    public String classesAsAtribute() {
        if (clasess.isEmpty()) {
            return "";
        }

        return """
              class="%s"
              """.formatted(
              String.join(" ", clasess));
    }
}
