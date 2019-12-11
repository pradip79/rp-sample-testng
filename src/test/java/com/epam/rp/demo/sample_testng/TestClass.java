package com.epam.rp.demo.sample_testng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

class TestClass {

	public static void main(String[] args) {
		List<String> arrlst = new ArrayList<String>();
	     arrlst.add("tech");
	     arrlst.add("beamers");
	     arrlst.add("java");
	     arrlst.add("python");
	     arrlst.add("selenium");
	     arrlst.add("selenium");
	     arrlst.add("shell");
	 
	     // Displaying the ArrayList elements 
	     System.out.println("Before:");
	     System.out.println("ArrayList contains: "+arrlst);
	 
	     // Creating a LinkedHashSet
	     LinkedHashSet<String> linkhs = new LinkedHashSet<String>();
	 
	     /* Adding ArrayList elements to the LinkedHashSet
	      * in order to remove the duplicate elements and 
	      * to preserve the insertion order.
	      */
	     linkhs.addAll(arrlst);
	  
	     // Removing the ArrayList elements
	     arrlst.clear();
	 
	     // Adding the LinkedHashSet elements to the ArrayList
	     arrlst.addAll(linkhs);
	 
	     // Displaying ArrayList elements
	     System.out.println("After:");
	     System.out.println("ArrayList contains: "+linkhs);

	}

}


