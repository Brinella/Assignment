package com.lagardien.composition;
import java.util.*;
import javax.swing.*;
/**
 * Ijaaz Lagardien
 * Group 3A
 * Dr B. Kabaso
 * Date: 12 March 2016.
 */
public class RunClientAccount
{
    public static void main(String[] args) {
        Client fnbClient = new Client();
        Account fnbAccount = new Account();

        String name = JOptionPane.showInputDialog("Enter Client name: ");
        fnbClient.setClientName(name);
        String sName = JOptionPane.showInputDialog("Enter Client surname: ");
        fnbClient.setClientSurname(sName);
        String num = JOptionPane.showInputDialog("Enter Account Number: ");
        int accNum = Integer.parseInt(num);
        fnbAccount.setAccountNumber(accNum);
        String type = JOptionPane.showInputDialog("Enter Account Type: ");
        fnbAccount.setAccountType(type);
        String bal = JOptionPane.showInputDialog("Enter Account Balance: R");
        int accBal = Integer.parseInt(bal);
        fnbAccount.setAccountBalance(accBal);
        String deposit = JOptionPane.showInputDialog("Enter amount to deposit: R");
        int dep = Integer.parseInt(deposit);
        fnbAccount.deposit(dep);
        if(accBal > 0)
        {
            String withraw = JOptionPane.showInputDialog("Enter amount to withdraw: R");
            int wDraw = Integer.parseInt(withraw);
            fnbAccount.withdraw(wDraw);
        }
        fnbClient.setClientAccount(fnbAccount);
        JOptionPane.showMessageDialog(null, fnbClient.toString());
    }
}
