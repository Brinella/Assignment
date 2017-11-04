import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Aboutpg extends JFrame implements ActionListener
{
    private JLabel areaTxt = new JLabel("This is an information management application for a small car");
    private JLabel areaTxt2 = new JLabel (" rental agency. This agency is starting out with only 2 categories of vehicles,");
    private JLabel areaTxt3 = new JLabel ("luxury sedans (R450 per day) and luxury SUVs (R500 per day).");
    
    private JButton closeBtn = new JButton("Close");
    
    private JPanel centerPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    
    public Aboutpg()
    {
        super("About Page");
        
        setSize(640,240);
                
        setLayout(new BorderLayout());
        
        
        areaTxt.setFont(new java.awt.Font("Tahoma", 3, 15));
        areaTxt2.setFont(new java.awt.Font("Tahoma", 3, 15));
        areaTxt3.setFont(new java.awt.Font("Tahoma", 3, 15));
        
        centerPanel.setLayout(new GridLayout(3,1));
        centerPanel.add(areaTxt);
        centerPanel.add(areaTxt2);
        centerPanel.add(areaTxt3);
        add(centerPanel, BorderLayout.CENTER);
        
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(closeBtn);
        add(bottomPanel, BorderLayout.SOUTH);
        
        
        
        closeBtn.addActionListener(this);        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == closeBtn )
        {   
                  Client c = new Client();
                    
                  this.setVisible(false);
                  c.setVisible(true);
        }  
    }
    
    public static void main(String[] args)
    {
        Aboutpg gui = new Aboutpg();
        
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(640,240);
        gui.setVisible(true);
    }
    
}
