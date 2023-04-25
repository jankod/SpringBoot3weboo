package hr.ja.weboo.lib;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;

import java.util.Map;

public class AjaxView implements View {
    private static final MediaType MEDIA_TYPE = MediaType.APPLICATION_JSON;
    private static final ObjectMapper mapper = new ObjectMapper();
    private final AjaxFormResult ajaxFormResult;

    public AjaxView(AjaxFormResult ajaxFormResult) {

        this.ajaxFormResult = ajaxFormResult;
    }

    @Override
    public String getContentType() {
        return MEDIA_TYPE.toString();
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String jsonResponse = mapper.writeValueAsString(ajaxFormResult);

        response.setContentType(getContentType());
        response.getWriter().write(jsonResponse);
    }
}
