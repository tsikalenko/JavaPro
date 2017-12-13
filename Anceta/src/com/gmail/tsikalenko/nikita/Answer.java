package com.gmail.tsikalenko.nikita;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.HashMap;
import java.util.Map;

public class Answer {
    private static Quetion q1 = new Quetion("q1");
    private static Quetion q2 = new Quetion("q2");
    private static Map<User, String> answers = new HashMap<>();

    public static void addAnswer(User user, String answer) throws IllegalArgumentException{
        answers.put(user, answer);
        if(answer.charAt(0) == '0'){
            q1.add(0,1);
        } else if(answer.charAt(0) == '1'){
            q1.add(1,0);
        } else{
            throw new IllegalArgumentException();
        }
        if(answer.charAt(1) == '0'){
            q2.add(0,1);
        } else if(answer.charAt(1) == '1'){
            q2.add(1,0);
        } else{
            throw new IllegalArgumentException();
        }
    }

    public static String printIndividualStatistic(User user){
        StringBuilder sb = new StringBuilder();

        sb.append("You answer: <br/>");

        sb.append(q1.getName()+": ");
        if (answers.get(user).charAt(0) == '1'){
            sb.append("Yes");
        } else {
            sb.append("No");
        }

        sb.append("<br/>").append(q2.getName() + ": ");
        if (answers.get(user).charAt(1) == '1'){
            sb.append("Yes");
        } else {
            sb.append("No");
        }
        return sb.toString();
    }
    public static String print() {
        return "All users answers: " +
                "<br/>" + q1 +
                "<br/>" + q2;
    }
}
