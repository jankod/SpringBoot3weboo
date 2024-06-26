package hr.ja.weboo;

import hr.ja.weboo.lib.*;
import hr.ja.weboo.model.Role;
import hr.ja.weboo.model.User;
import hr.ja.weboo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.tags.form.ButtonTag;

import static hr.ja.weboo.lib.HtmlUtil.*;

@Slf4j
@Controller
@RequestMapping()
@RequiredArgsConstructor
public class UserPage {

    public static final String HOME_URL = "/";
    public static final String ADD_URL = "/add_user";
    // public static final String ADD_FORM_ACTION_URL = "/add_user_form";

    private final UserService userService;

    @GetMapping("/pero_event")
    public void onSubmit(SubmittedForm event) {
        BindingResult errors = MyUtil.bindSubmitTo(new User());
        log.debug("Suibmit " + event);

    }

    @GetMapping(HOME_URL)
    public MyWebSite showHomePage() {
        String path = ServletUriComponentsBuilder.fromCurrentRequest().build().getPath();

        MyWebSite site = new MyWebSite(HOME_URL, "Home");

        site.add(h3("Home page"));

        site.add(new Link(ADD_URL, "Add user form"));
        return site;
    }


    @PostMapping(ADD_URL)
    @ResponseBody
    public AjaxFormResult handleForm(@Valid User user, BindingResult errors) {

        log.debug("Form user {}", user);
        if (errors.hasErrors()) {
            return AjaxFormResult.error(errors);
        }

        user.save();

        Div message = div(new Card("Uspjesno je forma izvrsena", link(HOME_URL, "Idi na Home page")));

        return AjaxFormResult.replaceRequestForm(message);
    }

    @GetMapping(ADD_URL)
    public MyWebSite showUserForm() {
        MyWebSite site = new MyWebSite("Add user");
        site.add(h3("Forma za unos usera"));

        Form form = new Form(ADD_URL);

        form.add(p("Form for enter new user"));
        form.text(User.Fields.name, "Name").autofocus();

        form.select(User.Fields.roles, "Choose role")
              .addOptionSelectedDisabled("Please, select value")
              .addOption(Role.USER, "User")
              .addOption(Role.ADMIN, "Admin");

        form.add(new SubmitButton("Save"));
        site.add(form);
        form.onSubmit(this::onSubmit);

        return site;
    }

}
