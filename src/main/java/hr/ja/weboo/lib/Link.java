package hr.ja.weboo.lib;

public class Link extends Widget {
    private final String url;
    private final String label;

    public Link(String url, String label) {
        this.url = url;
        this.label = label;
    }

    @Override
    public String toHtml() {
        return """
              <a class='btn btn-link' href='%s'>%s</a>
              """.formatted(url, label);
    }
}
