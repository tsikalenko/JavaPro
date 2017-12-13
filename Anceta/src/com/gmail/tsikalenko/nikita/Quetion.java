package com.gmail.tsikalenko.nikita;

public class Quetion {
    private String name;
    private int v1;
    private int v2;

    public Quetion(String name) {
        this.name = name;
    }

    public Quetion() {
    }

    public String getName() {
        return name;
    }

    public void add(int a1, int a2){
        v1+=a1;
        v2+=a2;
    }

    @Override
    public String toString() {
        return name + ": " +
                "Yes = " + v1 +
                ", No = " + v2;
    }
}
