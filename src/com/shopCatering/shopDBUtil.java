package com.shopCatering;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import java.sql.Statement;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import DBConnections.DBConnect;

public class shopDBUtil {
	
	//Instance varible
		private static java.sql.Connection conn = null;
		
		private static boolean RSuccess;//boolean variable to return if the result is suceess or not
		private static Statement st = null;
		private static ResultSet rs = null;
	
		
		
		
		
	//get last digit inserted to the shop table's shopID field
	public static String getlastPIDno(){
					
			
					
		//varible to store shopID
		String shopID = null;
					
		try {
						
			//create database connection
			conn = DBConnect.getConnection();
						
			String query ="select shopID from shop order by shopID desc limit 1";
			
			//create statement
			java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
			ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
						
			//get pid
			while (rs.next())
				shopID = rs.getString(1);
			}
						
			catch (Exception e) {
				e.printStackTrace();
							
			}
						
			System.out.println(shopID);

			return shopID;
						
						
	}	
	
	//check if the entered email is alreadi in the database
	public static boolean  validateEmail(String email){	
			//Use try catch block to identify errors 
				try {
				
					//create database connection
					conn = DBConnect.getConnection();
					
					//create statement
					java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
					
					//create SQL query to store details
					String query ="SELECT * from shop where email = '"+ email+"'";

							
					 rs = ((java.sql.Statement) st).executeQuery(query);
					
					
							
							if(rs.next()) {
								RSuccess = true;
							
							}
							else
								RSuccess=false;
					}
					catch (Exception e) {
						e.printStackTrace();
					
					}
					System.out.println(RSuccess);
				
					return RSuccess;
		}
	
		//check if the entered email is alreadi in the database
		public static boolean  validatePhone(int phone){	
				//Use try catch block to identify errors 
					try {
					
						//create database connection
						conn = DBConnect.getConnection();
						
						//create statement
						java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
						
						//create SQL query to store details
						String query ="SELECT * from shop where phone = '"+ phone+"'";

								
						 rs = ((java.sql.Statement) st).executeQuery(query);
						
						
								
								if(rs.next()) {
									RSuccess = true;
								
								}
								else
									RSuccess=false;
						}
						catch (Exception e) {
							e.printStackTrace();
						
						}
						System.out.println(RSuccess);
					
						return RSuccess;
			}
		
	//insert a shop 	
	public static boolean insertShop(String shopid,String Shopname,String Ownername,String addressLine1,String addressStreet,String addressCity,String email,Date registeredDate,int phone,int routeid){
		
		boolean RSuccess = false;
		
		
		
		//Use try catch block to identify errors 
			try {
			
				//create db connection
				conn = DBConnect.getConnection();
				
				String query ="Insert into shop values('"+shopid+"','"+Shopname+"','"+Ownername+"','"+addressLine1+"','"+ addressCity+"','"+addressStreet+"','"+ email+"', '"+ phone+"','"+ registeredDate+"', '"+ routeid+"')";
				
				
				java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
						
						int rs = st.executeUpdate(query);
						
						if(rs > 0) {
							RSuccess = true;
						
						}
						else
							RSuccess=false;
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
			System.out.println(RSuccess);
			
		return RSuccess;
	}
	
	
	
	//check whether the shop is exist in the system
	public static boolean checkShopavailability(String shopid){
			
		boolean RSuccess = false;
		
		
		
		//Use try catch block to identify errors 
			try {
			
				//create database connection
				conn = DBConnect.getConnection();
				
				//create statement
				java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
				
				//create SQL query to store details
				String query ="SELECT * from shop where shopID = '"+ shopid+"'";

						
				 rs = ((java.sql.Statement) st).executeQuery(query);
				
				
						
						if(rs.next()) {
							RSuccess = true;
						
						}
						else
							RSuccess=false;
				}
				catch (Exception e) {
					e.printStackTrace();
				
				}
				System.out.println(RSuccess);
			
				return RSuccess;
		}
	
	
	
	//get shop details
	public static ArrayList<ShopClass> getShopdetails(String shopid){
			
			
			
			//store details of the user in a ArrayList			
			ArrayList<ShopClass> Shop2 = new ArrayList<>();
			
			//Use try catch block to identify errors 
			try {
				
				//create database connection
				conn = DBConnect.getConnection();
				
				//create statement
				java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
				
				//create SQL query to store details
				//String query ="SELECT * from shop where name = '"+ Shopname +"'";
				String query ="SELECT * from shop where shopID = '"+ shopid +"'";	
				//store result set in the rs
				ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
				
					//retrieve data if the user is valid  
					while(rs.next()){
						
						//store data from database
						
						String id = rs.getString(1);
						String shopname= rs.getString(2);
						String ownername= rs.getString(3);
						String addressLine1= rs.getString(4);
						String addressCity= rs.getString(5);
						String addressStreet= rs.getString(6);
						String email= rs.getString(7);
						int phone= rs.getInt(8);;
						String registeredDate= rs.getString(9);
						int routeid= rs.getInt(10);
						
						
						//create object from user class
						ShopClass u2 = new ShopClass(id,shopname,ownername,addressLine1,addressStreet,addressCity,email,phone,registeredDate,routeid);
						
						//add details of user2 to arraylist
						Shop2.add(u2);
					
				
				
			}
		
			}
			
				catch (Exception e) {
					e.printStackTrace();
					
				}
		
			
			//return user details
			return Shop2;
			
		}
	
	
	
	
	//delete a shop from the system
	public static boolean deleteShop(String shopID) {
		
		try {
					
					//create db connection
					conn = DBConnect.getConnection();
					
					
					//delete data 
					String query ="DELETE from shop where shopID ='"+ shopID+"'";
				
					//create statement
					java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
					
					int result1 = ((java.sql.Statement) st).executeUpdate(query);
					
					//if the process is success
					if(result1 > 0){
						
						RSuccess = true;
						
						
					}
					//if the process is unsuccessful
					else
						RSuccess = false;
					
			}
					
			catch (Exception e) {
				e.printStackTrace();
						
			}
					
				
				
		return RSuccess;
	}

	
	//update shop details
	public static boolean updateShop(String id1, String shopname1, String ownername1, String email1,String addressLine11, String addressStreet1, String addressCity1, String email12, String phone1,String registeredDate1,int routeid) {

			
			int convertedPhone = Integer.parseInt(phone1);
			
			
			ArrayList<ShopClass> user2 = new ArrayList<>();
			
			try {
				
				conn = DBConnect.getConnection();
				
				String query ="Update shop set name='"+shopname1+"',owner='"+ownername1+"',addressLine1='"+ addressLine11+"',city='"+addressCity1 +"',street='"+ addressStreet1+"',email='"+ email12+"', phone='"+convertedPhone+"', Route_ID='"+routeid+"'"
						+"where shopID='"+id1+"'";
					
					//create statement
				java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
				
					
					int rs = ((java.sql.Statement) st).executeUpdate(query);
				
					
					if(rs>0){
						
						RSuccess = true;
						
						
					}
					else{
						RSuccess = false;
					}
					
				}
			
				catch (Exception e) {
					e.printStackTrace();
					
				}
		
			
			
			return RSuccess;
			
		}
	
	
	//get street names
	 public static ArrayList<StreetClass> streetlist(){
		 ArrayList<StreetClass> listStreets = new ArrayList<>();
	         
		 try {
				
				conn = DBConnect.getConnection();
	            
	            String query ="select * from route order by Route_Name";
	            
	            java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
				ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
	            
	             
	            while (rs.next()) {
	                int id = rs.getInt(1);
	                String name = rs.getString(2);
	                
	                StreetClass streets = new StreetClass(id, name);
	                     
	                listStreets.add(streets);
	            }        
	            
	           
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        }      
	         
	        return listStreets;
	    }


	//get route ID using street 
	public static int getRouteID(String addressStreet) {

		//varible to store shopID
				int routeID =0;
							
				try {
								
					//create database connection
					conn = DBConnect.getConnection();
								
					String query ="select RouteID from route where Route_Name = '"+ addressStreet +"'";
					
					//create statement
					java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
					ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
								
					//get pid
					while (rs.next())
						routeID = rs.getInt(1);
					}
								
					catch (Exception e) {
						e.printStackTrace();
									
					}
								
					System.out.println(routeID);

					return routeID;
								
	}


	//check the entered model is exist in the system
	public static boolean checkModelAvailability(String modelID) {
		
		boolean RSuccess = false;
		
		
			//Use try catch block to identify errors 
			try {
			
				//create database connection
				conn = DBConnect.getConnection();
				
				//create statement
				java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
				
				//create SQL query to store details
				String query ="SELECT * from model where modelID = '"+ modelID+"'";

						
				ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
				
				
						
						if(rs.next()) {
							RSuccess = true;
						
						}
						else
							RSuccess=false;
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
			System.out.println(RSuccess);
			
		return RSuccess;
	}


	//get details of enetred model
	public static ArrayList<ModelClass> getModeldetails(String modelID) {

		//store details of the user in a ArrayList			
		ArrayList<ModelClass> model = new ArrayList<>();
		
		//Use try catch block to identify errors 
		try {
			
			//create database connection
			conn = DBConnect.getConnection();
			
			//create statement
			java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
			
			//create SQL query to store details
			//String query ="SELECT * from shop where name = '"+ Shopname +"'";
			String query ="SELECT * from model where modelID = '"+ modelID +"'";	
			//store result set in the rs
			ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
			
				//retrieve data if the user is valid  
				while(rs.next()){
					
					//store data from database
					
					String mid = rs.getString(1);
					String brand= rs.getString(2);
					String category= rs.getString(3);
					double unitPrice= rs.getDouble(4);
					String warrenty= rs.getString(5);
					int quantity= rs.getInt(6);
					int minimumLimit= rs.getInt(7);
					
					
					//create object from user class
					ModelClass md = new ModelClass(mid,brand,category,unitPrice,warrenty,quantity,minimumLimit);
					
					//add details of user2 to arraylist
					model.add(md);
			
		}
	
		}
		
			catch (Exception e) {
				e.printStackTrace();
				
			}
	
		
		//return user details
		return model;
	}


	//add new order
	public static boolean insertNewOrder(String modelID, LocalDate dueDate, double amountPaid, int creditPeriod,
			double totPrice, String unitPrice, String status, String quantity, String placed_date, String shopID) {

		
		//Use try catch block to identify errors 
			try {
			
				//create db connection
				conn = DBConnect.getConnection();
				
				String query ="Insert into kiaora.order(orderID, dueDate, amountPaid,creditPeriod, totPayment, unitPrice,status,quantity,orderDate,updatedDate,shopID,modelID) values('"+0+"','"+dueDate+"','"+amountPaid+"','"+creditPeriod+"','"+ totPrice+"','"+unitPrice+"','"+ status+"', '"+ quantity+"','"+ placed_date+"', '"+ placed_date+"', '"+ shopID+"', '"+ modelID+"')";
				
				
				java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
						
						int rs = st.executeUpdate(query);
						
						if(rs > 0) {
							RSuccess = true;
						
						}
						else
							RSuccess=false;
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
			System.out.println(RSuccess);
			
		return RSuccess;
		
	}

	//get Order details placed by specific shop
	public static ArrayList<OrderClass> getOrderdetailsOfShop(String shopID) {

		//store details of the user's placed orders in a ArrayList			
		ArrayList<OrderClass> orders = new ArrayList<>();
		
		//Use try catch block to identify errors 
		try {
			
			//create database connection
			conn = DBConnect.getConnection();
			
			//create statement
			java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
			
			//create SQL query to store details
				
			
			String query ="SELECT * from kiaora.order where shopID = '"+ shopID +"'";		
			//store result set in the rs
			ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
			
				//retrieve data if the user is valid  
				while(rs.next()){
					
					//store data from database
					
					int orderID = rs.getInt(1);
					String dueDate= rs.getString(2);
					double amountPaid= rs.getDouble(4);
					int creditPeriod= rs.getInt(5);
					double totPayment= rs.getDouble(6);
					double unitPrice= rs.getDouble(7);
					String status= rs.getString(8);
					int quantity= rs.getInt(9);
					String orderDate= rs.getString(10);
					String updatedDate= rs.getString(11);				
					String shopiD= rs.getString(13);
					System.out.println(orderID);
					String modelID= rs.getString(14);
					
					double remainingCost = totPayment - amountPaid;
					
					//create object from user class
					OrderClass or1 = new OrderClass(orderID,dueDate,amountPaid,creditPeriod,totPayment,remainingCost,unitPrice,status,quantity,orderDate,updatedDate,shopID,modelID);
					
					//add details of user2 to arraylist
					orders.add(or1);
			
				}
	
		}
		
			catch (Exception e) {
				e.printStackTrace();
				
			}
	
		
		//return user details
		return orders;
		
	}


	//get details of an order
	public static ArrayList<OrderClass> getOrderDetailsbyOrderID(String orderID) {
		
		int ConvertedorderID = Integer.parseInt(orderID);
		
		//store details of the user's placed orders in a ArrayList			
				ArrayList<OrderClass> orders = new ArrayList<>();
				
				//Use try catch block to identify errors 
				try {
					
					//create database connection
					conn = DBConnect.getConnection();
					
					//create statement
					java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
					
					//create SQL query to store details
						
					
					String query ="SELECT * from kiaora.order where orderID = '"+ ConvertedorderID +"'";		
					//store result set in the rs
					ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
					System.out.println("Hyyy");
						//retrieve data if the user is valid  
						while(rs.next()){
							
							//store data from database
							
							int orderID2 = rs.getInt(1);
							String dueDate= rs.getString(2);
							double amountPaid= rs.getDouble(4);
							int creditPeriod= rs.getInt(5);
							double totPayment= rs.getDouble(6);
							double unitPrice= rs.getDouble(7);
							String status= rs.getString(8);
							int quantity= rs.getInt(9);
							String orderDate= rs.getString(10);
							String updatedDate= rs.getString(11);				
							String shopiD= rs.getString(13);
							String modelID= rs.getString(14);
							
							double remainingCost = totPayment - amountPaid;
							
							//create object from user class
							OrderClass or1 = new OrderClass(orderID2,dueDate,amountPaid,creditPeriod,totPayment,remainingCost,unitPrice,status,quantity,orderDate,updatedDate,shopiD,modelID);
							
							//add details of user2 to arraylist
							orders.add(or1);
					
				}
			
				}
				
					catch (Exception e) {
						e.printStackTrace();
						
					}
			
				
				//return user details
				return orders;
	}


	//update an order
	public static boolean updateSelectedOrder(String orderID, double amountPaid,int creditPeriod ,String status,
			LocalDate updatedDate) {
	
		
		try {
			
			conn = DBConnect.getConnection();
			
			String query ="Update kiaora.order set amountPaid= amountPaid +'"+amountPaid+"',creditPeriod='"+ creditPeriod+"',status='"+status+"',updatedDate='"+updatedDate+"'"
					+"where orderID='"+orderID+"'";
				
				//create statement
			java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
			
				
				int rs = ((java.sql.Statement) st).executeUpdate(query);
			
				
				if(rs>0){
					
					RSuccess = true;
					
					
				}
				else{
					RSuccess = false;
				}
				
			}
		
			catch (Exception e) {
				e.printStackTrace();
				
			}
		
		return RSuccess;
	}


	//check whether the entered shop has unpaid orders
	public static boolean checkNotPaidOrdersAvailbility(String shopID) {
		
		boolean success = false;
		
		String paid = "PartialPaid";
		
		try {
			//create database connection
			conn = DBConnect.getConnection();
			
			//create statement
			java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
			
			//create SQL query to get data
			String query ="Select* from kiaora.order where shopID= '"+shopID+"' AND status='"+paid+"'";

					
			ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
			
			
					
					if(rs.next()) {
						RSuccess = true;
					
					}
					else
						RSuccess=false;
					}
					catch (Exception e) {
						e.printStackTrace();
						
					}
					System.out.println(RSuccess);
					
			return RSuccess;
	
		}
		


	//delete completed orders of given shop id
	public static boolean deleteOrders(String shopID) {
		
	String Paid = "Paid";
	
	try {
				
				//create db connection
				conn = DBConnect.getConnection();
				
				
				//delete data 
				String query ="DELETE from kiaora.order where shopID= '"+shopID+"' AND status='"+Paid+"'";
			
				//create statement
				java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
				
				int result1 = ((java.sql.Statement) st).executeUpdate(query);
				
				//if the process is success
				if(result1 >= 0){
					
					RSuccess = true;
					
					
				}
				//if the process is unsuccessful
				else
					RSuccess = false;
				
		}
				
		catch (Exception e) {
			e.printStackTrace();
					
		}
							
			
			return RSuccess;
	}

	//reduce ordered quantity from the stock 
	public static boolean deductStock(String modelID, String quantity) {
		int convertedquantity = Integer.parseInt(quantity);
		
		
			
			try {
				
				conn = DBConnect.getConnection();
				
				String query ="Update kiaora.model set quantity=quantity -'"+convertedquantity+"'"
						+"where modelID='"+modelID+"'";
					
				//create statement
				java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
			
				
				int rs = ((java.sql.Statement) st).executeUpdate(query);
			
				
				if(rs>0){
					
					RSuccess = true;
					
					
				}
				else{
					RSuccess = false;
				}
		
				
			}
		
			catch (Exception e) {
				e.printStackTrace();
				
			}
		
			return RSuccess;
	}
	
	
	
	//get details of due order
		public static ArrayList<OrderClass> getDueOrderDetails(int year,int month) {
			
			String Paid = "PartialPaid";
			
			//store details of the user's placed orders in a ArrayList			
					ArrayList<OrderClass> orders = new ArrayList<>();
					
					//Use try catch block to identify errors 
					try {
						
						//create database connection
						conn = DBConnect.getConnection();
						
						//create statement
						java.sql.Statement st =  ((java.sql.Connection) conn).createStatement();
						
						//create SQL query to store details
						
						String query ="SELECT * from kiaora.order where EXTRACT(MONTH FROM dueDate) = '"+ month +"' AND EXTRACT(YEAR FROM dueDate)='"+year+"' AND status='"+Paid+"'";		
						//store result set in the rs
						ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
						System.out.println("Hyyy");
							//retrieve data if the user is valid  
							while(rs.next()){
								
								//store data from database
								
								int orderID2 = rs.getInt(1);
								String dueDate= rs.getString(2);
								double amountPaid= rs.getDouble(4);
								int creditPeriod= rs.getInt(5);
								double totPayment= rs.getDouble(6);
								double unitPrice= rs.getDouble(7);
								String status= rs.getString(8);
								int quantity= rs.getInt(9);
								String orderDate= rs.getString(10);
								String updatedDate= rs.getString(11);				
								String shopiD= rs.getString(13);
								String modelID= rs.getString(14);
								
								double remainingCost = totPayment - amountPaid;
								
								//create object from user class
								OrderClass or1 = new OrderClass(orderID2,dueDate,amountPaid,creditPeriod,totPayment,remainingCost,unitPrice,status,quantity,orderDate,updatedDate,shopiD,modelID);
								
								//add details of user2 to arraylist
								orders.add(or1);
						
					}
				
					}
					
						catch (Exception e) {
							e.printStackTrace();
							
						}
				
					
					//return user details
					return orders;
		}
	
	
	
}	
		