/*******************************************************************************
 * Copyright 2009-2015 Amazon Services. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 *
 * You may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License.
 *******************************************************************************
 * Marketplace Web Service Orders
 * API Version: 2013-09-01
 * Library Version: 2015-09-24
 * Generated: Fri Sep 25 20:06:20 GMT 2015
 */
package com.amazonservices.mws.orders._2013_09_01.samples;

import java.util.*;

import javax.xml.bind.Element;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonservices.mws.client.*;
import com.amazonservices.mws.orders._2013_09_01.*;
import com.amazonservices.mws.orders._2013_09_01.model.*;
import com.google.common.collect.Lists;
import com.sun.xml.internal.txw2.Document;


/** Sample call for GetOrder. */
public class GetOrderSample {

    /**
     * Call the service, log response and exceptions.
     *
     * @param client
     * @param request
     *
     * @return The response.
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     * @throws TransformerException 
     */
	
	/*//global counter for generating multiple order files
	static int count  = 0;*/
	
    public static GetOrderResponse invokeGetOrder(
            MarketplaceWebServiceOrders client, 
            GetOrderRequest request) throws GeneralSecurityException, Exception {
        try {
            // Call the service.
            GetOrderResponse response = client.getOrder(request);
            ResponseHeaderMetadata rhmd = response.getResponseHeaderMetadata();
            // We recommend logging every the request id and timestamp of every call.
            System.out.println("Response:");
            
            System.out.println("RequestId: "+rhmd.getRequestId());
            
            System.out.println("Timestamp: "+rhmd.getTimestamp());
            
            String responseXml = response.toXML();
      
            
            
            System.out.println(responseXml);
            
            
            
            
            //Dom parser to par XML
            

            
            try {	
            	
            	//Initialize new Obj to add retrieved data to DB each time it is being retreived 
            	Amazonorders orders = new Amazonorders(responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, null, null, null, responseXml, responseXml, responseXml, responseXml, responseXml, null, responseXml, responseXml, responseXml);
            	
               /*
                //Does not work, input is a string, only takes afile 
                  File inputFile = new File(responseXml);*/
            	
            	//must use input as inputstream
            	
            	InputStream stream = new ByteArrayInputStream(responseXml.getBytes(StandardCharsets.UTF_8));
                
                DocumentBuilderFactory dbFactory 
                
                   = DocumentBuilderFactory.newInstance();
                
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                
                org.w3c.dom.Document doc = dBuilder.parse(stream);
                
                doc.getDocumentElement().normalize();
                
                System.out.println("Root element :" 
                   + doc.getDocumentElement().getNodeName());
                
                NodeList nList = doc.getElementsByTagName("Order");
                
                System.out.println("----------------------------");
                
                for (int temp = 0; temp < nList.getLength(); temp++) {
                	
                   org.w3c.dom.Node nNode = nList.item(temp);
                   
                   System.out.println("\nCurrent Element :" 
                		   
                      + nNode.getNodeName());
                   
                   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                	   
                	   /*System.out.println("im Here");*/
                	   
                    /* 
                     //**Critical Error, Node can not be cast to type element
                      Node eElement = (Element) nNode;*/
                      
                	   org.w3c.dom.Node eElement =  nNode;
                     
                      
                      /*System.out.println("Im inside of an order");*/
                      
                      System.out.println("AmazonOrderId : " 
                    		  
                         + ((org.w3c.dom.Element) eElement)
                         
                         .getElementsByTagName("AmazonOrderId")
                         .item(0)
                         .getTextContent());
                      
                      
                      
                 
                      //set order id to orders obj
                      orders.setAmazonorderid(
                    		  ((org.w3c.dom.Element) eElement) 
                         .getElementsByTagName("AmazonOrderId")
                         .item(0)
                         .getTextContent());
                      
                      
                    
                    //set Name to orders 
                 try{     
                    
                     String name = (((org.w3c.dom.Element) eElement) 
                     .getElementsByTagName("Name")
                     .item(0)
                     .getTextContent());
                     
                     orders.setCustomername(
                       		 name);
                     
                 }
                 catch(NullPointerException e){
                     
               
                    
                    	 
                    	 System.out.println("Canceled Order");
                    	 
                    	 orders.setCustomername(
                           		 "");
                        	 
                    	 
                   
                     
                     
                 };
                 
                  
                      
            
                   //set address    
                  try{
                 
                      String Addr = (((org.w3c.dom.Element) eElement) 
                              .getElementsByTagName("AddressLine1")
                              .item(0)
                              .getTextContent());
                      
                      
                      orders.setStreetname(
                     		 Addr);
                      
                      
                  }
                     
                     catch (NullPointerException e)
                      {
                     	 
                     	 orders.setStreetname(
                            		 "" );
                         	 
                     	 
                      }
                   
                      
                    
                    
                    
                      //set city, might be a state 
                      
                      try{
                    	  
                      String city = (((org.w3c.dom.Element) eElement) 
                              .getElementsByTagName("City")
                              .item(0)
                              .getTextContent());
                      
                      
                	  orders.setCity(
                    		  city );
                	  
                      
                      
                      }
                     catch(NullPointerException e)
                      {
                    	
                                  
                    
                    	  
                    	  orders.setCity(
                        		"" );
                    	  
                    	  
                      }
                      
                    
                      //set postal code        
                    try{
                    	
                    	
                    
                      String zip = (((org.w3c.dom.Element) eElement) 
                              .getElementsByTagName("PostalCode")
                              .item(0)
                              .getTextContent());
                      
                    
                          
                    	  
                    	  orders.setZip(zip);
                    	  
                    	  
                      }
                     catch(NullPointerException e)
                      {
                    	  
                    	  
                    	  orders.setZip("");
                      }
                      
                    
              //set Country 
                    try{
                      String country = (((org.w3c.dom.Element) eElement) 
                              .getElementsByTagName("CountryCode")
                              .item(0)
                              .getTextContent());
                            
                  
                    	  
                    	  orders.setCountry(country);
       	  
                      }
                      
                     catch (NullPointerException e)
                      {
                    	  
                    	  orders.setCountry("");
                    	  
                    	  
                      }
                      
               
                 //set fulfillment channel
                    
                    
                    try{
                    	
                        String fc = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("FulfillmentChannel")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setFulfillmentchannel(fc);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setFulfillmentchannel("");
                      	  
                      	  
                        }
                        
                    
                 //set order Status
                    
                      
                    try{
                    	
                        String os = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("OrderStatus")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setOrderstatus(os);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setOrderstatus("");
                      	  
                      	  
                        }
                        
               //set purchase date, date as in string
                    
                    
                    try{
                    	
                        String pd = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("PurchaseDate")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setPurchasedate(pd);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setPurchasedate("");
                      	  
                      	  
                        }
                    
                    
                    //set last update date, date as in string 
                    
                    try{
                    	
                        String ud = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("LastUpdateDate")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setLastupdatedate(ud);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setLastupdatedate("");
                      	  
                      	  
                        }
                    
                    
                    //set Order Type
                    
                    try{
                    	
                        String ot = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("OrderType")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setOrderType(ot);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setOrderType("");
                      	  
                      	  
                        }
                    
                    
                    
           //set Shipment Service Level
                    
                    try{
                    	
                        String ss = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("ShipServiceLevel")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setShipservicelevel(ss);;
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setShipservicelevel("");
                      	  
                      	  
                        }
                    
                    
                //set Currency Code
                    try{
                    	
                        String cc = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("CurrencyCode")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setCurrency(cc);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setCurrency("");
                      	  
                      	  
                        }
                    
                   
                 //set Amount
                    try{
                    	
                        String a = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("Amount")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setAmount(a);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setAmount("");
                      	  
                      	  
                        }
                    
                    
                  //set item shipped
                    try{
                    	
                        String is = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("NumberOfItemsShipped")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setQtyshipped(is);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setQtyshipped("");
                      	  
                      	  
                        }
                    
                    
                    //set item unshipped
                    try{
                    	
                        String iu = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("NumberOfItemsUnshipped")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setQtyunshipped(iu);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setQtyunshipped("");
                      	  
                      	  
                        }
                    
                    
                    
                    //set BusinessOrder
                    try{
                    	
                        String ib = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("IsBusinessOrder")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setBusinessorder(ib);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setBusinessorder("");
                      	  
                      	  
                        }
                    
                    
                    //set Prime
                    try{
                    	
                        String ip = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("IsPrime")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setPrime(ip);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setPrime("");
                      	  
                      	  
                        }
                    
                    
                    
                    
                    //set Preium
                    
                    try{
                    	
                        String ipo = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("IsPremiumOrder")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setPremium(ipo);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setPremium("");
                      	  
                      	  
                        }
                    
                    //setPaymentMethod
                    try{
                    	
                        String pm = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("PaymentMethod")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setPaymentmethod(pm);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setPaymentmethod("");
                      	  
                      	  
                        }
                    
                    
                    //setBuyerEmail
                    try{
                    	
                        String be = (((org.w3c.dom.Element) eElement) 
                                .getElementsByTagName("BuyerEmail")
                                .item(0)
                                .getTextContent());
                              
                    
                      	  
                      	  orders.setEmail(be);
         	  
                        }
                        
                       catch (NullPointerException e)
                        {
                      	  
                      	  orders.setEmail("");
                      	  
                      	  
                        }
                    
                      
                      
                    //write to db
                      
                      String url = "00";
                      String username = "00";
                      String password = "00!";
                      
                      System.out.println("Loading driver...");
                      try {
                          Class.forName("com.mysql.jdbc.Driver");
                          System.out.println("Driver loaded!");
                      } catch (ClassNotFoundException e) {
                          throw new IllegalStateException("Cannot find the driver in the classpath!", e);
                      }
                      
                      
                      
                      System.out.println("Connecting database...");
                      
                      try (Connection connection = DriverManager.getConnection(url, username, password)) {
                      	
                      	
                          System.out.println("Database connected!");
                          
                          
                          
                          
            
                         
                         
                          	
                          
                          // Update DB
                          String query = "UPDATE AmazonOrders SET CustomerName = ?, Street = ?, City = ?, Zip = ?, Country = ?, Fulfillment = ?, "
                          		+ "OrderStatus = ?, PurchaseDate = ?, LastUpdateDate = ?, OrderType = ?, ShipmentServiceLevel = ?, "
                          		+ "Currency = ?, Amount = ?, ItemShipped = ?,"
                          		+ "ItemUnshipped = ?,IsBussinessOrder = ?, IsPrime = ?, "
                          		+ "IsPreiumOrder = ?,PaymentMethod = ?, Email = ?"
                          		+ " WHERE OrderNumbers = ?";
                            
                          
                          
                          //create the mysql insert preparedstatement
                          
                          PreparedStatement preparedStmt = (PreparedStatement) connection.prepareStatement(query);
                         
                          //insert values to be updated to statement 
                          
                          preparedStmt.setString(1,orders.getCustomername());
                          
                          preparedStmt.setString(2,orders.getStreetname());
                          
                          preparedStmt.setString(3,orders.getCity());
                          
                          preparedStmt.setString(4,orders.getZip());
                          
                          preparedStmt.setString(5,orders.getCountry());
                        
                          preparedStmt.setString(6,orders.getFulfillmentchannel());
                          
                          preparedStmt.setString(7,orders.getOrderstatus());
                          
                          preparedStmt.setString(8,orders.getPurchasedate());
                          
                          preparedStmt.setString(9,orders.getLastupdatedate());
                          
                          preparedStmt.setString(10,orders.getOrderType());
                          
                          preparedStmt.setString(11,orders.getShipservicelevel());
                          
                          preparedStmt.setString(12,orders.getCurrency());
                          
                          preparedStmt.setString(13,orders.getAmount());
                          
                        
                          
                          preparedStmt.setString(14,orders.getQtyshipped());
                          
                          preparedStmt.setString(15,orders.getQtyunshipped());
                          
                          preparedStmt.setString(16,orders.getBusinessorder());
                          
                          preparedStmt.setString(17,orders.getPrime());
                          
                          preparedStmt.setString(18,orders.getPremium());
                          
                          preparedStmt.setString(19,orders.getPaymentmethod());
                          
                          preparedStmt.setString(20,orders.getEmail());
                          
                      
                          preparedStmt.setString(21,orders.getAmazonorderid());
                          
                          
                       // execute the preparedstatement
                          preparedStmt.execute();
                          System.out.println("inserted");
                          
                          
                          
                          //after inserting, close the connection
                          connection.close();
                          
                      } catch (SQLException e) {
                          throw new IllegalStateException("Cannot connect the database!", e);
                      }
                      
                      
                      
                      
                      
                      
                   }
                }
             } catch (Exception e) {
            	 
            	 System.out.println("here is the canceled Order");
            	 

                e.printStackTrace();
                
                
                
                
                
                
             }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
      /*      //try to out put response xml to file 
            
            
            // Parse the given input
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(new InputSource(new StringReader(responseXml)));

            
            // Write the parsed document to an xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
         
            
            StreamResult result =  new StreamResult(new File("Y:\\Staffs\\Joey\\Developer\\JoeyAdvisor\\completeorders"+count+ ".xml"));
            
            
            transformer.transform(source, result);
            */
     
            
            
        	
         

         
			
			/*//Retrieve from saved information and try to put it into objects to be wrtitten to DB
            
            
            FileInputStream input = new FileInputStream("Y:\\Staffs\\Joey\\Developer\\JoeyAdvisor\\ordertest"+count+ ".xls");  
                POIFSFileSystem fs = new POIFSFileSystem( input );  
                HSSFWorkbook wb = new HSSFWorkbook(fs);  
                HSSFSheet sheet = wb.getSheetAt(0);  
                HSSFRow row;  
                
                //format int cells to string
                
                DataFormatter formatter = new DataFormatter();

                for(int i=1; i<=sheet.getLastRowNum(); i++)
                {  
                    Amazonorders order = new Amazonorders(responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, responseXml, null, null, null, responseXml, responseXml, responseXml, responseXml, responseXml, null, responseXml, responseXml, responseXml);
                    row = sheet.getRow(i);  
                    
                    System.out.println("Number of fileds in order object is "+order.getColumnCount());

	                  order.setAmazonorderid(String.valueOf(row.getCell(0).getRichStringCellValue()));  
	                  System.out.println(order.getAmazonorderid());
	                  
	                  order.setSellerorderid(String.valueOf(row.getCell(1).getRichStringCellValue()));
	                  System.out.println(order.getSellerorderid());
	                  
                      order.setPurchasedate(String.valueOf(row.getCell(2).getRichStringCellValue()));
                      System.out.println(order.getPurchasedate());
                      
                      order.setLastupdatedate(String.valueOf(row.getCell(3).getRichStringCellValue()));
                      System.out.println(order.getLastupdatedate());
                      
                      order.setOrderstatus(String.valueOf(row.getCell(4).getRichStringCellValue()));
                      System.out.println(order.getOrderstatus());
                      
                      order.setFulfillmentchannel(String.valueOf(row.getCell(5).getRichStringCellValue()));
                      System.out.println(order.getFulfillmentchannel());
                      
                      order.setSaleschannel(String.valueOf(row.getCell(6).getRichStringCellValue()));
                      System.out.println(order.getSaleschannel());
                      
                      order.setShipservicelevel(String.valueOf(row.getCell(7).getRichStringCellValue()));
                      System.out.println(order.getShipservicelevel());
                      
                      order.setCustomername(String.valueOf(row.getCell(8).getRichStringCellValue()));
                      System.out.println(order.getCustomername());
                      
                      order.setStreetname(String.valueOf(row.getCell(9).getRichStringCellValue()));
                      System.out.println(order.getStreetname());
                      
                      order.setCity(String.valueOf(row.getCell(10).getRichStringCellValue()));
                      System.out.println(order.getCity());
                      
                      order.setState(String.valueOf(row.getCell(11).getRichStringCellValue()));
                      System.out.println(order.getState());
                      
                      order.setZip(String.valueOf(row.getCell(12).getRichStringCellValue()));
                      System.out.println(order.getZip());
                      
                      order.setCountry(String.valueOf(row.getCell(13).getRichStringCellValue()));
                      System.out.println(order.getCountry());
                      
                      order.setPhone(String.valueOf(row.getCell(14).getRichStringCellValue()));
                      System.out.println(order.getPhone());
                      
                      //formatter to formatecellvalue from int to string
                      order.setQtyshipped(formatter.formatCellValue((row.getCell(16))));
                      System.out.println(order.getQtyshipped());
                      
                
                      
     
                      
                      

                }  
  
            
            

            
        count++;
		
            */
            
            
            return response;
            
            
        } catch ( MarketplaceWebServiceOrdersException ex) {
            // Exception properties are important for diagnostics.
            
        	System.out.println("Service Exception:");
            
        	ResponseHeaderMetadata rhmd = ex.getResponseHeaderMetadata();
            
        	
        	if(rhmd != null) {
            	
                System.out.println("RequestId: "+rhmd.getRequestId());
                
                System.out.println("Timestamp: "+rhmd.getTimestamp());
            }
            
            System.out.println("Message: "+ex.getMessage());
            
            System.out.println("StatusCode: "+ex.getStatusCode());
            
            System.out.println("ErrorCode: "+ex.getErrorCode());
            
            System.out.println("ErrorType: "+ex.getErrorType());
            
            
            
            
            
            throw ex;
        } 
        
        
        
    
    	
    	
    	
    	
    	
    }

    /**
     *  Command line entry point.
     * @throws Exception 
     * @throws GeneralSecurityException 
     */
    public static void main(String[] args) throws GeneralSecurityException, Exception {

    	
    	
    	
        // Get a client connection.
        // Make sure you've set the variables in MarketplaceWebServiceOrdersSampleConfig.
        MarketplaceWebServiceOrdersClient client = MarketplaceWebServiceOrdersSampleConfig.getClient();

        // Create a request.
        GetOrderRequest request = new GetOrderRequest();
        
        
        
        String sellerId = "000";
        
        
        request.setSellerId(sellerId);
        
        
        
        
        String mwsAuthToken = "0000";
        
        
 
        
        request.setMWSAuthToken(mwsAuthToken);
        
        

        
        //retrieve a list of amazon order ids 
        

   	 /*// Location of the source file
      String sourceFilePath = "Y:\\Staffs\\Joey\\Developer\\JoeyAdvisor\\order report.xls";
      
      
	   
      FileInputStream fileInputStream = null;
        
      // Array List to store the excel sheet data
      ArrayList excelData = new ArrayList();
      
      
    //String array to store SKUs to get price
      List<String> str = new ArrayList<String>();

        
      //A more robust importing method for importing excel data to arrays
      try {
            
          // FileInputStream to read the excel file
          fileInputStream = new FileInputStream(sourceFilePath);

          // Create an excel workbook
          HSSFWorkbook excelWorkBook = new HSSFWorkbook(fileInputStream);
            
          // Retrieve the first sheet of the workbook.
          HSSFSheet excelSheet = excelWorkBook.getSheetAt(0);
            
        
          // Iterate through the sheet rows and cells. 
          // Store the retrieved data in an arrayList
          java.util.Iterator<Row> rows = excelSheet.rowIterator();
          while (rows.hasNext()) {
              HSSFRow row = (HSSFRow) rows.next();
              java.util.Iterator<Cell> cells = row.cellIterator();

              ArrayList cellData = new ArrayList();
              while (cells.hasNext()) {
                  HSSFCell cell = (HSSFCell) cells.next();
                  cellData.add(cell);
              }

              excelData .add(cellData);
          }
            

          for(int i = 0; i<excelData.size();i++)
          {
         	 
         	 
         	String a = (excelData.get(i).toString().split(",")[0]);
         	
         	System.out.println(a.substring(1, a.length()));
         	
         	str.add(a.substring(1, a.length()));
         	 
          }
          
          
         System.out.println(str.get(0));
         str.remove(0);
         System.out.println("the list with id is " + str.get(0));
         
         
         
         
         
          //remove duplicate, should  have used hash to reduce complexity, will optimize later
          for(int i = 0; i<str.size();i++)
          {
       	   
        	  for(int j = i+1; j< str.size(); j++){
        		  
        		  
        		if(str.get(i) == str.get(j))
        		{
        			
        			str.remove(j);
        			
        		}
        		  
        		  
        	  }
       	   
       	   System.out.println(str.get(i));
       	   
       	   
       	 
       	   
          }
          
          
        
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if (fileInputStream != null) {
              try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
      }
        
      
      
      System.out.println(str.size());*/
      
        
        
        //Use DB approach to retrieve order numbers
//write to db
        
        String url = "00";
        String username = "00";
        String password = "00";
        
        System.out.println("Loading driver...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        
        System.out.println("Connecting database...");
        
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	
        	
            System.out.println("Database connected!");
            
            
            
            
            //if successful begin to retrieve amaozn order #
           
    
            String query = "select OrderNumbers from AmazonOrders";
              
            
            Statement st = connection.createStatement();
            
           
           //Intialize Arraylist to store amazon order ids;
            ArrayList<String> str = new ArrayList<String>();
            
         // execute the preparedstatement, and get result
            ResultSet rs = st.executeQuery(query);
            
    
           while(rs.next()){
        	   
        	   //Has to use an object to store the data retireved from mysql
        	   Amazonorders order = new Amazonorders(query, query, query, query, query, query, query, query, query, query, query, query, query, query, query, query, query, query, query, query, query, 
        			   query, query, null, null, null, query, query, query, query, query, null, query, query, query);
        	   
        	order.setAmazonorderid(rs.getString("OrderNumbers"));
        	
        	str.add(order.getAmazonorderid());
        	   
        	
        	   
        	   
        	   
           }
        

		    for(int i = 0; i<str.size();i++)
		    {
		    	
		    	
		    	System.out.println(str.get(i));
		    	
		    	
		    }
            
            //after retrieving the result, close the connection
            connection.close();
            
            
            
            
           //only accept 50 orders at a time, this code is to send 50 at a time.  Lists.partition is google lang
            for (List<String> orderidpartition : Lists.partition(str, 50)) {
          	  
          	  System.out.println(orderidpartition.size());
          	  
          	  request.setAmazonOrderId(orderidpartition);
              

                // Make the call.
                GetOrderSample.invokeGetOrder(client, request);
                
                
                //time paused for each request, time out in mili seconds. 
                Thread.sleep(10000);
                
                System.out.println("Im about to get another set");
                
          	}
            
        }        
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        
        
    
       
    

        
        
    }
    
    
    
    

}
