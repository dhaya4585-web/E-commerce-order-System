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
public class Controller 
{
    public void sercall() throws ClassNotFoundException, SQLException
    {
        Serives se=new Serives();
        se.display();
    }
    
}
