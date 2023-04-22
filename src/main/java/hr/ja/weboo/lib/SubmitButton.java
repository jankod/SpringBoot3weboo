package hr.ja.weboo.lib;

import lombok.Getter;

public class SubmitButton extends Widget {

    @Getter
    private final String label;

    public SubmitButton(String label) {
        this.label = label;
    }

    @Override
    public String toHtml() {

        return """
              <button type='submit' class='btn btn-primary'>%s</button>
              """.formatted(label);
    }
}

