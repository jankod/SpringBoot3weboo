package hr.ja.weboo.old;


import hr.ja.weboo.lib.*;
import hr.ja.weboo.model.Role;
import hr.ja.weboo.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import static hr.ja.weboo.lib.HtmlUtil.*;
import static hr.ja.weboo.lib.Layout.*;

@Slf4j
//@Controller
//@RequestMapping("/home")
@RequiredArgsConstructor
public class ClassicController {

    @PostMapping
    public RedirectView handleForm(@Valid User user, BindingResult errors, RedirectAttributes flash, Model model) {
        log.debug("user {}", user);

        if (errors.hasErrors()) {
            DataBinder s;
            model.addAttribute("errors", errors);

            MyUtil.printErrors(errors);
        }
        flash.addFlashAttribute("m", "Uspjesno spremljena forma " + user);
        return new RedirectView("/message");
    }

    @GetMapping("/message")
    @ResponseBody
    public String showMessage(@ModelAttribute("m") String flashMessage) {

        Card card = new Card("Poruka", html("Poruka: " + flashMessage));
        WebSite webSite = new WebSite();
        webSite.setTitle("Uspjesno postignuta forma");
        webSite.add(card);
        return webSite.render(null, null);
    }


    @GetMapping
    @ResponseBody
    public String showPage(Model model) {
        Object errors = model.getAttribute("errors");
        log.debug("has errors: {}", errors);
        Form form = new Form("");

        form.text(User.Fields.name, "Name")
              .autofocus();

        form.selectMultiple(User.Fields.roles, "Roles")
              .addOption(Role.USER.name(), "User")
              .addOption(Role.ADMIN.name(), "Admin")
              .addOption(Role.MANAGER.name(), "Manager");

        form.add(new SubmitButton("spremi"));
        Row row = row(
              col2(div("Nesto")),
              col4(new Card("Forma moja", form))
        );

        WebSite webSite = new WebSite();
        webSite.setTitle("User form");
        webSite.add(row);

        return webSite.render(null, null);
    }
}
