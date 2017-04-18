package com.Watson.Multimodules;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by Long on 3/17/2017.
 */
public class TestMultiplication extends TestCase {

    Multiplication multiObject = new Multiplication();

    public void testIntegerInput() throws Exception
    {
        multiObject.setInteger1(9);
        multiObject.setInteger2(7);
        Assert.assertTrue(multiObject.getInteger1() != 0);
        Assert.assertTrue(multiObject.getInteger2() !=0);
    }

    public void testMultiplication() throws Exception
    {
        multiObject.multiply();
    }
}
