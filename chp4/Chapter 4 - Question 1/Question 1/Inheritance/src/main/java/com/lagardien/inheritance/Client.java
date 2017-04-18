package com.lagardien.inheritance;

/**
 * Ijaaz Lagardien
 * Group 3A
 * Dr B. Kabaso
 * Date: 12 March 2016.
 */

public class Client extends Account
{
    private String clientName;
    private String clientSurname;

    public Client()
    {

    }

    public Client(String n, String sn, Account acc)
    {

    }

    public void setClientName(String n)
    {
        clientName = n;
    }

    public void setClientSurname(String sn)
    {
        clientSurname = sn;
    }

    public String getClientName()
    {
        return clientName;
    }

    public String getClientSurname()
    {
        return clientSurname;
    }
}
