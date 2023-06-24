package hr.ja.weboo.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class MyMethodInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
      //  log.debug("Post handle");
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

      //  log.debug("Handler ss {}", handler);

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            handlerMethod.getMethod().hashCode();
            //SomeAnnotation someAnnotation = handlerMethod.getMethodAnnotation(SomeAnnotation.class);
            log.debug("hash code {} {}", handler, handlerMethod.getMethod().hashCode());
        }

        return true; // return false if you want to abort the execution chain
    }
}
