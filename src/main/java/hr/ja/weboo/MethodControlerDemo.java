package hr.ja.weboo;

import hr.ja.weboo.lib.Div;
import hr.ja.weboo.view.JavaView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MethodControlerDemo {



    @GetMapping("/ddd")
    MyWebSite ha() {
        MyWebSite webSite = new MyWebSite("asasd");
        webSite.add(new Div("ovo dela"));
        return webSite;
    }

}

class Re extends JavaView {
    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.render(model, request, response);
    }
}
