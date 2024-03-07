package com.xyz.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerAccountPage;
import com.xyz.qa.pages.DepositPage;
import com.xyz.qa.pages.LoginPage;

public class DepositPageTest extends TestBase {
    LoginPage loginPage;
    CustomerAccountPage accountPage;
    DepositPage depositPage;
    
    public DepositPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage(); 
        accountPage = loginPage.loginAsCustomer("Hermoine Granger"); 
    }
    
    @Test
    public void depositAmountAndVerifyTransaction() {
        String[] amounts = {"1000", "200", "-200", "700", "-100"};
        
        for (String amount : amounts) {
            if (amount.startsWith("-")) {
                // Print message for invalid amount
                System.out.println("Please enter a valid amount. Amount should be greater than 0");
            } 
            else {
            	// Click on deposit button
                depositPage = accountPage.clickDepositButton();
                
                // Enter deposit amount
                driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
                depositPage.enterDepositAmount(amount);
                System.out.println("Amount " + amount + " is entered");
                
                // Click on deposit button
                depositPage.clickDepositButton();
                
                // Verify deposit status message for successful deposit
                String depositStatusMessage = depositPage.getDepositStatusMessage();
                Assert.assertEquals(depositStatusMessage, "Deposit Successful");
                System.out.println("Deposited Successfully");
            }
        }
        
        // Verify and validate Total Balance after deposit 
        String currentAmount = accountPage.getTotalBalance();
        Assert.assertEquals(currentAmount, "6996");
        System.out.println("Available Balance is " +currentAmount);
    }
//  @AfterMethod
//  public void tearDown() {
//      driver.quit();
//  }
}
