package com.altran.training.AssignmentProject14;

import java.util.Comparator;

/***********************************************************************
Altran Technologies Proprietary

This source code is the sole property of Altran Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :ComparatorImplement.java
Principal Author			  :kamalaksha
Subsystem Name                :Core Java Training
Module Name                   :
Date of First Release         :07-April-2021 11:05:10 am
Author                        :kamalaksha
Description                   :ComparatorImplement class implements Comparator class 

***********************************************************************/
public class ComparatorImplement implements Comparator<Student> {
  
	/**
	 * This method Overrides the compare method of Comparator class 
	 */
	
	public int compare(Student o1, Student o2) {
		if(o1.getCreditPoints() > o2.getCreditPoints() )
		{
			return 1;
		}
		else if(o1.getCreditPoints()==o2.getCreditPoints())
		{
			return o1.getLoginName().compareTo(o2.getLoginName());
		}
		return -1;
	}
      
   
}
