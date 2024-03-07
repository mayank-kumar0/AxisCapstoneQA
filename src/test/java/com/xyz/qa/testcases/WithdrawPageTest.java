package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerAccountPage;
import com.xyz.qa.pages.WithdrawPage;
import com.xyz.qa.pages.LoginPage;
import com.xyz.qa.pages.DepositPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WithdrawPageTest extends TestBase {
    LoginPage loginPage;
    CustomerAccountPage accountPage;
    WithdrawPage withdrawPage;
    DepositPage depositPage;
    
    

    public WithdrawPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage(); 
        accountPage = loginPage.loginAsCustomer("Hermoine Granger"); 
    }

    @Test
    public void withdrawAmount() {
    	String TotalAmount = accountPage.getTotalBalance();
        int totalAmt = Integer.parseInt(TotalAmount);
    	
    	String [] withdrawalAmt = {"100", "1000", "10000", "-100"};
    	
    	for(int i = 0; i < withdrawalAmt.length; i++) {
    		// Withdraw 
            withdrawPage = accountPage.clickWithdrawButton();
            withdrawPage.enterWithdrawAmount(withdrawalAmt[i]); 
            withdrawPage.WithdrawButton();
            
            String withdrawStatusMessage;
            if (withdrawalAmt[i].startsWith("-")) {
                // Print message for invalid amount
                System.out.println("Please enter a valid amount. Amount should be greater than 0");
            }
            
            else if (Integer.parseInt(withdrawalAmt[i]) < totalAmt) {
            	withdrawStatusMessage = withdrawPage.getWithdrawStatusMessage();
                Assert.assertEquals(withdrawStatusMessage, "Transaction successful");
            } 
            
            else {
            	withdrawStatusMessage = withdrawPage.getWithdrawStatusMessage();
                Assert.assertEquals(withdrawStatusMessage, "Transaction Failed. You can not withdraw amount more than the balance.");
            }
        }
        // verify and validate available balance after withdrawal attempts
        String currentAmount = accountPage.getTotalBalance();
        Assert.assertEquals(currentAmount, "3996");
        System.out.println("Available Balance is " + currentAmount);
    }

//    @AfterMethod
//    public void tearDown() {
//    	driver.quit();
//    }
}