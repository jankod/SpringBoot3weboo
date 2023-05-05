package hr.ja.weboo.layout;

import hr.ja.weboo.lib.MyUtil;
import lombok.Getter;
import lombok.Setter;


/**
 * https://www.w3schools.com/tags/att_link_rel.asp
 */
@Getter
@Setter
public class CssLink {

    private Rel rel = Rel.stylesheet;
    private String type = "text/css";
    private String href = "";

    public CssLink(String href) {
        this.href = href;
    }

    public enum Rel {
        stylesheet,
        preconnect,
        icon
    }

    @Override
    public String toString() {
        return """
              <link rel='%s' type='%s' href='%s'>
              """.formatted(rel, type, href);
    }
}
