package hr.ja.weboo;

import hr.ja.weboo.lib.WebSite;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomePage {

    private final WebSite webSite;


    @GetMapping
    @ResponseBody
    public String index() {
        log.debug("dela ocvo");

        return webSite.toHtml("ovo je home page");

    }
}
