/*
Emma Dina-Matouba 213134187
 */

import java.util.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.io.*;
import java.net.*;
import java.sql.*;

public class Client extends JFrame implements ActionListener
{
    private JMenuBar mBar = new JMenuBar();

    private JMenu fileMenu = new JMenu("File");
    private JMenu cMenu = new JMenu("Customer");
    private JMenu vMenu = new JMenu("Vehicle");
    private JMenu rentMenu = new JMenu("Rent");
    private JMenu returnMenu = new JMenu("Return");
    private JMenu rMenu = new JMenu("Report");
    private JMenu hMenu = new JMenu("Help");

    private JMenuItem exitItem = new JMenuItem("Exit");

    private JMenuItem acItem = new JMenuItem("Add Customer");
    private JMenuItem vcItem = new JMenuItem("View Customer");

    private JMenuItem avItem = new JMenuItem("Add Vehicle");

    private JMenu vvItem = new JMenu("View Vehicle");
    private JMenuItem vvSEDANItem = new JMenuItem("Sedan");
    private JMenuItem vvSUVItem = new JMenuItem("SUV");

    private JMenuItem existingItem = new JMenuItem("Select an existing customer");

    private JMenu categoryItem = new JMenu("Select a category of required vehicle");
    private JMenuItem sedanI = new JMenuItem("Sedan");
    private JMenuItem suvI = new JMenuItem("SUV");

    private JMenuItem enterItem = new JMenuItem("Select/enter the rental number");

    private JMenuItem vRentals = new JMenuItem("View All Rentals");
    private JMenuItem oRentals = new JMenuItem("View OutStanding Rentals");
    private JMenuItem dRentals = new JMenuItem("View Daily Rentals");

    private JMenuItem aItem = new JMenuItem("About");

    private JTextArea at = new JTextArea(20,20);

     private JTextField idTxt = new JTextField(20);
    private JTextField fnTxt = new JTextField(10);
    private JTextField snTxt = new JTextField(10);
    private JTextField pnTxt = new JTextField(10);
    private JTextField apTxt = new JTextField(10);
    private JTextField vTxt = new JTextField(10);

    private JLabel idlbl = new JLabel("Customer Number:");
    private JLabel fnlbl = new JLabel("First Name:");
    private JLabel snlbl = new JLabel("Surname:");
    private JLabel pnlbl = new JLabel("Phone Number:");
    private JLabel vlbl = new JLabel("Vehicle:");
    private JLabel aplbl = new JLabel("Amount Paid:");

    private JButton saveBtn = new JButton("Save");
    private JButton saveBtnV = new JButton("Save");

    private final String[] vv = {"SEDAN", "SUV"};
    private String[] rList;

    private JComboBox inputCmbA = new JComboBox(vv);
    private JComboBox rCmbA;

    private JLabel idlbl2;
    private JLabel fnlbl2;
    private JTextField idTxt2 = new JTextField(20);

    private Socket server;

    private ObjectOutputStream out;
    private ObjectInputStream in;

    private ObjectInputStream inC;
    private ObjectInputStream inV;
    private ObjectInputStream inR;

    private Customer c;
    private Vehicle v;
    private Rental r;

    private ArrayList<Customer> cAL = new ArrayList<Customer>();
    private ArrayList<Vehicle> vAL = new ArrayList<Vehicle>();
    private ArrayList<Rental> rAL = new ArrayList<Rental>();

    private ArrayList<Customer> cAL2 = new ArrayList<Customer>();
    private ArrayList<Vehicle> vAL2 = new ArrayList<Vehicle>();

    private Object o;

    private ArrayList<Object> oAL = new ArrayList<Object>();


    private String writeToFile;

    private Scanner scan = new Scanner(System.in);

    private CustomerAdd cAdd;

    private int vNum = 0;

    public Client()
    {super("Client");
        setLayout(new FlowLayout());

        setSize(700,480);

        setJMenuBar(mBar);

        mBar.add(fileMenu);
        mBar.add(cMenu);
        mBar.add(vMenu);
        mBar.add(rentMenu);
        mBar.add(returnMenu);
        mBar.add(rMenu);
        mBar.add(hMenu);

        fileMenu.add(exitItem);

        cMenu.add(acItem);
        cMenu.add(vcItem);

        vMenu.add(avItem);
        vMenu.add(vvItem);

        rentMenu.add(existingItem);
        rentMenu.add(categoryItem);

        vvItem.add(vvSEDANItem);
        vvItem.add(vvSUVItem);

        categoryItem.add(sedanI);
        categoryItem.add(suvI);

        returnMenu.add(enterItem);

        rMenu.add(vRentals);
        rMenu.add(oRentals);
        rMenu.add(dRentals);

        hMenu.add(aItem);

        add(at);
        at.setText("Welcome to our car rental service");

         add(idlbl);
                add(idTxt);

                add(fnlbl);
                add(fnTxt);

                add(snlbl);
                add(snTxt);

                add(vlbl);
                add(vTxt);

                add(pnlbl);
                add(pnTxt);

                add(aplbl);
                add(apTxt);


                add(saveBtn);

        idlbl.setVisible(false);
                idTxt.setVisible(false);

                fnlbl.setVisible(false);
                fnTxt.setVisible(false);

                snlbl.setVisible(false);
                snTxt.setVisible(false);

                vlbl.setVisible(false);
                vTxt.setVisible(false);

                pnlbl.setVisible(false);
                pnTxt.setVisible(false);

                aplbl.setVisible(false);
                apTxt.setVisible(false);

                saveBtn.setVisible(false);

                idlbl2 = new JLabel("Make:");
            fnlbl2 = new JLabel("category:");

                add(idlbl2);
                add(idTxt2);

                add(fnlbl2);
                add(inputCmbA);

                add(saveBtnV);

                idlbl2.setVisible(false);
                idTxt2.setVisible(false);
                fnlbl2.setVisible(false);
                saveBtnV.setVisible(false);
                inputCmbA.setVisible(false);



//                 rCmbA.setVisible(false);

        exitItem.addActionListener(this);
        acItem.addActionListener(this);

        vcItem.addActionListener(this);
        avItem.addActionListener(this);

        vvSUVItem.addActionListener(this);
        vvSEDANItem.addActionListener(this);

        categoryItem.addActionListener(this);

        existingItem.addActionListener(this);

        suvI.addActionListener(this);
        sedanI.addActionListener(this);

        enterItem.addActionListener(this);

        vRentals.addActionListener(this);
        oRentals.addActionListener(this);
        dRentals.addActionListener(this);

        saveBtn.addActionListener(this);
        saveBtnV.addActionListener(this);

        aItem.addActionListener(this);

        try
        {
            server = new Socket("127.0.0.1", 12345);
        }
        catch (IOException ioe)
        {
            System.out.println("IOException: " + ioe.getMessage());
        }

    }

    public void openFile()
    {
        try
          {
              inV = new ObjectInputStream( new FileInputStream( "vehicle.ser" ) );
              inC = new ObjectInputStream( new FileInputStream( "customer.ser" ) );
              inR = new ObjectInputStream( new FileInputStream( "rental.ser" ) );

          }

          catch(IOException  e)
          {
              System.out.println( e.getMessage() );
          }
    }

    private class SortList implements Comparator<Customer>
    {
        public int compare(Customer g1, Customer g2)
        {
            String g11 = g1.getFirstName().toUpperCase();
            String g22 = g2.getFirstName().toUpperCase();

            return g11.compareTo(g22);
        }
    }

    private class SortListV implements Comparator<Vehicle>
    {
        public int compare(Vehicle g1, Vehicle g2)
        {
            String g11 = g1.getMake().toUpperCase();
            String g22 = g2.getMake().toUpperCase();

            return g11.compareTo(g22);
        }
    }

    public void readAndWriteFile()
    {
        int i =0;
        try
          {
              while(true)
              {

                  c = ( Customer ) inC.readObject();
                  oAL.add(c);

                  v = ( Vehicle ) inV.readObject();
                  oAL.add(v);

                  r = ( Rental ) inR.readObject();
                  oAL.add(r);

              }
          }

          catch(EOFException ioe)
          {
              return;
          }
          catch ( ClassNotFoundException classNotFoundException )
          {
              System.err.println( "Unable to create object." );
          }
          catch(IOException  e)
          {
              System.out.println( e.getMessage() );
          }
    }

    public void readAndWrite()
    {
        for(int i = 0; i < oAL.size(); i++)
        {
                  writeToFile = String.format("%s%n%n", oAL.get(i).toString());
                  System.out.println( writeToFile );
       }
    }

    public void rent()
    {
    }

    public void actionPerformed(ActionEvent e)
    {
        int j = 0;

        String msg = "";

        if(e.getSource() == aItem)
        {
            Aboutpg p = new Aboutpg();

            this.setVisible(false);
            p.setVisible(true);
        }
        else if(e.getSource() == exitItem)
        {

            try
            {
                out.writeObject( "TERMINATE" );
                out.flush();
            }
            catch (IOException ioe)
            {
                System.out.println("IOException: " + ioe.getMessage());
            }

            JOptionPane.showMessageDialog(null, "Thank you and have a nice day");
            msg = "TERMINATE";
            System.exit(0);
        }

        else if(e.getSource() == acItem)
        {
           idlbl2.setVisible(false);
                idTxt2.setVisible(false);

                fnlbl2.setVisible(false);
                saveBtnV.setVisible(false);
                inputCmbA.setVisible(false);

            at.setVisible(false);
//
//                 idlbl.setVisible(true);
//                 idTxt.setVisible(true);

                fnlbl.setVisible(true);
                fnTxt.setVisible(true);

                snlbl.setVisible(true);
                snTxt.setVisible(true);

                pnlbl.setVisible(true);
                pnTxt.setVisible(true);

//
//
                saveBtn.setVisible(true);
        }

        else if(e.getSource() == saveBtn)
        {
//             String ids = idTxt.getText();
//             int id = Integer.parseInt(ids);
            int cNum = c.getCustNumber();
            cNum++;

            String fn = fnTxt.getText();
            String sn = snTxt.getText();
            String addr = pnTxt.getText();

            boolean ret = true;

                         c = new Customer(cNum, fn, sn, addr, ret);

            try
            {
                out.writeObject( c );
                out.flush();
            }
            catch (IOException ioe)
            {
                System.out.println("IOException: " + ioe.getMessage());
            }
        }
        else if(e.getSource() == vcItem)
        {
            try
            {
                in = new ObjectInputStream(server.getInputStream());

                out.writeObject( "view Customers" );
                out.flush();

                do
                {
                        c = (Customer)in.readObject();
                        cAL.add(c);
                }while( !c.getFirstName().equals("Denise") );

               Collections.sort(cAL, new SortList());
               at.setText("Customer Number\tFirst Name\tSurname\tAddress\tAvailable for Rent\n\n");

               for(int i = 0; i < cAL.size(); i++)
                    {
                        at.append( cAL.get(i).toString() + "\n" );
                    }
            }
            catch (IOException ioe)
            {
                System.out.println("IOException: " + ioe.getMessage());
            }
            catch (ClassNotFoundException cnfe)
            {
                System.out.println("Class not found: " + cnfe.getMessage());
            }
        }

        else if(e.getSource() == avItem)
        {
             at.setVisible(false);

                idlbl.setVisible(false);
                idTxt.setVisible(false);

                fnlbl.setVisible(false);
                fnTxt.setVisible(false);

                snlbl.setVisible(false);
                snTxt.setVisible(false);

                vlbl.setVisible(false);
                vTxt.setVisible(false);

                pnlbl.setVisible(false);
                pnTxt.setVisible(false);

                aplbl.setVisible(false);
                apTxt.setVisible(false);

                saveBtn.setVisible(false);

                idlbl2.setVisible(true);
                idTxt2.setVisible(true);
                fnlbl2.setVisible(true);
                saveBtnV.setVisible(true);
                inputCmbA.setVisible(true);
        }
        else if(e.getSource() == saveBtnV)
        {
                         vNum++;

            String m = idTxt2.getText();
            String cat = (String)inputCmbA.getSelectedItem();

            boolean ret = true;
            int caT = 1;
                            if(cat.equals("SUV"))
                               caT = 2;


                         v = new Vehicle(vNum ,m, caT, ret);

            try
            {
                out.writeObject( v );
                out.flush();
            }
            catch (IOException ioe)
            {
                System.out.println("IOException: " + ioe.getMessage());
            }
        }
        else if(e.getSource() == vvSUVItem)
        {
            try
            {
                in = new ObjectInputStream(server.getInputStream());

                out.writeObject( "view Vehicle SUV" );
                out.flush();

                 do
                {
                    v = (Vehicle)in.readObject();
                    vAL.add(v);

                }while( !v.getMake().equals("Volvo XC70") );

               Collections.sort(vAL, new SortListV());
               at.setText("Vehicle Number\tMake\tCategory\tRental Price\tAvailable For Rent\n\n");

               for(int i = 0; i < vAL.size(); i++)
                    {
                        at.append( vAL.get(i).toString() + "\n" );
                    }
            }
            catch (IOException ioe)
            {
                System.out.println("IOException: " + ioe.getMessage());
            }
            catch (ClassNotFoundException cnfe)
            {
                System.out.println("Class not found: " + cnfe.getMessage());
            }
        }

        else if(e.getSource() == vvSEDANItem)
        {
            try
            {
                in = new ObjectInputStream(server.getInputStream());

                out.writeObject( "view Vehicle SEDAN" );
                out.flush();

                 do
                {
                    v = (Vehicle)in.readObject();
                    vAL.add(v);

                }while( !v.getMake().equals("Audi A7") );

               Collections.sort(vAL, new SortListV());
               at.setText("Vehicle Number\tMake\t\tCategory\tRental Price\tAvailable For Rent\n\n");

               for(int i = 0; i < vAL.size(); i++)
                    {
                        at.append( vAL.get(i).toString() + "\n" );
                    }
            }
            catch (IOException ioe)
            {
                System.out.println("IOException: " + ioe.getMessage());
            }
            catch (ClassNotFoundException cnfe)
            {
                System.out.println("Class not found: " + cnfe.getMessage());
            }
        }

        else if(e.getSource() == existingItem)
        {
             idlbl2.setVisible(false);
                idTxt2.setVisible(false);

                fnlbl2.setVisible(false);
                saveBtnV.setVisible(false);
                inputCmbA.setVisible(false);

                at.setVisible(false);
                idlbl.setVisible(false);
                idTxt.setVisible(false);

                fnlbl.setVisible(false);
                fnTxt.setVisible(false);

                snlbl.setVisible(false);
                snTxt.setVisible(false);

                vlbl.setVisible(false);
                vTxt.setVisible(false);

                pnlbl.setVisible(false);
                pnTxt.setVisible(false);

                aplbl.setVisible(false);
                apTxt.setVisible(false);

                saveBtn.setVisible(false);




            try
            {
                in = new ObjectInputStream(server.getInputStream());

                out.writeObject( "existing" );
                out.flush();

                do
                {
                    c = (Customer)in.readObject();

//                    rList[j] = c.getFirstName();
//                 rCmbA.(c.getFirstName());
//                    j++;
                }while( !c.getFirstName().equals("546") );

//                 add(rCmbA);
//                 rCmbA.setVisible(true);
            }
            catch (IOException ioe)
            {
                System.out.println("IOException: " + ioe.getMessage());
            }
            catch (ClassNotFoundException cnfe)
            {
                System.out.println("Class not found: " + cnfe.getMessage());
            }
        }
            else if(e.getSource() == suvI)
            {
                try
                {
                    in = new ObjectInputStream(server.getInputStream());

                    out.writeObject( "suv" );
                    out.flush();

                        v = (Vehicle)in.readObject();
                        vAL.add(v);

                   Collections.sort(vAL, new SortListV());
                   at.setText("Vehicle Number\tMake\t\tCategory\tRental Price\tAvailable For Rent\n\n");

                   for(int i = 0; i < vAL.size(); i++)
                        {
                            at.append( vAL.get(i).toString() + "\n" );
                        }
                }
                catch (IOException ioe)
                {
                    System.out.println("IOException: " + ioe.getMessage());
                }
                catch (ClassNotFoundException cnfe)
                {
                    System.out.println("Class not found: " + cnfe.getMessage());
                }
            }

            else if(e.getSource() == sedanI)
            {

                try
                {
                    in = new ObjectInputStream(server.getInputStream());

                    out.writeObject( "sedan" );
                    out.flush();


                        v = (Vehicle)in.readObject();
                        vAL.add(v);

                   Collections.sort(vAL, new SortListV());
                   at.setText("Vehicle Number\tMake\t\tCategory\tRental Price\tAvailable For Rent\n\n");

                   for(int i = 0; i < vAL.size(); i++)
                        {
                            at.append( vAL.get(i).toString() + "\n" );
                        }
                }

                catch (IOException ioe)
                {
                    System.out.println("IOException: " + ioe.getMessage());
                }
                catch (ClassNotFoundException cnfe)
                {
                    System.out.println("Class not found: " + cnfe.getMessage());
                }
            }
            else if(e.getSource() == vRentals)
            {
                try
                {
                 in = new ObjectInputStream(server.getInputStream());

                    out.writeObject( "View All Rentals" );
                    out.flush();

                    do
                    {
                     r = (Rental)in.readObject();
                        rAL.add(r);
                    }while (r.getRentalNumber() == 6);

//                       Collections.sort(vAL, new SortListV());
                   at.setText("rental Number\tdate Rented\tdate Returned\tprice Per Day\ttotal Rental\tcust Number\tveh Number\n\n");

                   for(int i = 0; i < rAL.size(); i++)
                        {
                            at.append( rAL.get(i).toString() + "\n" );
                        }
                }
                catch (IOException ioe)
                {
                    System.out.println("IOException: " + ioe.getMessage());
                }
                catch (ClassNotFoundException cnfe)
                {
                    System.out.println("Class not found: " + cnfe.getMessage());
                }
            }
    }
   public void communicate()
   {
       String response = "";

       try
       {
           out = new ObjectOutputStream(server.getOutputStream());
           out.flush();

               for(int i = 0; i < oAL.size(); i++ )
               {
                   out.writeObject( oAL.get(i) );
                   out.flush();
               }

//
//                    o = (Object)in.readObject();
//                    System.out.println("From Server>> " + o.toString());

//                System.out.println("Type: ");
//                response = scan.nextLine();
//
//                out.writeObject( response );
//                out.flush();


       }
        catch (IOException ioe)
        {
            System.out.println("IOException: " + ioe.getMessage());
        }
//         catch (ClassNotFoundException cnfe)
//         {
//             System.out.println("Class not found: " + cnfe.getMessage());
//         }
   }



    public void closeFile()
    {
        try
          {
              inC.close();
              inV.close();
              inR.close();

          }

          catch(IOException  e)
          {
              System.out.println( e.getMessage() );
          }
//         catch (ClassNotFoundException cnfe)
//         {
//             System.out.println("Class not found: " + cnfe.getMessage());
//         }
    }


    public static void main(String[] args)
    {
        Client gui = new Client();

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(700,480);
        gui.setVisible(true);

        gui.openFile();
        gui.readAndWriteFile();
        gui.communicate();
//         gui.readAndWrite();
        gui.closeFile();
    }
}
