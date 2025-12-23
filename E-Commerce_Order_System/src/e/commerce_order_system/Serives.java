/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_order_system;

import java.sql.SQLException;
import java.util.Scanner;



/**
 *
 * @author dhaya
 */
public class Serives
{
    Scanner sc=new Scanner(System.in);
    Scanner cs=new Scanner(System.in);
    DAO da=new DAO();
    Model mo=new Model();
    
    
    
    
    
    public void display() throws ClassNotFoundException, SQLException
    {
       
        
        int choice =0;
         
         
       
        do
        {
            System.out.println("1.insert the product details");
            System.out.println("2.customers datails");
            System.out.println("3.place order");
            System.out.println("4.cancel the order");
            System.out.println("5.view the order");
           
            choice=sc.nextInt();
            
            
            if(choice==1)
            {
                System.out.println("Enter the product name");
                String pname=cs.nextLine();
               
                System.out.println("Enter the product price");
                long pprice=sc.nextLong();
                System.out.println("Enter the Stock");
                int stock=sc.nextInt();
                mo.setPro_name(pname);
                mo.setPro_price(pprice);
                mo.setPro_stock(stock);
                da.insertpro(mo);
                
            }
            else if(choice==2)
            {
               System.out.println("Enter the customer name");
               String cname=cs.nextLine();
               mo.setCus_name(cname);
               da.insertcus(mo);
            }
            else if(choice==3)
            {
                System.out.println("Enter the customer id");
                int cus_id=sc.nextInt();
                System.out.println("Enter the product id");
                int pro_id=sc.nextInt();
                System.out.println("Enter the qty");
                int qty=sc.nextInt();
                mo.setCus_id(cus_id);
                mo.setPro_id(pro_id);
                mo.setOrder_qty(qty);
                da.placeorders(mo);
               
            }
            else if(choice==4)
            {
                System.out.println("Enter the order_item_id");
                int orderitem=sc.nextInt();
                mo.setOrder_item_id(orderitem);
                da.cancelorder(mo);
            }
            else if(choice==5)
            {
                System.out.println("->.view place order");
                System.out.println("->.view order item");
                System.out.println("->.view customer details");
                System.out.println("->.view product details");
                System.out.println("Enter your view option:");
                int option=sc.nextInt();
                
                if(option==1)
                {
                    da.viweorderdate(mo);
                }
                else if(option==2)
                {
                    da.viweorderitem(mo);
                }
                else if(option==3)
                {
                   da.viwecus(mo);
                }
                else if(option==4)
                {
                    da.viweproduct(mo);
                }
                
                
            }
            else
            {
                System.out.println("Thank you");
            }
            
        }while(choice!=6);
    }
    
}
