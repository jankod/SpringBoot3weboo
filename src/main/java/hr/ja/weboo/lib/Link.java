package hr.ja.weboo.lib;

public class Link extends Widget {
    private final String url;
    private Widget widget;
    private String label;

    public Link(String url, String label) {
        this.url = url;
        this.label = label;
    }

    public Link(String url, Widget widget) {
        this.url = url;
        this.widget = widget;
    }

    @Override
    public String toHtml() {
        if (label != null) {
            return """
                  <a class='btn btn-link' href='%s'>%s</a>
                  """.formatted(url, label);
        }
        return """
              <a class='btn btn-link' href='%s'>%s</a>
              """.formatted(url, widget.toHtml());

    }
}
