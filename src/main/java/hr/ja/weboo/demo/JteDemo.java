package hr.ja.weboo.demo;

import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;
import gg.jte.resolve.DirectoryCodeResolver;
import hr.ja.weboo.lib.Page;

import java.nio.file.Path;

public class JteDemo {

    public static void main(String[] args) {

        CodeResolver codeResolver = new DirectoryCodeResolver(Path.of("/Users/tag/DevProject/SpringBoot3weboo/src/main/resources/jte")); // This is the directory where your .jte files are located.
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html); // Two choices: Plain or Html

        TemplateOutput output = new StringOutput();
        JtePage page = new JtePage();
        page.setName("Janko");
        page.setAge(33);
        templateEngine.render("demo.jte", page, output);
        System.out.println(output);
    }
}
