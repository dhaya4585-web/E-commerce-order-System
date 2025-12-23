/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_order_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dhaya
 */
public class DAO
{
    public Connection connect() throws ClassNotFoundException, SQLException
    {
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Book_Order_System", "postgres", "dhaya");
        return con;
    }
    public String insertpro(Model mo) throws ClassNotFoundException, SQLException
    {
        Connection con=connect();
        PreparedStatement ps=con.prepareStatement("select  product_insert(?,?,?)");
        ps.setString(1, mo.getPro_name());
        ps.setLong(2, mo.getPro_price());
        ps.setInt(3, mo.getPro_stock());
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            System.out.println("Successfully product inserted ");
             return rs.getString(1);
        }
     
        return null;
    }
     public String insertcus(Model mo) throws ClassNotFoundException, SQLException
    {
        Connection con=connect();
        PreparedStatement ps=con.prepareStatement("select customer_insert(?)");
        ps.setString(1, mo.getCus_name());
        
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            System.out.println("Successfully customer inserted ");
             return rs.getString(1);
        }
     
        return null;
    }
    public String placeorders(Model mo) throws ClassNotFoundException, SQLException
    {
        Connection con=connect();
        PreparedStatement ps=con.prepareStatement("select place_order(?,?,?)");
        ps.setInt(1, mo.getCus_id());
        ps.setInt(2, mo.getPro_id());
        ps.setInt(3, mo.getOrder_qty());
        
        
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            System.out.println("Successfully ordered ");
             return rs.getString(1);
        }
        con.commit();
        ps.close();
        rs.close();
     
        return null;
    }
    public String cancelorder(Model mo) throws ClassNotFoundException, SQLException
    {
        Connection con=connect();
        PreparedStatement ps=con.prepareStatement("select  cancel_order(?)");
        ps.setInt(1, mo.getOrder_item_id());
         ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            System.out.println("Successfully ordered cancel ");
             return rs.getString(1);
        }
        return null;
       
    }
     public void viweorderdate(Model mo) throws ClassNotFoundException, SQLException
    {
        Connection con=connect();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from orders");
        System.out.println("__________________________________________________________________________");
        System.out.println("order_id"+" "+"customer_id"+" "+"order_date");
        System.out.println("__________________________________________________________________________");
        while(rs.next())
        {
            System.out.println(rs.getInt("order_id")+   "             "+rs.getInt("customer_id")+   "    "+rs.getDate("order_date"));
        }
       
    }
    public void viweorderitem(Model mo) throws ClassNotFoundException, SQLException
    {
        Connection con=connect();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from order_items");
        System.out.println("__________________________________________________________________________");
        System.out.println("order_item_id"+" "+"order_id"+" "+"product_id"+" "+"quantity");
        System.out.println("__________________________________________________________________________");
        while(rs.next())
        {
            System.out.println(rs.getInt("order_item_id")+   "             "+rs.getInt("order_id")+   "    "+rs.getInt("product_id")+" "+rs.getInt("quantity"));
        }
       
    }
    public void viwecus(Model mo) throws ClassNotFoundException, SQLException
    {
        Connection con=connect();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from customers");
        System.out.println("______________________________________________________________________________");
        System.out.println("ID"+"  "+"Customer name");
        System.out.println("______________________________________________________________________________");
        while(rs.next())
        {
            
            System.out.println(rs.getInt("customer_id")+" "+rs.getString("name"));
        }
        System.out.println("_______________________________________________________________________________");
        
    }
     public void viweproduct(Model mo) throws ClassNotFoundException, SQLException
    {
        Connection con=connect();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from product");
        System.out.println("__________________________________________________________________________");
        System.out.println("product_id"+" "+"pro_name"+" "+"price"+" "+"stock");
        System.out.println("__________________________________________________________________________");
        while(rs.next())
        {
            System.out.println(rs.getInt("product_id")+"   "+rs.getString("pro_name")+"    "+rs.getLong("price")+"  "+rs.getInt("stock"));
            System.out.println("________________________________________________________________________________________________________");
        }
       
    }
   
}
