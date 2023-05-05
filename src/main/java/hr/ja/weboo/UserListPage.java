package hr.ja.weboo;

import hr.ja.weboo.lib.*;
import hr.ja.weboo.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        table.setLayout(Table.Layout.FIT_COLUMNS);
        table.column(User.Fields.id, "Id");
        table.column(User.Fields.name, "Name").setHozAlign(Column.HorizontalAlign.right);
        table.setData(User.getAll());
        table.onSelectRow("""
              rowClick:function(e, row){
                      //e - the click event object
                      //row - row component
                      row.toggleSelect(); //toggle row selected state on row click
                  },
              """);

        Card card = new Card("Uset table", table);
        card.setBodyClasses("");

        site.add(new Html("""
              <div class="container text-center">
                <div class="row ">
                  <div class="col-6">
                    %s
                  </div>
                </div>
              </div>
              """.formatted(card.toHtml())));

        return site;
    }
}
