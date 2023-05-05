package hr.ja.weboo.lib;

import io.quarkus.qute.Engine;
import io.quarkus.qute.EngineBuilder;
import io.quarkus.qute.Qute;

import java.util.Arrays;
import java.util.stream.Collectors;

import static hr.ja.weboo.lib.HtmlUtil.h3;
import static hr.ja.weboo.lib.HtmlUtil.p;

public class Html extends Widget {

    private final String html;

    public Html(String html) {
        this.html = html;
    }

    @Override
    public String toHtml() {
        return html;
    }


    public static Html simple(String template, Widget... widgets) {
        Object[] array = Arrays.stream(widgets).map(Widget::toHtml).toArray();
        String res = Qute.fmt(template).dataArray(array).render();
        //String res = Qute.fmt(template, array);
        return new Html(res);
    }

    public static void main(String[] args) {

//        System.out.println(simple("p {}", p("1")).toHtml());
//        Engine engine = new EngineBuilder().addDefaults().build();
        String data = p("1").toHtml();
        data = "pero";
        String res = MyUtil.qute("Hello {1} {2}!", p("11"), h3("dela"));

        System.out.println(res);
    }
}
