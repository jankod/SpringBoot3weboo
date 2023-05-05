package hr.ja.weboo.lib;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.ja.weboo.UserPage;
import io.quarkus.qute.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.support.WebRequestDataBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.async.StandardServletAsyncWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Slf4j
public class MyUtil {

    static {
        Engine engine = Engine.builder().strictRendering(true)
              .addDefaults()
              .addValueResolver(new ReflectionValueResolver())
              .addParserHook(p -> p.addContentFilter(s -> {
                  s = StringUtils.replace(s, "${", "{this.");
                  return s;
              }))
              .build();
        Qute.setEngine(engine);
        Qute.enableCache();
    }

    private static final Escaper e = Escaper.builder().build();

    public static String escape(String text) {
        return e.escape(text);
    }

    public static String toHtml(List<Widget> widgetList) {
        if (CollectionUtils.isEmpty(widgetList)) {
            return "";
        }
        StringBuilder html = new StringBuilder();
        for (Widget widget : widgetList) {
            html.append(widget.toHtml());
        }
        return html.toString();
    }

    public static String qute(String html, Map<String, Object> map) {
        return Qute.fmt(html, map);
    }

//    public static String qute(String html, Object... data) {
//        return Qute.fmt(html, data);
//    }

    /**
     * @param template Use template like this: Hello {1} {2}!
     * @param widgets  array of widgets
     * @return html
     */
    public static String qute(String template, Widget... widgets) {
        return Qute.fmt(template, (Object[]) widgets);
    }


    /**
     * return Qute.Map.of("this", this)
     *
     * @param template
     * @param thisObject
     * @return
     */
    public static Qute.Fmt quteThis(String template, Object thisObject) {
            return Qute.fmt(template).dataMap(Map.of("this", thisObject));
    }

    public static Object choice(boolean condition, String value1, String value2) {
        if (condition) {
            return value1;
        }
        return value2;
    }

    public static void printErrors(BindingResult bindingResult) {
        for (ObjectError err : bindingResult.getAllErrors()) {
            log.debug("{}", err);
        }
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static String toJson(Object user) {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
    }

    public static HttpServletRequest request() {

        //ServletUriComponentsBuilder.fromCurrentContextPath()
        //ControllerLinkBuilder we;
        String path = MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(UserPage.class).showUserForm()).build().getPath();
        log.debug("path {}", path);

        // RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //requestAttributes.

        // ServletUriComponentsBuilder.fromCurrentRequest().build();
        //WebUtils.findParameterValue()
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        Assert.state(attrs instanceof ServletRequestAttributes, "No current ServletRequestAttributes");
        return ((ServletRequestAttributes) attrs).getRequest();
    }

    public static HttpServletResponse response() {

        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        Assert.state(attrs instanceof ServletRequestAttributes, "No current ServletRequestAttributes");
        ServletRequestAttributes att = (ServletRequestAttributes) attrs;

        return att.getResponse();
    }

    public static BindingResult bindSubmitTo(Object target) {
        WebRequestDataBinder binder = new WebRequestDataBinder(target);
        StandardServletAsyncWebRequest request = new StandardServletAsyncWebRequest(request(), response());
        binder.bind(request);
        return binder.getBindingResult();
    }
}
