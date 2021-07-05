package com.supplier;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

 



 

import java.sql.ResultSet;

 

import DBConnections.DBConnect;         

 

public class SupplierDButill {
    
   
	private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    
    

 

      public static boolean insertsupplier( String companyname,String phone,String address ) {
            
            boolean isSuccsess =false;
            
            
           
            
            try {
                
                con = DBConnect.getConnection();
                stmt = con.createStatement();
                 String sql="insert into kiaora.supplier values(0, '"+companyname+"','"+phone+"','"+address+"')";
                int rs = stmt.executeUpdate(sql);
                
             
                
                
                
            
                
                if(rs>0)
                {
                    isSuccsess=true;
                }else
                {
                    isSuccsess=false;
                }
                
            }catch (Exception e){
                
                e.printStackTrace();
            }
            return isSuccsess;
        }

 

      
      public static boolean insertAddord( int Quantity,float Amount,int Credit_Period,int supplierID,String modelid ,String status ) {
            
            boolean isSuccsess =false;
            
            System.out.println("Quantity1234"+Amount+Credit_Period+supplierID+modelid+status);
            
            
            try {
                
                con = DBConnect.getConnection();
                stmt = con.createStatement();
                 String sql="insert into kiaora.sup_order values(0,'"+Quantity+"','"+Amount+"','"+Credit_Period+"','"+status+"','"+supplierID+"','"+modelid+"')";
                int rs = stmt.executeUpdate(sql);
                
            System.out.println(rs);
                
                if(rs>0)
                {
                    isSuccsess=true;
                }else
                {
                    isSuccsess=false;
                }
                
            }catch (Exception e){
                System.out.println("InsertAddorder");
                e.printStackTrace();
            }
            return isSuccsess;
        }

 

    
      public static ArrayList<Supplier> validate(String supplier){
          System.out.println("aCA");
          ArrayList<Supplier> sup = new ArrayList<>();
          
          
          
          
          System.out.println(supplier);
          
          
          try {
              
              con = DBConnect.getConnection();
              stmt = con.createStatement();
              String sql = "select * from supplier where CompanyName='"+supplier+"'";
              ResultSet rs = stmt.executeQuery(sql);
              
          
          if(rs.next()) {
              int id = rs.getInt(1);
              String company_name = rs.getString(2);
              String phone = rs.getString(3);
              String address = rs.getString(4);
              
              
              Supplier s = new Supplier( id,company_name,phone,address);
              sup.add(s);
              
              
          }
                              
          }
          catch(Exception e) {
              System.out.println("SearchDButill");    
               e.printStackTrace();
               
          
          
      }
          return sup;

      }
 

 

    
        
         public static boolean insertpayment( float Amount,String Date,int SupplierID ) {
                
                boolean isSuccsess =false;
                
                
                System.out.println("Amount1234"+Date+SupplierID);
                
                try {
                    
                    con = DBConnect.getConnection();
                    stmt = con.createStatement();
                     String sql="insert into kiaora.supplier_payment values(0,'"+Amount+"','"+Date+"','"+SupplierID+"')";
                    int rs = stmt.executeUpdate(sql);
                    
                System.out.println(rs);
                    
                    if(rs>0)
                    {
                        isSuccsess=true;
                    }else
                    {
                        isSuccsess=false;
                    }
                    
                }catch (Exception e){
                    System.out.println("insertpayment");
                    e.printStackTrace();
                }
                return isSuccsess;
            }
        
        
        
    

         
      public static boolean updatesupplier( String id,String companyname,String phone,String address ) {
    	  
    		boolean isSuccess = false;
			try {
        		
        		con = DBConnect.getConnection();
        		stmt = con.createStatement();
        		String sql = "update supplier set CompanyName='"+companyname+"',Phone='"+phone+"',Address='"+address+"'"
        				+ "where SupplierID='"+id+"'";
        		int rs = stmt.executeUpdate(sql);
        		System.out.println(rs);
        		
        		if(rs > 0) {
        			isSuccess = true;
        		}
        		else {
        			isSuccess = false;
        		}
        		
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        	return isSuccess;
        }	  
    	  

     public static boolean deletesupplier(String companyname) {
		
    	 
    	 boolean issuccess = false;
    	 try {
    		 
    		 con = DBConnect.getConnection();
     		stmt = con.createStatement();
     		String sql = "delete from supplier where companyName='"+companyname+"'";
     		int rs = stmt.executeUpdate(sql);
     		
     		
			if(rs > 0) {
    			issuccess = true;
    		}
    		else {
    			issuccess = false;
    		}
     		
     		
    	 }
    	 catch(Exception e) {
     		e.printStackTrace();
     	}
    	 
    	 
    	
		
		return issuccess;


         
     }
     
     public static boolean deleteorder(String id) {
     
    	  int convertid=Integer.parseInt(id);
    	  
    	 boolean issuccess = false;
    	 try {
    		 
    		 con = DBConnect.getConnection();
     		stmt = con.createStatement();
     		String sql = "delete from sup_order where SupplierID='"+convertid+"'";
     		int rs = stmt.executeUpdate(sql);
     		
     		
			if(rs > 0) {
    			issuccess = true;
    		}
    		else {
    			issuccess = false;
    		}
     		
     		
    	 }
    	 catch(Exception e) {
     		e.printStackTrace();
     	}
    	 
    	 
    	
		
		return issuccess;


         
     }
     
     
     

public static ArrayList<Supplier> getSupplierDetails(String companyname){
	
	

   ArrayList<Supplier> sup = new ArrayList<>();
   
   try {
	   
	   con = DBConnect.getConnection();
	   stmt = con.createStatement();
	   String sql = "select * from supplier where companyName='"+companyname+"'";
		rs = stmt.executeQuery(sql);   
		System.out.println(rs);
		
		while(rs.next()){
			   
			int id = rs.getInt(1);
			String DBcompanyname = rs.getString(2);
			String phone = rs.getString(3);
			String address = rs.getString(4);
			
			Supplier s = new Supplier(id,DBcompanyname,phone,address);
			sup.add(s);
   }
   }
   catch(Exception e) {
		e.printStackTrace();
	}
   
   return sup;
	
	
   
}
}


	
	
