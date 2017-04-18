package com.Watson.Multimodules;

/**
 * Created by Long on 3/17/2017.
 */
public class Subtraction {

    private int int1;
    private int int2;

    public void setInt1(int int1) {
        this.int1 = int1;
    }
    public void setInt2(int int2) {
        this.int2 = int2;
    }

    public int getInt1() {
        return int1;
    }

    public int getInt2() {
        return int2;
    }

    public int subtract()
    {
        return int1 - int2;
    }
}
