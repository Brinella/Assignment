import java.util.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CustomerAdd extends JFrame implements ActionListener
{
    private JTextField idTxt = new JTextField(20);
    private JTextField fnTxt = new JTextField(10);
    private JTextField snTxt = new JTextField(10);
    private JTextField pnTxt = new JTextField(10);
    
    private JComboBox vTxt;
    private String[] vv;
    
    private JLabel idlbl = new JLabel("ID:");
    private JLabel fnlbl = new JLabel("First Name:");
    private JLabel snlbl = new JLabel("Surname:");
    private JLabel pnlbl = new JLabel("Phone Number:");
    
    private JButton saveBtn = new JButton("Save");
    
    private Client c;
    
    public CustomerAdd()
    {
        super("Add Customer");
        
        setLayout(new FlowLayout());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640,100);
        setVisible(true);
        
        add(idlbl);
        add(idTxt);
        
        add(fnlbl);
        add(fnTxt);
        
        add(snlbl);
        add(snTxt);
        
        vv[0] = "SEDAN";
        vv[1] = "SUV";
        
        vTxt = new JComboBox(vv);
        
        add(saveBtn);
        saveBtn.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == saveBtn)
        {
            System.exit(0);
        }
    }
    
//     public static void main(String[] args)
//     {
//         CustomerAdd c = new CustomerAdd();
//         
//         c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         c.setSize(640,100);
//         c.setVisible(true);
//         c.setResizable(true);
//     }
    
}
