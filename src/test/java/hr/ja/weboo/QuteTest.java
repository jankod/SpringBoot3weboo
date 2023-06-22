package hr.ja.weboo;

import hr.ja.weboo.lib.Div;
import hr.ja.weboo.lib.MyUtil;
import hr.ja.weboo.lib.Widget;
import io.quarkus.qute.Engine;
import io.quarkus.qute.Qute;
import io.quarkus.qute.ReflectionValueResolver;
import io.quarkus.qute.TemplateData;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class QuteTest {

    public static void main(String[] args) {
        Engine engine = Engine.builder()

              .strictRendering(true)
              .addDefaults()
              .addValueResolver(new ReflectionValueResolver())
              .addParserHook(p -> p.addContentFilter(s -> {
                  s = StringUtils.replace(s, "${", "{this.");
                  return s;
              }))

              .build();

        Qute.setEngine(engine);

        Qute.enableCache();

        DemoWidget demoWidget = new DemoWidget();
        System.out.println(demoWidget.toHtml());
    }
}

@Getter
@Setter
@TemplateData
class DemoWidget extends Widget {

    private Div div = new Div("Ja sam div");
    private String demoString = "ja sam demo string ${toHtml()}";

    @Override
    public String toHtml() {
        String h = """
                Pocetak
                ${div}
                ${demoString}
                ----
              """;

        return MyUtil.quteThis(h, this).render();

        // return Qute.fmt(h).contentType(Variant.TEXT_HTML).dataMap(Map.of("this", this)).render();
        //return Qute.fmt(h, Map.of("this", this));
    }
}


