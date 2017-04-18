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
public class TestClient
{
    private Client fnbClient;
    @Before
    public void setUp() throws Exception {
        fnbClient = new Client();
    }

    @Test
    public void testSetClientName() throws Exception {
        fnbClient.setClientName("Ijaaz");
        Assert.assertEquals("Ijaaz","Ijaaz");
    }

    @Test
    public void testSetClientSurname() throws Exception {
        fnbClient.setClientSurname("Lagardien");
        Assert.assertEquals("Lagardien", "Lagardien");
    }

    @Test
    public void testGetClientName() throws Exception {
        fnbClient.setClientName("Ijaaz");
        Assert.assertEquals("Ijaaz", fnbClient.getClientName());
    }

    @Test
    public void testGetClientSurname() throws Exception {
        fnbClient.setClientSurname("Lagardien");
        Assert.assertEquals("Lagardien",fnbClient.getClientSurname());
    }
}
