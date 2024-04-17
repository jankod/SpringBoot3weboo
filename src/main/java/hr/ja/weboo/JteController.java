package hr.ja.weboo;

import hr.ja.weboo.demo.JtePage;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JteController {

    @GetMapping("/jte")
    public String viewJte(Model model, HttpServletResponse response) {

        JtePage page = new JtePage();
        page.setName("JTE page");
        page.setAge(33);
        model.addAttribute("page", page);
        return "demo";
    }
}
