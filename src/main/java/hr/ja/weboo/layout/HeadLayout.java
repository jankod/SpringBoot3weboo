package hr.ja.weboo.layout;

import hr.ja.weboo.lib.Widget;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class HeadLayout extends Widget {

    private List<CssLink> cssLinks = new ArrayList<>();


    private String title;

    @Override
    public String toHtml() {
        String cssLinks = this.cssLinks.stream().map(CssLink::toString).collect(Collectors.joining("\n"));

        String html = """
              <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
              <!-- Primary Meta Tags -->
              <title>${title}</title>
              <meta name="viewport" content="width=device-width, initial-scale=1.0">
              <meta name="title" content={title}>
              <!-- OPTIONAL LINKS -->
                            
              <!-- Google Font: Source Sans Pro 
              <link rel="preconnect" href="https://fonts.googleapis.com">
              <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
              <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:ital,wght@0,300;0,400;0,700;1,400&display=swap" rel="stylesheet">
              -->
                            
              <!-- overlayscrollbars 
              <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/overlayscrollbars@2.1.0/styles/overlayscrollbars.min.css" integrity="sha256-LWLZPJ7X1jJLI5OG5695qDemW1qQ7lNdbTfQ64ylbUY=" crossorigin="anonymous">
              -->
              <!-- @fortawesome/fontawesome-free 
              <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.3.0/css/all.min.css" integrity="sha256-/4UQcSmErDzPCMAiuOiWPVVsNN2s3ZY/NsmXNcj0IFc=" crossorigin="anonymous">
              -->              
              <!-- REQUIRED LINKS -->
                            
              <!-- Theme style 
              <link rel="stylesheet" href={path + '/css/adminlte' + cssPath + '.css'} >
              -->
              %s
              """.formatted(cssLinks);
        return null;
    }
}
