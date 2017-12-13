package com.gmail.tsikalenko.nikita;

import java.util.HashMap;
import java.util.Map;

public class UsersBase {
    private static Map<String, User> uMap = new HashMap<>();

    public static void addUser(String login, int age, String sex, String answer) {
        uMap.put(login, new User(login, age, sex, answer));
    }

    public static User findUser(String login){
        return uMap.get(login);
    }
}
