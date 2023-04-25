package hr.ja.weboo.lib;

import hr.ja.weboo.lib.js.JsCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.BindingResult;

import java.io.Serializable;
import java.util.*;

@Data
public class AjaxFormResult {
    private List<ErrorResult> errors = new ArrayList<>();
    private List<JsCommand> jsCommands = new ArrayList<>();
    private boolean ok;

    public static AjaxFormResult redirect(String homeUrl) {
        AjaxFormResult a = new AjaxFormResult();
        a.ok = true;
        a.jsCommands.add(new JsCommand.RedirectJsCommand(homeUrl));
        return a;
    }

    public static AjaxFormResult error(BindingResult bindingResult) {
        AjaxFormResult a = new AjaxFormResult();

        if (bindingResult.hasErrors()) {
            a.ok = false;
        }

        if (bindingResult.hasFieldErrors())
            a.errors = bindingResult.getFieldErrors().stream().map(fe -> new ErrorResult(fe.getField(), fe.getDefaultMessage())).toList();
        if (bindingResult.hasGlobalErrors())
            a.errors.addAll(bindingResult.getGlobalErrors().stream().map(ge -> new ErrorResult("", ge.getDefaultMessage())).toList());
        return a;
    }

    public static AjaxFormResult commands(JsCommand... commands) {
        AjaxFormResult a = new AjaxFormResult();
        a.ok = true;
        a.jsCommands.addAll(Arrays.asList(commands));

        return a;
    }

    @Data
    @AllArgsConstructor
    public static class ErrorResult implements Serializable {
        private String field;
        private String message;
    }






}