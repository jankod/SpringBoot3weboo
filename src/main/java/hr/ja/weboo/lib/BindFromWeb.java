package hr.ja.weboo.lib;


import org.springframework.web.context.request.WebRequest;

@FunctionalInterface
public interface BindFromWeb<M> {
    void bind(WebRequest request, M model);
}