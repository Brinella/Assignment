package com.lagardien.inheritance;
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
        String name = JOptionPane.showInputDialog("Enter Client name: ");
        fnbClient.setClientName(name);
        String sName = JOptionPane.showInputDialog("Enter Client surname: ");
        fnbClient.setClientSurname(sName);
        String num = JOptionPane.showInputDialog("Enter Account Number: ");
        int accNum = Integer.parseInt(num);
        fnbClient.setAccountNumber(accNum);
        String type = JOptionPane.showInputDialog("Enter Account Type: ");
        fnbClient.setAccountType(type);
        String bal = JOptionPane.showInputDialog("Enter Account Balance: R");
        int accBal = Integer.parseInt(bal);
        fnbClient.setAccountBalance(accBal);
        String deposit = JOptionPane.showInputDialog("Enter amount to deposit: R");
        int dep = Integer.parseInt(deposit);
        fnbClient.deposit(dep);
        if(accBal > 0) {
            String withraw = JOptionPane.showInputDialog("Enter amount to withdraw: R");
            int wDraw = Integer.parseInt(withraw);
            fnbClient.withdraw(wDraw);
        }
        JOptionPane.showMessageDialog(null, "Account Number: " +fnbClient.getAccountNumber() + "\nName " + fnbClient.getClientName()+ "\nSurname " + fnbClient.getClientSurname() + "\nAccount Type: " + fnbClient.getAccountType() + "\nBalance: " + fnbClient.getAccountBalance());
    }
}
