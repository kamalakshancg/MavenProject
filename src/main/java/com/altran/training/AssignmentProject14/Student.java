package com.altran.training.AssignmentProject14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/***********************************************************************
Altran Technologies Proprietary

This source code is the sole property of Altran Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :Student.java
Principal Author			  :kamalaksha
Subsystem Name                :Core Java Training
Module Name                   :
Date of First Release         :07-April-2021 08:12:10 am
Author                        :kamalaksha
Description                   :Student class contains nameValidation,getLoginName,changeStudentName,displayDetails,addCredit methods

***********************************************************************/


public class Student {
     
	 static int p;
	 static
	 {
		 p=101;
	 }
	 public String studentId;
	 public String studentName;
	 public int creditPoints;
	 
	 
	 /**
	  * This is 2 arg Constructor with studentName,creditPoints argument
	  * and initialize the arguments
	  */
	 public Student(String studentName,int creditPoints) throws NullPointerException,NameNotValidException
	 {
		if (nameValidation(studentName))
		{
			System.out.println("Validation is succesfull");
			this.studentName=studentName;
		}else
		{
			this.studentName=null;
			throw new NullPointerException("Name is invalid");
		}
		if (creditPoints>0)
		{
			this.creditPoints=creditPoints;
		}else 
		{
			this.creditPoints=0;
		}
		studentId=p++ + "";
	
	}
	 
	 /**
	  * This method Validates the given name
	  * @param name This is a parameter given to validate
	  * @return This returns true when validation is successful
	  * @throws NameNotValidException This is thrown when Validation is unsuccessful
	  */
	 public boolean nameValidation(String name) throws NameNotValidException
	 {
		 if (name.length()>=4 && name.matches("^[a-zA-Z]+$"))
		 {
			 return true;
		 }
		 
		 throw new NameNotValidException("name is not valid");
	}
	 
	    /**
		 * This method returns first 4 letters as login name for all students with id concatenated
		 * @return
		 */
	 public String getLoginName() 
	 {
		 if (studentName.length()>4) 
		 {
			 return studentName.substring(0,4)+studentId.substring(0,3);
		 }else 
		 {
			 return this.studentName+this.studentId;
		 }
	 }
	 
	 /**
	  * This method change the specific student name
	  * @param studentId  This is the first parameter to know the student name
	  * @param newName    this is the second parameter to change the name
	  * @return
	  * @throws NameNotValidException  This is thrown when name validation i unsuccessfull
	  */
	 public String changeStudentName(String studentId,String newName) throws NameNotValidException 
	 {
	     if (nameValidation(newName))
		  {   
				String name=this.studentName;
				this.studentName=newName;
				return "Name changed successfully from "+name+" to "+newName;
		   }else
		   {
			   return "Check the new name";
		   }
	 }

	/**
	  * This method is used to display student details
	  */
	 void displayStudentDetail()
	 {      
		 
			System.out.println("StudentId->"+this.studentId);
			System.out.println("Student name->"+this.studentName);
			System.out.println("creditpoints->"+this.creditPoints);
			
	 }
	 
	 /**
	  * This method is used to add extra credit points to specific student
	  * @param id  This is the first parameter indicating the student
	  * @param newCredits This is second parameter which to be added
	  * @return
	  * @throws InvalidCreditsException This is thrown when new credit points is invalid
	  */
	 int addCredit(String id, int newCredits) throws InvalidCreditsException 
	 {
		  if(newCredits<=0)
		  {
	            throw new InvalidCreditsException("credit point is invalid");
		  }else
		  {
			    this.creditPoints+=newCredits;
				return this.creditPoints;
		  }
				
	  }
	 
	 /**
	  * This method returns the total number of students
	  * @param studentArrayList 
	  * @return
	  */
	 public int totalStudents() 
	 {
		 return Test.studentArrayList.size();
	 }
	 
	 /**
	  * This method delete specific student detail
	  * @param studentId
	  */
	public static  void deleteStudent(String studentId)
	{   
		boolean flag=false;
		Student studentObject=null;
		for(Student object:Test.studentArrayList)
		{
			
			if(studentId.equals(object.studentId))
			{
				flag=true;
				studentObject=object;
			}
	 
	   }
		if(flag==true)
		{
			Test.studentArrayList.remove(studentObject);
			System.out.println("object is removed");
		}else
		{
			System.out.println("student not found");
		}
		
    }
    
	/**
	 * This method is used as getters to get creditPoints
	 * this method is used in ComparatorImplemented class
	 * @return
	 */
	public int getCreditPoints() {
	
		return this.creditPoints;
	}
} 
