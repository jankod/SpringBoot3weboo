package hr.ja.weboo.lib;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class WebSiteParam {

    private String title;

    @Getter
    @Setter
    private Class<? extends Page> currentPage;
}
