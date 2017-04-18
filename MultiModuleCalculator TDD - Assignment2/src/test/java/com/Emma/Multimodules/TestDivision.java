package com.Watson.Multimodules;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by Watson/Long on 3/17/2017.
 */
public class TestDivision extends TestCase {

    private boolean IntegersAreValid = false;
    Division divObject = new Division();

    public void testIfNumbersAreValid() throws Exception {
        try {
            divObject.setInteger1(93);
            divObject.setInteger2(10);
            assertEquals(true, divObject.getInteger2() > 0);
            IntegersAreValid = true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void testDivision() throws Exception
    {
        if (IntegersAreValid)
        {
            divObject.divide();
        }
    }

}
