package com.gmail.tsikalenko.nikita;

import com.sun.javaws.exceptions.InvalidArgumentException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormServlet extends javax.servlet.http.HttpServlet {
    static final String TEMPLATE = "<html>" +
            "<head>" +
            "        <title>Statistic</title>" +
            "    </head>" +
            "    <body>" +
            "        %s" +
            "        <br/><br/><a href = \"/\"><button>Go again</button></a>" +
            "    </body>" +
            "</html>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String temp = "";
        String login = req.getParameter("login");
        String sage = req.getParameter("age");
        int age = Integer.parseInt(sage);
        String sex = req.getParameter("sex").equals("male") ? "male" : "female";
        String q1 = req.getParameter("question1");
        String q2 = req.getParameter("question2");
        String answer = "";

        answer += "yes".equals(q1) ? 1 : 0;
        answer += "yes".equals(q2) ? 1 : 0;

        UsersBase.addUser(login, age, sex, answer);

        try {
            Answer.addAnswer(UsersBase.findUser(login), answer);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        temp += Answer.printIndividualStatistic(UsersBase.findUser(login)) + "<br/>";
        temp += Answer.print();



        resp.getWriter().println(String.format(TEMPLATE, temp));
    }
}
