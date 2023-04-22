package hr.ja.weboo.lib;

public class Div extends Widget {

    public Div(String text) {
        add(new Html(text));
    }

    public Div(Widget w) {
        add(w);
    }

    @Override
    public String toHtml() {
        return "<div %s>%s</div>".formatted(classesAsAtribute(), getChildrenHtml());

    }


}
