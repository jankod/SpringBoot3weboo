package hr.ja.weboo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UndertowDemo {
//    public static void main(String[] args) {
//
//        Undertow server = Undertow.builder()
//              .addHttpListener(8080, "localhost")
//              .setHandler(exchange -> {
//                  FormData attachment = exchange.getAttachment(FormDataParser.FORM_DATA);
//                  log.debug("form {}", attachment);
//                  exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/html");
//
//                  exchange.getResponseSender().send(HtmlUtil.h3("Ovo dela").toHtml());
//              }).build();
//        System.out.println("http//localhost:8080/");
//        server.start();
//
//    }
}
