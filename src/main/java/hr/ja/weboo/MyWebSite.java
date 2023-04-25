package hr.ja.weboo;

import hr.ja.weboo.lib.WebSite;
import hr.ja.weboo.lib.Widget;
import hr.ja.weboo.view.JavaView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class MyWebSite extends JavaView {

    @Getter
    private WebSite site = new WebSite();
    {
        site.setSiteName("Java view");
        site.addNavigation(UserPage.HOME_URL, "Home user");
        site.addNavigation(UserPage.ADD_URL, "Add user");
        site.addNavigation(UserListPage.USER_LIST_URL, "User list");
    }

    public MyWebSite(String activeUrl, String title) {
        activeUrl(activeUrl);
        title(title);
    }

    public MyWebSite title(String title) {
        site.setTitle(title);
        return this;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        PrintWriter writer = response.getWriter();
        List<Widget> bodyWidgets = getChildren();
        site.setBodyWidgets(bodyWidgets);
        writer.write(site.render(request, response));
    }

    public MyWebSite activeUrl(String url) {
        site.setActiveUrl(url);
        return this;
    }
}
