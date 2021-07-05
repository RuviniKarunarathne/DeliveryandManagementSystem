package com.SPpersonalCustomer;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBConnections.DBConnect;

public class SPpersonalDeliveryRegisterUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	

	public static boolean insertPersonalCustomer(String name, String NIC, String addressLine, String street, String city, int phoneNo, int routeId) {
		
		boolean isSuccess = false;
		
		
	   try {
		   
		   //DB connection
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
						
			String sql = "insert into kiaora.customer(cusID, name, nic, AddressLine, street, city, phone, Route_ID) values(0, '"+name+"' ,'"+NIC+"', '"+addressLine+"', '"+street+"', '"+city+"',"
					+ " '"+phoneNo+"', '"+routeId+"' )";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) { 
				isSuccess = true;
			}else {
				isSuccess = false; 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("error");
		}
		
		return isSuccess;
		
	}
	
	public static boolean insertPersonalOrder(int cusID, String itemCode, double unitPrice, double initpay , String status, String pDay, String dDay) {
		
		boolean isSuccess = false;
		
		
		   try {
			   
			   //DB connection
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				
							
				String sql = "insert into kiaora.order values(0, '"+dDay+"' , null , '"+initpay+"' , 3,  null , '"+unitPrice+"', '"+status+"',  null , '"+pDay+"', null,  '"+cusID+"', null,  '"+itemCode+"')";
				
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) { 
					isSuccess = true;
				}else {
					isSuccess = false; 
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.print("error");
			}
			
			return isSuccess;
			
		}
	
	
		public static List<SPdeliveryCustomer> validate (String nic){
			
			ArrayList<SPdeliveryCustomer> cus = new ArrayList<>();
			
				try {  
				   //DB connection
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					
					
						
					String sql = "select cusID, name, nic, AddressLine, street, city, phone from kiaora.customer where nic  = '"+nic+"'" ;
					
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						int id= rs.getInt(1);  
						String name = rs.getString(2);
						String nid = rs.getString(3);
						String address = rs.getString(4);
						String street = rs.getString(5);
						String city = rs.getString(6);
						int phone = rs.getInt(7);
						
						SPdeliveryCustomer dc =  new SPdeliveryCustomer(id, name, nid, address, street, city, phone);
						cus.add(dc);
						
					} 
						
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.print("error");
				}
				
			return cus;
		}
		
		
		public static boolean updateCustomer(int id, String name, String nic, String address, String street, String city, int phone) {
			
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "update kiaora.customer set name = '"+name+"', nic = '"+nic+"' , AddressLine = '"+address+"', street = '"+street+"', city ='"+city+"', phone = '"+phone+"'" + 
				 "where cusID = '"+id+"'";
				
				
				int rs = stmt.executeUpdate(sql);
				
				System.out.print(id);
				
				if(rs > 0) {
					isSuccess = true;
				}else {
					isSuccess = false;
				}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
		}
		
		public static boolean deleteCustomer(int customerId) {
			
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "delete from kiaora.customer where cusID = '"+customerId+"'";
				int rs = stmt.executeUpdate(sql);
				
				System.out.print(customerId);
				
				if(rs > 0) {
					isSuccess = true;
				}else {
					isSuccess = false;
				}
				
				
			}catch(Exception e){
				e.getStackTrace();
			}
			
			return isSuccess;
		}
		
		
		public static List<PersonalOrder> validateOrder(int orderId){
			
			ArrayList<PersonalOrder> ord = new ArrayList<>();
			
				try {  
				   //DB connection
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					
					System.out.print(orderId);
					
					
						
					String sql = "select orderID, dueDate, amountPaid, creditPeriod, unitPrice, status, orderDate, cusID from kiaora.order where orderID = '"+orderId+"'";
					
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						int oid= rs.getInt(1);  
						String duedate = rs.getString(2);
						double amountPaid = rs.getDouble(3);
						int period = rs.getInt(4);
						double UnitPrice = rs.getDouble(5);
						String status = rs.getString(6);
						String orderDate = rs.getString(7);
						int cusId = rs.getInt(8);
						
						
						
						PersonalOrder dc =  new PersonalOrder(oid, duedate, amountPaid, period, UnitPrice, status, orderDate, cusId);
						ord.add(dc);
						
					} 
						
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.print("error");
				}
				
			return ord;
		
		}
		
		public static boolean updateOrder(String oid, String due, String amount, String credit, String unit, String status, String odate) {
			
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "update kiaora.order set orderId = '"+oid+"', dueDate = '"+due+"' , amountPaid = '"+amount+"', creditPeriod = '"+credit+"', unitPrice ='"+unit+"', status = '"+status+"', "
						+ " orderDate = '"+odate+"'" + "where orderID = '"+oid+"'";
				
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					isSuccess = true;
				}else {
					isSuccess = false;
				}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
		}
		
		
		public static boolean deleteOrder(int orderId) {
			
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "delete from kiaora.order where orderID = '"+orderId+"'";
				int rs = stmt.executeUpdate(sql);
				
				
				
				if(rs > 0) {
					isSuccess = true;
				}else {
					isSuccess = false;
				}
				
				
			}catch(Exception e){
				e.getStackTrace();
			}
			
			return isSuccess;
		}
		

		public static List<SPdeliveryCustomer> displayID (String nic){
			
			ArrayList<SPdeliveryCustomer> cus = new ArrayList<>();
			
				try {  
				   //DB connection
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					
					
						
					String sql = "select cusID, name from kiaora.customer where nic = '"+nic+"'";
					
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						int id= rs.getInt(1);
						String name = rs.getString(2);
						
						SPdeliveryCustomer dc =  new SPdeliveryCustomer(id, name);
						cus.add(dc);
						
					} 
						
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.print("error");
				}
				
			return cus;
		}
		
		
		public static List<PersonalOrder> SearchCustomerOrder(){

			 

		    ArrayList<PersonalOrder> proCusOrder = new ArrayList<>();
		    try {
		        con= DBConnect.getConnection();
		        stmt = con.createStatement();
		        String sql ="SELECT * FROM kiaora.order ORDER BY orderID DESC LIMIT 1";
		        rs = stmt.executeQuery(sql);
		        
		        if (rs.next()) {
		           
		             int orderID = rs.getInt(1);
		             String dueDate = rs.getString(2);
		             double discount = rs.getInt(3);
		             double amountPaid = rs.getDouble(4);
		             int creditPeriod = rs.getInt(5);
		             double totPayment = rs.getDouble(6);
		             double unitPrice = rs.getDouble(7);
		             String paymentStatus = rs.getString(8);
		             int quantity = rs.getInt(9);
		             String oDate = rs.getString(10);
		             String updatedDate = rs.getString(11);
		             int cusID = rs.getInt(12);
		             int shopID = rs.getInt(13);
		             String modelID = rs.getString(14);
		             
		            
		             PersonalOrder customerorder = new PersonalOrder(orderID, dueDate, discount, amountPaid, totPayment, unitPrice, quantity, oDate, updatedDate,paymentStatus, cusID, modelID);
		            proCusOrder.add(customerorder);
		            
		            System.out.println(orderID);
		             
		        } 

		 

		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.println("Error123");
		        
		    }
		    
		    return proCusOrder;
		 }
		
		
		public static int getRouteID(String street) {
			int routeid = 0;
			try {
				
				con= DBConnect.getConnection();
		        stmt = con.createStatement();
		        String sql ="SELECT RouteID from route where Route_Name = '"+street+"'";
		        rs = stmt.executeQuery(sql);
		        
		        while(rs.next()) {
		        	routeid =rs.getInt(1);
		        }
				
				
			}catch(Exception e) {
				e.getStackTrace();
			}
			
			return routeid;
		}
		
		

		
	 
		
}
		
	

	
	
	
	
	
	

	


