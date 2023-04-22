
package hr.ja.weboo.lib;

public interface Validator<M> {
        boolean hasError(M model);
    }