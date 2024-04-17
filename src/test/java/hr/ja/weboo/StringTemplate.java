package hr.ja.weboo;

import java.util.Iterator;
import java.util.function.Function;

public class StringTemplate {
    public static void main(String[] args) {

        String name = "janko ";

        var L = java.lang.StringTemplate.Processor
              .of(s -> {
                  StringBuilder b = new StringBuilder();
                  Iterator<String> it = s.fragments().iterator();
                  System.out.println("fragments " + s.fragments());
                  System.out.println("values " + s.values());
                  System.out.println("inter " + s.interpolate());
                  for (Object value : s.values()) {

                  }
                  return "ss";
              });


        String s = L."""
        Ime je \{name} .
      """;

        System.out.println(s);

    }
}
