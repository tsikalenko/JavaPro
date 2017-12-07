package com.gmail.tsikalenko.nikita;

public class Main {

    public static void main(String[] args) {
        TestClass tc = new TestClass("Name", 1, 2);
        String s = "";
        try {
            s = SDWorker.serialize(tc);
        } catch (IllegalAccessException e){
            e.printStackTrace();
            s = "error!";
        }

        System.out.println(s);

        TestClass tc2 = new TestClass();
        try{
            tc2 = SDWorker.deserialize(s,TestClass.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(tc2);
    }
}
