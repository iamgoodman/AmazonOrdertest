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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import com.amazonservices.mws.client.*;
import com.amazonservices.mws.orders._2013_09_01.*;
import com.amazonservices.mws.orders._2013_09_01.model.*;
import com.google.common.collect.Lists;


/** Sample call for GetOrder. */
public class GetOrderSample {

    /**
     * Call the service, log response and exceptions.
     *
     * @param client
     * @param request
     *
     * @return The response.
     */
    public static GetOrderResponse invokeGetOrder(
            MarketplaceWebServiceOrders client, 
            GetOrderRequest request) {
        try {
            // Call the service.
            GetOrderResponse response = client.getOrder(request);
            ResponseHeaderMetadata rhmd = response.getResponseHeaderMetadata();
            // We recommend logging every the request id and timestamp of every call.
            System.out.println("Response:");
            
            System.out.println("RequestId: "+rhmd.getRequestId());
            
            System.out.println("Timestamp: "+rhmd.getTimestamp());
            
            String responseXml = response.toXMLFragment();
      
            System.out.println(responseXml);
            
            return response;
            
            
        } catch (MarketplaceWebServiceOrdersException ex) {
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
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {

    	
        // Get a client connection.
        // Make sure you've set the variables in MarketplaceWebServiceOrdersSampleConfig.
        MarketplaceWebServiceOrdersClient client = MarketplaceWebServiceOrdersSampleConfig.getClient();

        // Create a request.
        GetOrderRequest request = new GetOrderRequest();
        
        
        
        String sellerId = "***";
        
        
        
        request.setSellerId(sellerId);
        
        
        
        
        String mwsAuthToken = "***";
        
        
 
        
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
      
    
       
      //only accept 50 orders at a time, this code is to send one at a time, will optimize later. Lists.partition is google lang
      for (List<String> orderidpartition : Lists.partition(str, 50)) {
    	  
    	  System.out.println(orderidpartition.size());
    	  
    	  request.setAmazonOrderId(orderidpartition);
        

          // Make the call.
          GetOrderSample.invokeGetOrder(client, request);
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
