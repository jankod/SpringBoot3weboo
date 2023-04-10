package hr.ja.weboo;


import hr.ja.weboo.lib.Form;
import org.springframework.web.servlet.ModelAndView;

public class HomePage extends Page {


    public HomePage() {
        setTitle("Home page");


        Form form = new Form();

    }

    public String toHtml() {
        ModelAndView mv = new ModelAndView();

        return "home page";
    }
}
