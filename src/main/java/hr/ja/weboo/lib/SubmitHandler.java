package hr.ja.weboo.lib;

@FunctionalInterface
public interface SubmitHandler<T> {

    void submit(T t);
}
