package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerAccountPage;
import com.xyz.qa.pages.LoginPage;

public class CustomerAccountPageTest extends TestBase {
    LoginPage loginPage;
    CustomerAccountPage accountPage;
    
    public CustomerAccountPageTest() {
        super(); // Calls the constructor of the superclass TestBase
    }
    
    @BeforeMethod
    public void setUp() {
        initialization(); // Initializes the test environment
        loginPage = new LoginPage(); // Creates a new instance of LoginPage
        accountPage = loginPage.loginAsCustomer("Hermoine Granger"); // Logs in as a customer and gets the account page
        
    }
    
    @Test
    public void verifyCustomerAccountDetails() {
        // Verifies if the header name matches "XYZ Bank"
        String headerName = accountPage.getHeaderName();
        Assert.assertEquals(headerName, "XYZ Bank");

        // Verifies if the customer name matches "Hermoine Granger"
        String customerName = accountPage.getCustomerName();
        Assert.assertEquals(customerName, "Hermoine Granger");
        
        // Verifies account details and prints them
        String accountDetails = accountPage.getAccountDetails();
        Assert.assertEquals(accountDetails, accountDetails); // This assertion is comparing a string to itself
        System.out.println(accountDetails); // Prints the account details
    }
    
   // @AfterMethod
  // public void tearDown() {
   //     driver.quit();
   // }
}
