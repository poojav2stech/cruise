package mavenproject.booking_system;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.util.*;
import java.io.*;

import com.opencsv.CSVReader;

public class CruiseBookingSystem

{

	public static void main( String[] args ) throws IOException
    {//comments initialization
		ArrayList<Customers> a3=new ArrayList<>();

       ArrayList<Customers> a=new ArrayList<>();

       ArrayList<BookedCustomer> a1=new ArrayList<BookedCustomer>();

       ArrayList<BookedCustomer> a2=new ArrayList<BookedCustomer>();

       int ch;
        
       boolean flag=false;
       

      do {
    	  Scanner sc=new Scanner(System.in);
    	  System.out.println(" \n 1.Read customer data into list from file \n 2.Display all customer id and names from list\n 3.Search for customer in list\n 4.Allow customer to book cruise\n 5.View customer who booked cruise\n 6.Save Customers to file\n 7.Fetch Records as per customer ID\n 0.Exit\n ");

    	 
    	System.out.println("enter your choice from above");

    	  ch=sc.nextInt();

    	  int counter=0;

	        String file="/home/v2stech/Documents/pooja/program_during_sessions/booking_system/src/main/resources/pooja.csv";
	        String file1="pooja.csv";

    	  switch(ch)

    	  {

    	  case 1:
    		  

    		  try {
    			  System.out.println("Enter the name of the data file");
                String fname=sc.next();
                if(fname.equals(file1))
                {
                	FileReader filereader = new FileReader(file);

    	    		 

    		        // create csvReader object passing

    		        // file reader as a parameter

    		        CSVReader csvReader = new CSVReader(filereader);

    		        String[] nextRecord;
    		 

    		        // we are going to read data line by line

    		        while ((nextRecord = csvReader.readNext()) != null) {

    		        	//System.out.print(nextRecord[0]+" ");

    		        //	System.out.print(nextRecord[1]+" ");

    		        //1	System.out.print(nextRecord[2]+" ");
    		        	if((nextRecord[2].endsWith(".com") || nextRecord[2].endsWith(".in")) && nextRecord[2].contains("@"))
    		        	{

    		        	Customers e=new Customers(nextRecord[0],nextRecord[1],nextRecord[2]);

    		        a.add(e);

    		        	counter++;
    		        	}

    		        	else
    		        	{
    		        		System.out.println("this is invalid email_id"+nextRecord[2]);
    		        	}
    		       

    		        	

    		          }

    		        System.out.println("Numbers of records read:"+counter);

    		            

    		        }
                
                
                else
                {
                	System.out.println("this file cant be read please enter appropiate file name");
                }
    		  }
    		  
    		  
    		 

    		    catch (Exception e) {

    		       System.out.println("please enter correct file name");

    		    }

    		  flag=true;

    		  break;

    		  

    	  case 2:
    		  if(flag==true)
    		  {
	
    		  for(Customers e:a)

    		  {

    			  System.out.println("id="+ e.getId()+"name="+ e.getName());

    		  }
}
else
{
	System.out.println("First read csv file");
}

    		  break;

    	  case 3:
    		  if(flag==true)
    		  {

    		  System.out.println("enter the name of the customer whose information is to be displayed");

    		  String searchname=sc.next();

    		  for(Customers e:a)

    		  {

    		  if(e.getName().contains(searchname))
    			
    		  {

    			  

    		         System.out.println("id="+e.getId()  +"  name=" +e.getName());



    		  }

    			  

    		  }

    		  }
    		  else
    		  {
    			  System.out.println("First read file");
    		  }

    		   break;

    		   

    		   

    	  case 4:
if(flag==true)
{
    		  

    		  System.out.println("enter name of the customer");

    		  String name=sc.next();
    		
    		  System.out.print("enter date ");
  			System.out.print("\n\tenter  day: ");
  			int d = sc.nextInt();
  			if (d > 0 & d <= 31) {
  				d = d;
  			} else {
  				System.out.print("please enter value between month days that is from 1 to 31*****\n\tenter  day: ");
  				d = sc.nextInt();
  			}
  			System.out.print("\n\tenter  month: ");
  			int m = sc.nextInt();
  			if (m > 0 & m <= 12) {
  				m = m;
  			} else {
  				System.out.print("please enter value for month that is from 1 to 12\n\tenter  month: ");
  				m = sc.nextInt();
  			}
  			System.out.print("\n\tenter  year: ");
  			int y = sc.nextInt();
  			if (y > 2021 & y <= 2030) {
  				y = y;
  			} else {
  				System.out
  						.print("please enter value for year that is from 2022 to 2030*****\n\tenter   year: ");
  				y = sc.nextInt();
  			}

  		String 	app_date = d + "/" + m + "/" + y;



    		  for(Customers c:a)

    		  {

    			  if(c.getName().equals(name))

    			  {

    				  BookedCustomer b=new BookedCustomer(c.getId(),c.getName(),c.getEmail(),app_date);

    				  a1.add(b);

    			  }
    			 

    		  }
}
else
{
	System.out.println("First read csv file");
	
}
    		  

    		 break;
    		 
    	  case 5:
    		  if(flag==true)
    		  {
    		  
    		  System.out.println("enter date");
    		  String searchdate=sc.next();
    		  int counter1=0;
    		 for(BookedCustomer b:a1)
    		 {
    			 if(searchdate.equals(b.getCdate()))
    			 {
    				 System.out.println("id="+b.getCid()+"name="+b.getCname());
    			 }
    			 counter1++;
    			 
    		 }
    		  System.out.println("Number of attendees"+counter1);
    		  }
    		  else
    		  {
    			  System.out.println("First read csv file");
    		  }
    		  
    		  break;

    		  

    		  

    	  case 6:
    		  if(flag==true)
    		  {
    		  


    		  System.out.print("enter date ");
    			System.out.print("\n\tenter  day: ");
    			int d1= sc.nextInt();
    			if (d1 > 0 & d1 <= 31) {
    				d1 = d1;
    			} else {
    				System.out.print("please enter value between month days that is from 1 to 31*****\n\tenter  day: ");
    				d1 = sc.nextInt();
    			}
    			System.out.print("\n\tenter  month: ");
    			int m1 = sc.nextInt();
    			if (m1 > 0 & m1<= 12) {
    				m1 = m1;
    			} else {
    				System.out.print("please enter value for month that is from 1 to 12\n\tenter  month: ");
    				m1 = sc.nextInt();
    			}
    			System.out.print("\n\tenter  year: ");
    			int y1= sc.nextInt();
    			if (y1 > 2021 & y1 <= 2030) {
    				y1 = y1;
    			} else {
    				System.out
    						.print("please enter value for year that is from 2022 to 2030*****\n\tenter   year: ");
    				y1 = sc.nextInt();
    			}

    		String 	specifieddate = d1+ "/" + m1+ "/" + y1;
    		  

    		  String specifieddate1=d1+""+m1+""+y1;
    		 

    		  for(BookedCustomer b:a1)

    		  {

    		  if(specifieddate.equals(b.getCdate()))

    		  {
    			  a2.add(b);
    			  

    			  

    		  }

    		  else

    		  {

    			  System.out.println(" data not found in list");

    		  }

    		  }
    		  try
    		  {

    


    		  FileWriter writer = new FileWriter("src/main/resources/"+specifieddate1+".csv");			

  			for (BookedCustomer u : a2) {

  				System.out.println(u.getCid());

  				writer.append(u.getCid()+","+u.getCname()+","+u.getCdate()+"\n");

  			}

  			writer.close();

  			

  			

  			System.out.println("data saved sucessfully in file");

    		  

    		  }

    
    		 

    		  catch(Exception e)

    		  {

    			  System.out.println(e);

    		  }

    		  

    		  }
    	  
    	  else
    	  {
    		  System.out.println("First read csv file");
    	  }

    		  break;
    		
    		  
    	  case 7:
    			if(flag==true)
    			{
    				int count = 0;
    				System.out.println("Enter Customer ID");
    				String in = sc.next();
    				for (Customers apt : a) {
    					if (apt.getId().equals(in) & count == 0) {
    						System.out.println("C_ID" + "\t " + "Customer_Name");
    					}
    					if (apt.getId().contains(in)) {
    						System.out.println(apt.getId() + "\t " + "\t " + apt.getName());
    						count++;
    					}
    				}
    				if (count == 0) {
    					System.out.println("No Customer Found !!");
    				}
    			
    			}
    			else
    			{
    				System.out.println("First read csv file");
    			}
    		  
    		  break;
    	  case 0:
    		  System.exit(ch);
    		  

    	  

    	  } 

    	  

      }while(ch>0);

       

    }

}