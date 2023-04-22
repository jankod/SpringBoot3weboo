package hr.ja.weboo.lib;

public class HtmlUtil {


    public static H3 h3(String text) {
        return new H3(text);
    }

    public static H3 h3(String text, String classes) {
        H3 h3 = new H3(text);
        h3.setClasses(classes);
        return h3;
    }

    public static P p(String text) {
        return new P(text);
    }

    public static Div div(String text) {
        return new Div(text);
    }

    public static Br br() {
        return new Br();
    }

    public static Div div(String classes, Widget w) {
        var div = div(w);
        div.addClass(classes);
        return div;
    }

    public static Div div(Widget w) {
        return new Div(w);
    }

    public static Html html(String html) {
        return new Html(html);
    }


}
