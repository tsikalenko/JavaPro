package com.gmail.tsikalenko.nikita;

public class TestClass {
    @Save
    private String s;
    @Save
    private int i;
    private int i2;

    public TestClass(String s, int i, int i2) {
        this.s = s;
        this.i = i;
        this.i2 = i2;
    }

    public TestClass() {
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", i2=" + i2 +
                '}';
    }
}
