package com.Watson.Multimodules;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by Long on 3/17/2017.
 */
public class TestSubtraction extends TestCase{

    private boolean isValidInteger = false;
    Subtraction subObject= new Subtraction();

    public void testSetInteger() throws Exception
    {
        try
        {
            subObject.setInt1(93);
            subObject.setInt2(27);
            Assert.assertTrue(subObject.getInt1() >= subObject.getInt2());
            isValidInteger = true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void testSubtraction() throws Exception
    {
        if(isValidInteger) {
            subObject.subtract();
        }
    }
}
