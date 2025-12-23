/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.binarySearch;

/**
 *
 * @author dhaya
 */
public class search
{
    public void dis()
    {
        int ar[]={1,2,5,8,9,3,6};
        int traget=6;
       
        
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i]==traget)
            {
                System.out.println("THE TRAGET VALUE OF INDEX IS:"+i);
            }
        }
    }
}
