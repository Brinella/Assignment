package com.Watson.Multimodules;

import junit.framework.TestCase;

/**
 * Created by Long on 3/17/2017.
 */
public class TestAddition extends TestCase {

    private boolean integersAreValid = false;
    Addition add = new Addition();

    public void testSetInteger() throws Exception {
        try
        {
            add.setInt1(93);
            add.setInt2(27);
            integersAreValid = true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void testGetNumbers() throws Exception
    {
        add.getInt1();
        add.getInt2();
    }

    public void testAddition() throws Exception
    {
        if(  integersAreValid) {
            add.addition();
        }
    }
}


