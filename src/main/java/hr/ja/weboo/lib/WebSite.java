package hr.ja.weboo.lib;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@Slf4j
public class WebSite {

    private String title = "web site";

    private String siteName = "Site name";

    private List<Widget> widgets = new ArrayList<>();
    private List<NavItem> items = new ArrayList<>();

    public void add(Widget widget) {
        widgets.add(widget);
    }


    public String render(HttpServletRequest request, HttpServletResponse response) {
        String flashHtml = createFlashAlert(request);

        String h = """
              <!doctype html>
              <html lang="en" data-bs-theme="light">
              <head>
                  <meta charset="utf-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1">
                  <title>{title}</title>
                  <link href="/bootstrap-5.3.0-alpha3/bootstrap.min.css" rel="stylesheet">
                  <link href="/tabulator/css/tabulator.min.css" rel="stylesheet">
                  <script type="text/javascript" src="/bootstrap-5.3.0-alpha3/bootstrap.bundle.min.js"></script>
                  <script type="text/javascript" src="/tabulator/js/tabulator.min.js"></script>
                  <script type="text/javascript" src="/jquery-3.6.4.min.js"></script>
                  <script type="text/javascript" src="/all.js"></script>
 <!--                 <script defer src="/alpine.min.js"></script> -->
                  
                   {style}
              </head>
              <body>
              <main class='d-flex flex-nowrap'>
                  {navbar}
                  <div class="b-divider"></div>
                  <div class='col py-3'>
                      <div class='container'>
                           {flashMessage}
                      
                          {body}
                      </div>
                  </div>
                            
                  </div>
                            
              </body>
              </html>
                            """;
        return MyUtil.qute(h, Map.of(
              "title", getTitle(),
              "style", style(),
              "navbar", navbar(),
              "body", body(),
              "flashMessage", flashHtml

        ));
    }

    private String createFlashAlert(HttpServletRequest request) {
        Map<String, ?> f = RequestContextUtils.getInputFlashMap(request);
//        log.debug("Find flash {}", f);
        if (f != null && !f.isEmpty()) {
            return "FLASH " + f.toString();
        }
        return "";
    }

    private String body() {
        return MyUtil.toHtml(widgets);
    }

    private String style() {
        return """
              <style>
                  body {
                      min-height: 100vh;
                      min-height: -webkit-fill-available;
                  }
                            
                  html {
                      height: -webkit-fill-available;
                  }
                            
                  main {
                      height: 100vh;
                      height: -webkit-fill-available;
                      max-height: 100vh;
                      overflow-x: auto;
                      overflow-y: hidden;
                  }
                            
                  .b-divider {
                      flex-shrink: 0;
                      width: 0.1rem;
                      height: 100vh;
                      background-color: rgba(0, 0, 0, .1);
                      border: solid rgba(0, 0, 0, .15);
                      border-width: 1px 0;
                      box-shadow: inset 0 0.5em 1.5em rgba(0, 0, 0, .1), inset 0 0.125em 0.5em rgba(0, 0, 0, .15);
                            
                  }
              </style>
                            """;
    }

    private String navbar() {

        String navHtml = items.stream().map(i -> {
            String active = "";
            if (i.isActive()) {
                active = "active";
            }
            return """
                    <li class="nav-item">
                      <a href="%s" class="nav-link %s" aria-current="page">
                        %s
                      </a>
                    </li>
                  """.formatted(i.getUrl(), active, i.getLabel());
        }).collect(Collectors.joining("\n"));

        String html = """
              <div class="d-flex flex-column flex-shrink-0 p-3 text-bg-dark" style="width: 280px;">
                  <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                    <svg class="bi pe-none me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
                    <span class="fs-4">%s</span>
                  </a>
                  <hr>
                  <ul class="nav nav-pills flex-column mb-auto">
                  
                   %s
                    
                  </ul>
                  
                  <!--
                  <hr>
                 <div class="dropdown">
                    <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                      <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
                      <strong>mdo</strong>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark text-small shadow" style="">
                      <li><a class="dropdown-item" href="#">New project...</a></li>
                      <li><a class="dropdown-item" href="#">Settings</a></li>
                      <li><a class="dropdown-item" href="#">Profile</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#">Sign out</a></li>
                    </ul>
                  </div>-->
                </div>
                            """.formatted(siteName, navHtml);
        return html;

    }

    public void setActiveUrl(String url) {
        Optional<NavItem> navitem = items.stream().filter(i -> i.getUrl().equals(url)).findFirst();
        navitem.ifPresent(navItem -> navItem.setActive(true));
    }


    public void addNavigation(String url, String label) {
        NavItem item = new NavItem(url, label);
        items.add(item);
    }
}

@Data
class NavItem {
    private String url;
    private String label;
    private boolean active;

    public NavItem(String url, String label) {
        this.url = url;
        this.label = label;
    }
}
