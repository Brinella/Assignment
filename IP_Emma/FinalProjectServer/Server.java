/*
 * Emma Dina-Matouba 213134187
 */
import java.util.*;
import java.io.*;
import java.net.*;

import java.sql.*;

public class Server
{
    private ServerSocket listener;
    private Socket client;

    private Connection con;
    private Statement s;

    private Rental r;
    private Customer c;
    private Vehicle v;

    private Object o;

    private int countV = 0;
    private ArrayList<Customer> cAL = new ArrayList<Customer>();

    private ObjectOutputStream out;
    private ObjectInputStream in;

     public Server()
    {
        try
        {
            listener = new ServerSocket(12345, 10);
        }
        catch (IOException ioe)
        {
          System.out.println("IO Exception: " + ioe.getMessage());
        }
    }

     public void listen()
    {
        try
        {
            System.out.println("Server is listening");
            client = listener.accept();

            processClient();
        }
        catch(IOException ioe)
        {
            System.out.println("IO Exception: " + ioe.getMessage());
        }
    }

    public void openDB()
    {
        try
        {
           String filename = "publisher.mdb";
           String dbURL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
           dbURL+= filename.trim() + ";DriverID=22;READONLY=true}";

           String driverName = "sun.jdbc.odbc.JdbcOdbcDriver";

            System.out.println("About to Load the JDBC Driver....");
            Class.forName(driverName);
            System.out.println("Driver Loaded Successfully....");
            System.out.println("About to get a connection....");

            con = DriverManager.getConnection(dbURL, "","");
            System.out.println("Connection Established Successfully....");

            s = con.createStatement();
            System.out.println("Statement object created Successfully....");

            System.out.println("About to execute SQL stmt....");
        }
        catch (Exception err)
        {
            System.out.println("ERROR: " + err);
        }
    }

    public void processClient()
    {
        String msg = "";
        String q = "Yes";

        try
        {
            out = new ObjectOutputStream(client.getOutputStream());
            out.flush();
            in = new ObjectInputStream(client.getInputStream());

            do
            {
                o = (Object)in.readObject();


            if( o.getClass().getName().equals("Customer"))
                {
                    c = (Customer)o;
                    cAL.add(c);

                    String choice = "Yes";
                    if(c.getCanRent() == false)
                        choice = "No";

                    try
                    {
                        String insert_Values_stmt = " insert into Customer values ('" + c.getCustNumber() + "','" + c.getFirstName() + "','" + c.getSurName() + "','" + c.getAddress() + "','" + choice + "')";
                        s.executeUpdate(insert_Values_stmt);
                        System.out.println("SQL statement executed  Successfully....");


                    }
                    catch (Exception err)
                    {
                        System.out.println("ERROR: " + err);
                    }

                }
                else if( o.getClass().getName().equals("Vehicle"))
                {
                    countV++;

                    String choice = "Yes";

                    v = (Vehicle)o;

                    if(v.isAvailableForRent() == false)
                        choice = "No";

                    try
                    {
                         String insert_Values_stmt = " insert into Vehicle values ('" + v.getVehNumber() + "','" +  v.getMake() + "','" + v.getCategory() + "','" + v.getRentalPrice() + "','" + choice + "')";
                         s.executeUpdate(insert_Values_stmt);
                         System.out.println("SQL statement executed  Successfully....");
                    }
                    catch (Exception err)
                    {
                        System.out.println("ERROR: " + err);
                    }
                }
                else if( o.getClass().getName().equals("Rental"))
                {
                    r = (Rental)o;

//                     double totalRental = r.dateDifference(r.getDateRented(), r.getDateReturned()) * r.getPricePerDay();

                    try
                    {
                         String insert_Values_stmt = " insert into Rental values ('" + r.getRentalNumber() + "','" +  r.getDateRented() + "','" + r.getDateReturned() + "','" + r.getPricePerDay() + "','" + 1 + "','" + c.getCustNumber() + "','" + v.getVehNumber() + "')";
                         s.executeUpdate(insert_Values_stmt);
                         System.out.println("SQL statement executed  Successfully....");
                    }
                    catch (Exception err)
                    {
                        System.out.println("ERROR: " + err);
                    }
                }

               else if( o.toString().equals("existing"))
               {
                    System.out.println("Waiting");
                   String retrieve_Values_qry="SELECT * FROM Customer";
                   ResultSet rs = s.executeQuery(retrieve_Values_qry);

                   if (rs != null) // if rs == null, then there is no ResultSet to view
                   {
                        while ( rs.next() ) // this will step through our data row-by-row
                        {
                         String cn = rs.getString("CustNumber");
                         String fn = rs.getString("firstName");
                         String sn = rs.getString("surName");
                         String addr = rs.getString("addr");
                         String cr = rs.getString("canRent");

                         boolean ret = true;
                         if(cr.equals("No"))
                            ret = false;
                         int cNum = Integer.parseInt(cn);

                         c = new Customer(cNum, fn, sn, addr, ret);

                         out.writeObject(c);
                         out.flush();

                          System.out.println("Complete");
                        }
                   }
               }

               else if( o.toString().equals("suv"))
               {
                   System.out.println("Waiting");
                   String retrieve_Values_qry = "SELECT * FROM Vehicle WHERE category = 'SUV' ";
                   ResultSet rs = s.executeQuery(retrieve_Values_qry);

                   if (rs != null) // if rs == null, then there is no ResultSet to view
                   {
                        while ( rs.next() ) // this will step through our data row-by-row
                        {

                         String cn = rs.getString("vehNumber");
                         String m = rs.getString("make");
                         String cat = rs.getString("category");  //int
                         String rp = rs.getString("rentalPrice"); //double
                         String ar = rs.getString("availableToRent"); //bool

                         int caT = 1;
                         boolean ret = true;
                         int cNum = Integer.parseInt(cn);

                         if(ar.equals("No"))
                            ret = false;
                         if(cat.equals("SUV"))
                                caT = 2;

                         v = new Vehicle(cNum, m, caT, ret);

                         out.writeObject(v);
                         out.flush();
                        }
                   }
                }

                else if( o.toString().equals("sedan"))
                {
                   System.out.println("Waiting");
                   String retrieve_Values_qry = "SELECT * FROM Vehicle WHERE category = 'SEDAN' ";
                   ResultSet rs = s.executeQuery(retrieve_Values_qry);

                   if (rs != null) // if rs == null, then there is no ResultSet to view
                   {
                        while ( rs.next() ) // this will step through our data row-by-row
                        {

                         String cn = rs.getString("vehNumber");
                         String m = rs.getString("make");
                         String cat = rs.getString("category");  //int
                         String rp = rs.getString("rentalPrice"); //double
                         String ar = rs.getString("availableToRent"); //bool

                        int caT = 1;
                         boolean ret = true;
                         int cNum = Integer.parseInt(cn);

                         if(ar.equals("No"))
                            ret = false;
                         if(cat.equals("SUV"))
                                caT = 2;

                         v = new Vehicle(cNum, m, caT, ret);

                         out.writeObject(v);
                         out.flush();
                        }
                   }
                }

                 else if( o.toString().equals("view Customers"))
               {
                    System.out.println("Waiting");
                   String retrieve_Values_qry="SELECT * FROM Customer";
                   ResultSet rs = s.executeQuery(retrieve_Values_qry);

                   if (rs != null) // if rs == null, then there is no ResultSet to view
                   {
                        while ( rs.next() ) // this will step through our data row-by-row
                        {
                             String cn = rs.getString("CustNumber");
                             String fn = rs.getString("firstName");
                             String sn = rs.getString("surName");
                             String addr = rs.getString("addr");
                             String cr = rs.getString("canRent");

                         boolean ret = true;
                         int cNum = Integer.parseInt(cn);
                         if(cr.equals("No"))
                            ret = false;

                         c = new Customer(cNum, fn, sn, addr, ret);

                         out.writeObject(c);
                         out.flush();
                        }
                   }
               }

               else if( o.toString().equals("view Vehicle SUV"))
               {
                   System.out.println("Waiting");
                   String retrieve_Values_qry = "SELECT * FROM Vehicle WHERE category = 'SUV' ";
                   ResultSet rs = s.executeQuery(retrieve_Values_qry);

                   if (rs != null) // if rs == null, then there is no ResultSet to view
                   {
                        while ( rs.next() ) // this will step through our data row-by-row
                        {

                         String cn = rs.getString("vehNumber");
                         String m = rs.getString("make");
                         String cat = rs.getString("category");  //int
                         String rp = rs.getString("rentalPrice"); //double
                         String ar = rs.getString("availableForRent"); //bool

                          int caT = 1;
                         boolean ret = true;
                         int cNum = Integer.parseInt(cn);

                         if(ar.equals("No"))
                            ret = false;
                         if(cat.equals("SUV"))
                                caT = 2;

                         v = new Vehicle(cNum, m, caT, ret);

                         out.writeObject(v);
                         out.flush();

                            System.out.println("Complete");
                        }
                   }
                }

                else if( o.toString().equals("view Vehicle SEDAN"))
                {
                   System.out.println("Waiting");
                   String retrieve_Values_qry = "SELECT * FROM Vehicle WHERE category = 'Sedan' ";
                   ResultSet rs = s.executeQuery(retrieve_Values_qry);

                   if (rs != null) // if rs == null, then there is no ResultSet to view
                   {
                        while ( rs.next() ) // this will step through our data row-by-row
                        {

                         String cn = rs.getString("vehNumber");
                         String m = rs.getString("make");
                         String cat = rs.getString("category");  //int
                         String rp = rs.getString("rentalPrice"); //double
                         String ar = rs.getString("availableForRent"); //bool

                          int caT = 1;
                         boolean ret = true;
                         int cNum = Integer.parseInt(cn);

                         if(ar.equals("No"))
                            ret = false;
                         if(cat.equals("SUV"))
                                caT = 2;

                         v = new Vehicle(cNum, m, caT, ret);

                         out.writeObject(v);
                         out.flush();

                            System.out.println("Complete");
                        }
                   }
                }


                else if( o.toString().equals("View All Rentals"))
                {
                   System.out.println("Waiting");
                   String retrieve_Values_qry = "SELECT * FROM Rental";
                   ResultSet rs = s.executeQuery(retrieve_Values_qry);

                   if (rs != null) // if rs == null, then there is no ResultSet to view
                   {
                        while ( rs.next() ) // this will step through our data row-by-row
                        {

                         String rn = rs.getString("rentalNumber");
                         String dRent = rs.getString("dateRented");
                         String dReturn = rs.getString("dateReturned");  //int
                         String pDay = rs.getString("pricePerDay"); //double
                         String total = rs.getString("totalRental"); //bool
                         String cn = rs.getString("custNumber"); //bool
                         String vn = rs.getString("vehNumber"); //bool

                         int rNum = Integer.parseInt(rn);
                         int vNum = Integer.parseInt(vn);
                         int cNum = Integer.parseInt(cn);

                         double ppDay = Double.parseDouble(pDay);
                         double ttotal = Double.parseDouble(total);

                         r = new Rental(rNum, dRent, dReturn, ppDay, ttotal, cNum, vNum);

                         out.writeObject(r);
                         out.flush();

                            System.out.println("Complete");
                        }
                   }
                }

            }while(!o.toString().equals("TERMINATE"));
        }
        catch (IOException ioe)
        {
            System.out.println("IO Exception: " + ioe.getMessage());
        }
        catch (ClassNotFoundException cnfe)
        {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        catch (Exception err)
         {
                        System.out.println("ERROR: " + err);
         }
         closeDB();
    }

    public void closeDB()
    {
        try
        {
         System.out.println("About to close Statement....");
         s.close(); // close the Statement to let the database know we're done with it
         con.close(); // close the Connection to let the database know we're done with it
         System.out.println("Statement closed successfully....");

            out.close();
            in.close();
            client.close();
        }
        catch (IOException ioe)
        {
            System.out.println("IO Exception: " + ioe.getMessage());
        }
        catch (Exception err)
         {
                        System.out.println("ERROR: " + err);
         }

         System.exit(0);
    }


   public static void main(String[] args)
    {
        // Create application
        Server server = new Server();

        // Start waiting for connections
        server.openDB();
        server.listen();
    }
}
