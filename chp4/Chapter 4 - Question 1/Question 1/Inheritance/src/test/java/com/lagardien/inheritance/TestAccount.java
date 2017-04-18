package com.lagardien.inheritance;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Ijaaz Lagardien
 * Group 3A
 * Dr B. Kabaso
 * Date: 12 March 2016.
 */
public class TestAccount
{
    private  Account accObject;
    @Before
    public void setUp() throws Exception {
        accObject = new Account();
    }

    @Test
    public void testSetAccountNumber() throws Exception {
        accObject.setAccountNumber(987654321);
        Assert.assertEquals(987654321,987654321);
    }

    @Test
    public void testSetAccountType() throws Exception {
        accObject.setAccountType("Cheque Account");
        Assert.assertEquals("Cheque Account", "Cheque Account");
    }

    @Test
    public void testSetAccountBalance() throws Exception {
        accObject.setAccountBalance(939393);
        Assert.assertEquals(939393,939393);
    }

    @Test
    public void testGetAccountNumber() throws Exception {
        accObject.setAccountNumber(123456789);
        Assert.assertEquals(accObject.getAccountNumber(),123456789);
    }

    @Test
    public void testGetAccountType() throws Exception {
        accObject.setAccountType("Cheque Account");
        Assert.assertEquals(accObject.getAccountType(),"Cheque Account");
    }

    @Test
    public void testGetAccountBalance() throws Exception {
        accObject.setAccountBalance(7000000);
        Assert.assertEquals(accObject.getAccountBalance(),7000000,0);
    }

    @Test
    public void testWithdraw() throws Exception {
        accObject.setAccountBalance(7000000);
        accObject.withdraw(1000000);
        Assert.assertEquals(6000000,6000000);
    }

    @Test
    public void testDeposit() throws Exception {
        accObject.setAccountBalance(7000000);
        accObject.deposit(500000);
        Assert.assertEquals(7500000,7500000);
    }
}
