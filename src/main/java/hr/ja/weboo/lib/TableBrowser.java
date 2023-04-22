package hr.ja.weboo.lib;

import java.util.function.Supplier;

public class TableBrowser {
    public void on(Event event, Supplier<String> js) {
    }

    public enum Event {
        /**
         * https://tabulator.info/docs/5.4/events#select
         */
        ROW_SELECTED
    }
}
