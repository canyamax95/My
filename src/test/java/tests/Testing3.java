package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	SoftAssert softAssert = new SoftAssert();
	
  @Test (priority = 1, groups = "smoke")//To run test in order we use priority. so, it will run the code according priority number
  //for JUnit @FixMethodOrder(MethodSorters.NAME_aSCENDING) To prioritize the run order
  public void createUser() {
	  System.out.println("I'm in home test");
	  System.out.println("Before assertion");
	  Assert.assertTrue(2>3, "Verifying Element");
	  System.out.println("After assertion");
	  Assert.assertEquals("abc", "abc");
  }
  
  @Test (priority = 2, dependsOnMethods = "createUser")// if Test1 has failed then Test2 needs to run. So, we use dependsOnMethods to skip the failed test. Run and check console
  public void editUser() {
	  System.out.println("Before assertion");
	  softAssert.assertTrue(2>3, "Verifying Element");
	  System.out.println("After assertion");
	  softAssert.assertAll(); //similar to error collector in Junit
  }
  
  @Test (priority = 3, dependsOnMethods = "editUser")
  public void deleteUser() {
	  System.out.println("I'm in home test");
	  System.out.println("Before assertion");
	  softAssert.assertTrue(2>3, "Verifying Element1");
	  System.out.println("After assertion");
	  softAssert.assertEquals("abc", "abc1");
	  System.out.println("After Second assertion");
	  softAssert.assertAll();
  }
  
}
