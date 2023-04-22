package hr.ja.weboo.lib;

import org.apache.commons.lang3.StringUtils;

public class P extends Widget {
    private final String text;

    public P(String text) {
        this.text = StringUtils.trimToEmpty(text);
    }

    @Override
    public String toHtml() {
        return "<p>%s</p>".formatted(MyUtil.escape(text));
    }
}
