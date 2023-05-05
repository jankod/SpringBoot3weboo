package hr.ja.weboo.service;

import hr.ja.weboo.lib.FormSubmitConsumer;
import hr.ja.weboo.lib.MyUtil;
import jakarta.servlet.http.HttpSession;
import lombok.Singular;

import java.io.Serializable;

public class SessionManager {


    public static void onSubmit(FormSubmitConsumer consumer, String formId) {
        HttpSession session = MyUtil.request().getSession(true);

    }


    public static void main(String[] args) {

    }
}

class TabMemory implements Serializable {


}
