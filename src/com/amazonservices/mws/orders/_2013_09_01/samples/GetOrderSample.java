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
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;

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
	
	//global counter for generating multiple order files
	static int count  = 0;
	
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
            
            
            
            
            //try to out put response xml to file 
            
            
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
            
            //to do
            //how to use code do open xml and output excel and save as xls.
            
            
         
      
            
            
              //create a class to store all variables generated from result form implementation to the DB
             
            //try to use jexcelapi to accheive 
       
            
            InputStream fin = new FileInputStream("Y:\\Staffs\\Joey\\Developer\\JoeyAdvisor\\completeorders"+count+ ".xml");
            
        	
         

         
			
			
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
                      
                      
                      
                      
                   /*   //check for null values for currency
                      String currency =formatter.formatCellValue(row.getCell(26));
                      
                      if(currency != null)
                      {
                      order.setCurrency(currency);
                    
                      System.out.println(order.getCurrency());
                      }
                     
                      
                      
                      
                      //check for null values for amount
                      String amount =formatter.formatCellValue(row.getCell(27));
                      
                      if(amount != null)
                      {
                    	  
                    	  order.setAmount(amount);
                    	
                          System.out.println(order.getAmount());
 
                      }
                      
           
                      //check for null values for email
                      String email =formatter.formatCellValue(row.getCell(29));
                      
                      if(email != null)
                      {
                    	  order.setEmail(email);
                    	 
                         System.out.println(order.getEmail());
                      }*/
                      
                
                     
                      //do insertion of sql here
                
                      
                      

                }  
  
            
            
            
            
            
     
            
            
            
            
            
            
            
        count++;
		
            
            
            
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
        
        
        
        String sellerId = "*****";
        
        
        
        request.setSellerId(sellerId);
        
        
        
        
        String mwsAuthToken = "*****";
        
        
 
        
        request.setMWSAuthToken(mwsAuthToken);
        
        

        
        //retrieve a list of amazon order ids 
        

   	 // Location of the source file
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
         	
         /*	System.out.println(a.substring(1, a.length()));*/
         	
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
        
      
      
      System.out.println(str.size());
      
    
       
      //only accept 50 orders at a time, this code is to send 50 at a time.  Lists.partition is google lang
      for (List<String> orderidpartition : Lists.partition(str, 50)) {
    	  
    	  System.out.println(orderidpartition.size());
    	  
    	  request.setAmazonOrderId(orderidpartition);
        

          // Make the call.
          GetOrderSample.invokeGetOrder(client, request);
          
          
          //time paused for each request, time out in mili seconds. 
          Thread.sleep(10000);
          
          
    	}
      
      
/*      ArrayList<String> orderids = new ArrayList<String>();
      
     orderids.add(str.get(0));
     
     
      request.setAmazonOrderId(orderids);

      
      

      
      // Make the call.
      GetOrderSample.invokeGetOrder(client, request);

       */
        
       
        
        
        
        
    }
    
    
    
    

}
