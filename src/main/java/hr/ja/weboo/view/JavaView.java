package hr.ja.weboo.view;

import hr.ja.weboo.lib.MyUtil;
import hr.ja.weboo.lib.Row;
import hr.ja.weboo.lib.Widget;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JavaView implements View {

    @Getter
    private final List<Widget> children =  new ArrayList<>();

    public void add(Widget widget) {
        children.add(widget);
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
            response.getWriter().write(MyUtil.toHtml(children));

    }

    @Override
    public String getContentType() {
        return MediaType.TEXT_HTML_VALUE;
    }
}
