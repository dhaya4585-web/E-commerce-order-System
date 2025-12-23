/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_order_system;

import java.sql.SQLException;

/**
 *
 * @author dhaya
 */
public class ECommerce_Order_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
       Controller co=new Controller();
       co.sercall();
    }
    
}
