package com.epam.rp.demo.sample_testng;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
  
  @DataProvider (name = "dataProvider")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside beforeTest");
  }
  
  @Test(priority=1)
  public void f1() {
	  System.out.println("Inside f1");
  }
  
  @Test(priority=2, dependsOnMethods= {"f1"})
  public void f2() {
	  System.out.println("Inside f2");
  }
  
  @Test(priority=3, dependsOnMethods= {"f2"})
  public void f3(){
	  System.out.println("Inside f3");
  }
  
  @Test(priority=4)
  public void f4() {
	  System.out.println("Inside f4");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside afterTest");
  }

}
