package hr.ja.weboo;

import hr.ja.weboo.lib.HtmlUtil;
import hr.ja.weboo.lib.Table;
import hr.ja.weboo.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.function.Function;

import static hr.ja.weboo.lib.HtmlUtil.p;


@Slf4j
@Controller
@RequestMapping()
@RequiredArgsConstructor
public class UserListPage {

    static final String USER_LIST_URL = "/get-user";

    @GetMapping(USER_LIST_URL)
    public MyWebSite getUserList() {

        MyWebSite site = new MyWebSite(USER_LIST_URL, "User list");
        site.add(p("User list page"));


        Table<User> table = new Table<>();
        table.column(User.Fields.id, "Id");
        table.column(User.Fields.name, "Name");
        table.setData(User.getAll());

        site.add(table);

        return site;
    }
}
