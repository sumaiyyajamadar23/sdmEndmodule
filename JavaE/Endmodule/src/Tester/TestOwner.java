package Tester;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import javax.xml.validation.Validator;

import Utils.IoUtils;
import Utils.IoUtils.*;
import Utils.Validationrules;

import com.code.Owner;

public class TestOwner {

	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{
     try(Scanner sc=new Scanner(System.in))	
     {
    	 System.out.println("Enter file Name:");
    	 String file=sc.next();
    	 HashSet<Owner> owner=IoUtils.restore(file);
    	 boolean exit=false;
    	 
    	 while(!exit)
    	 {
    		 System.out.println("1.Add new Owner "
    		 		+ "2. Display All Owners"
    		 		+ "3.Remove owner based on adhar no"
    		 		+ "4.Update contact no"
    		 		+ "5.Sort owner As per Property type and rent"
    		 		+ "Change status of owner");
    		 try
    		 {
    			 System.out.println("Enter your choice:");
    			 switch(sc.nextInt())
    			 {
    			 case 1:
    				 System.out.println("Enter Details to add Owner:");
    				 System.out.println("adharno,firstname,lastname, email,address, mobileno,type1, date,rent,isavailable");
    				 Owner own=Validationrules.validateAll(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean(), owner);
    				
    					owner.add(own); 
    				
    				 break;
    			 case 2:
    				 System.out.println("List of owners:");
    				  owner.stream()
    				 .forEach(o->System.out.println(o));
    				  break;
    			 case 3:
//    				 System.out.println("Adhar no:");
//    				 String adhar=sc.next();
//    				 owner.stream()
//    				 .removeIf(p->p.getadharno()==(adhar));
//    				 //.forEach(o1->System.out.println(o1));
    				 break;
    			 case 4:
//    				 System.out.println("Enter Email no to enter:");
//    				 String email=sc.next();
//    				// Owner o=new Owner(email);
//    				 if(owner.contains(email))
//    				 {
//    				 System.out.println("Enter contact no to update");
//    				 String contact=sc.next();
//    				owner. setMobileno(contact);
//    				 }
    				 break;
    			 case 5:
    				 
    				 break;
    			 case 0:
    				 exit=true;
    				 IoUtils.store(file, owner);
    				 break;
    		  default:
    					 System.out.println("Invalid choice!!!Try again");
    			 }
    		 }
    		 catch(Exception e)
    		 {
    			 System.out.println(e);
    			 sc.nextLine();
    		 }
    	 }
     }

	}

}
