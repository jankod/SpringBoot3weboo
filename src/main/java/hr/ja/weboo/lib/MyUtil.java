package hr.ja.weboo.lib;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.ja.weboo.model.User;
import io.quarkus.qute.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.WebUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

@Slf4j
public class MyUtil {

    static {
        Engine engine = Engine.builder().strictRendering(true)
              .addDefaults()
              .addValueResolver(new ReflectionValueResolver())
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
}
