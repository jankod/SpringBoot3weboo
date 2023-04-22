package hr.ja.weboo.lib;

public class Html extends Widget {

    private final String html;

    public Html(String html) {
        this.html = html;
    }

    @Override
    public String toHtml() {
        return html;
    }
}
