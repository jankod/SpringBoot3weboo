package hr.ja.weboo.lib;


import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Card extends Widget {

    private final Widget widgetTitle;
    private final Widget widgetBody;
    private String bodyClasses = "card-body ";
    private String titleClasses  ="card-title";

    public Card(String titleText, Widget widgetBody) {
        this.widgetTitle = new Span(titleText);
        this.widgetBody = widgetBody;
    }

    public Card(Widget widgetTitle, Widget widgetBody) {
        this.widgetTitle = widgetTitle;
        this.widgetBody = widgetBody;
    }

    @Override
    public String toHtml() {
        return MyUtil.qute("""
              <div class='card'>
                  <div class='card-header'>
                    <div class='{titleClasses}'>
                      {title}
                    </div>
                  </div>
                  <div class="{bodyClasses}">
                      {body}
                  </div>
              </div>
              """, Map.of(
              "title", widgetTitle.toHtml(),
              "titleClasses", titleClasses,
              "body", widgetBody.toHtml(),
              "bodyClasses", bodyClasses
        ));
    }
}
