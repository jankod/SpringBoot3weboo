package hr.ja.weboo;

import hr.ja.weboo.lib.Form;
import hr.ja.weboo.lib.Link;
import hr.ja.weboo.lib.Select;
import hr.ja.weboo.lib.SubmitButton;
import hr.ja.weboo.model.Role;
import hr.ja.weboo.model.User;
import hr.ja.weboo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

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

    @GetMapping(HOME_URL)
    public MyWebSite home(HttpServletRequest request) {
        MyWebSite site = new MyWebSite(HOME_URL, "Home");

        site.add(h3("Home page"));

        site.add(new Link(ADD_URL, "Add user form"));

        return site;
    }


    @PostMapping(ADD_URL)
    public View handleForm(@Valid User user, BindingResult errors, RedirectAttributes flash, HttpServletRequest request) {
        log.debug("Form user {}", user);
        if (errors.hasErrors()) {
            Form.setError(errors, request);
            return showUserForm(request);
        }

        flash.addFlashAttribute("Form je uspjesno unesena!");
        return new RedirectView(HOME_URL);
    }

    @GetMapping(ADD_URL)
    public MyWebSite showUserForm(HttpServletRequest request) {

        MyWebSite site = new MyWebSite(ADD_URL, "Add user");

        site.add(div("Add user form"));

        Form form = new Form(request);

        form.add(h3("Form for enter new user"));
        form.text(User.Fields.name, "Name").autofocus();

        Select select = form.select(User.Fields.roles, "Choose role")
              .addOptionSelectedDisabled("Please, select value")
              .addOption(Role.USER, "User")
              .addOption(Role.ADMIN, "Admin");

        log.debug("options {}", select.getOptions());

        form.add(new SubmitButton("Save"));
        site.add(form);

        return site;
    }


//    @GetMapping(LIST_URL)
//    public UserListView list() {
//        Collection<User> users = userService.findAllUsers();
//        return new UserListView(users, LIST_URL);
//    }


}
