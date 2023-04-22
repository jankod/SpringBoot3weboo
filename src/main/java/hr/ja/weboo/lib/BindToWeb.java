package hr.ja.weboo.lib;

@FunctionalInterface
public interface BindToWeb<M> {
    String getModelValue(M t);
}