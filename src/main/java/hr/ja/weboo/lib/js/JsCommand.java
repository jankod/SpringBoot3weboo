package hr.ja.weboo.lib.js;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import hr.ja.weboo.lib.MyUtil;
import hr.ja.weboo.lib.Widget;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Data
@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.DEDUCTION)
public class JsCommand implements Serializable {
    private String name;
    private List<String> params = new ArrayList<>(4);

    private static List<String> js = new ArrayList<>();

    public JsCommand() {
        name = getClass().getSimpleName();
        log.debug("name {}", name);
    }

    public static String getAllJsCode() {
        return ReplaceHtmlJsCommand.js +
               "\n ";

//        return String.join(" \n ", js);
    }

    public JsCommand param(String param) {
        params.add(param);
        return this;
    }

    public JsCommand params(String... params) {
        Collections.addAll(this.params, params);
        return this;
    }


    public static class RedirectJsCommand extends JsCommand {

        public RedirectJsCommand(String url) {
            param(url);
        }
    }

    //@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.DEDUCTION)
    public static class ReplaceHtmlJsCommand extends JsCommand {

        static
        String js = """
              Weboo.commands.ReplaceHtmlJsCommand = function (elementSelector, html) {
                  $(elementSelector).html(html);
                  console.log("replace html: ", elementSelector );
              }
              """;

        public ReplaceHtmlJsCommand(String elementSelector, String html) {
            params(elementSelector, html);
        }

        public ReplaceHtmlJsCommand(String elementSelector, Widget widget) {
            this(elementSelector, widget.toHtml());
        }


    }

    public static void main(String[] args) {
        String json = MyUtil.toJson(new ReplaceHtmlJsCommand("2213", "<p>"));
        System.out.println(json);
    }
}
