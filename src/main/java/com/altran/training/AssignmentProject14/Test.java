package com.altran.training.AssignmentProject14;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/***********************************************************************
Altran Technologies Proprietary

This source code is the sole property of Altran Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :Test.java
Principal Author			  :kamalaksha
Subsystem Name                :Core Java Training
Module Name                   :
Date of First Release         :07-April-2021 09:12:10 am
Author                        :kamalaksha
Description                   :Test class contains main() and calls methods of student class


***********************************************************************/

public class Test 
{
	
	
	public static List<Student> studentArrayList = new ArrayList<Student>();
	
	/**
	 * This is the main method to call all methods of student class
	 * @param args
	 * @throws NameNotValidException
	 * @throws NullPointerException
	 * @throws InvalidCreditsException
	 */
	public static void main(String[] args) throws NameNotValidException,NullPointerException,InvalidCreditsException 
	{
		
		Scanner sc = new Scanner(System.in);
	
	
		while (true)
		{
			try 
			{
				
			System.out.println("Press 1 to add student details ");
			System.out.println("Press 2 to add credits ");
			System.out.println("Press 3 to change name of student ");
			System.out.println("Press 4 to display details ");
			System.out.println("Press 5 to display total number of students ");
			System.out.println("Press 6 to delete student ");
			System.out.println("Press 7 to exit ");
			
			int option = sc.nextInt();
			
			boolean flag=true;
			switch (option)
			{
			case 1:
				   System.out.println("Enter Student name: ");
			       String name=sc.next();
		    
			       System.out.println("Enter the Credit points: ");
			       int creditPoint=sc.nextInt();
			       
			       Student studentObj=new Student(name,creditPoint);
			       studentArrayList.add(studentObj);
			       
			       System.out.println("Student details added succesfully");
			       
			       String loginName=studentObj.getLoginName();
			       System.out.println("Login name is "+loginName);
			      
			       break;
			       
			case 2: Iterator<Student> it = studentArrayList.iterator();
					System.out.println("Enter the student Id to change the name: ");
					String id1=sc.next();
					
					boolean creditFlag=false;
					try
					{
				        while (it.hasNext())
				        {
				        	Student obj = it.next();
				        	
				        	if (obj.studentId.equals(id1))
				        	{
				        		System.out.println("Enter new credit to add");
				        		int newCredit = sc.nextInt();
				        		
				        		obj.creditPoints=obj.addCredit(id1, newCredit);
				        		
				        		creditFlag=true;
				        		
				        	}
				        	
				        }
				        
				        if (creditFlag==true)
				        {
				        	System.out.println("credits added succesfuly");
				        }else
				        {
				        	System.out.println("Invalid Student Id");
				        }
				        
				        
					}
					catch (InvalidCreditsException e1)
					{
						System.out.println(e1.getMessage());
					}
					
			        break;
			        
			        
			case 3:
					Iterator<Student> itt = studentArrayList.iterator();
					System.out.println("Enter the student Id to change the name: ");
					String id2=sc.next();
					
					boolean nameFlag=false;
					try
					{
				       while (itt.hasNext())
				       {
				    	   Student ob = itt.next();
				    	   if (ob.studentId.equals(id2))
				    	   {
				    		   System.out.println("Enter the new name to add:");
							   String newName=sc.next();
							   
							   String result=ob.changeStudentName(id2, newName);
							   System.out.println(result);
							   nameFlag=true;
				    	   }
				       }
				        
				        if (nameFlag==false)
				        {
				        	System.out.println("Invalid Student Id");
				        }
				        
					}
					catch (NullPointerException e2)
					{
						System.out.println(e2.getMessage());
					}
					catch (NameNotValidException e3)
					{
						System.out.println(e3.getLocalizedMessage());
					}
					
			        break;
			        
			case 4:  Collections.sort(studentArrayList, new ComparatorImplement());
				     Iterator<Student> it3 = studentArrayList.iterator();
				     if (studentArrayList.size()!=0)
				     {
					  while (it3.hasNext())
				       {
				    	   Student ob = it3.next();
				    	   
						   ob.displayStudentDetail();
							  
				       }
				     }else
				     {
				    	 System.out.println("No students data ");
				     }
				   
				  break;
				  
			case 5:  
				     Iterator<Student> it4 = studentArrayList.iterator();
			         
				     if (studentArrayList.size()!=0)
				     {
					  while (it4.hasNext())
				       {
				    	   Student ob = it4.next();
						   int total=ob.totalStudents();
						   System.out.println("Total number of students: "+total);
							  
				       }
				     }else
				     {
				    	 System.out.println("No students data ");
				     }
			        break;
			        
			case 6: 
			        if (studentArrayList.size()!=0)
				     { 
			        	System.out.println("Enter Student Id");
				        String studentId = sc.next();
				        
			            Student.deleteStudent(studentId);
				     }else
				     {
				    	 System.out.println("No students data ");
				     }
			        
			        break;
			        
			     
			case 7:flag=false;
			       System.out.println("Thank You");
			       System.exit(0);
			       
				   
			default : throw new InputMismatchException();
				       
			}//end switch
			
			if(flag==true)
				continue;
			else
				break;
			
			}
			catch (InputMismatchException e1)
			{
				System.out.println("Enter Valid number between 1 to 7");
				sc.nextLine();
			}
			catch (NameNotValidException e2)
			{
				System.out.println(e2.getMessage());
			}
			
		}//end while
   
		sc.close();
	}

}

