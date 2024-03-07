package com.xyz.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.xyz.qa.base.TestBase;

public class CustomerAccountPage extends TestBase {

    // Page Factory - OR:
    @FindBy(xpath="//strong[@class='mainHeading']")
    WebElement headerName;

    @FindBy(xpath="//span[@class='fontBig ng-binding']")
    WebElement customerName;
    
    @FindBy(xpath="//div[@class='center'][1]")
    WebElement AccountDetails;
    
    @FindBy(xpath="//div[@class='center']/strong[2]")
    WebElement accountBalance;
    
    
    @FindBy(xpath="//button[normalize-space()='Transactions']")
    WebElement transcationclick;

    @FindBy(xpath="//button[normalize-space()='Deposit']")
    WebElement depositclick;
    
    @FindBy(xpath="//button[normalize-space()='Withdrawl']")
    WebElement withdrawlclick;

    public CustomerAccountPage(){
        PageFactory.initElements(driver, this);
    }

    public String getHeaderName() {
        return headerName.getText();
    }

    public String getCustomerName() {
        return customerName.getText();
    }
    
    public String getAccountDetails() {
        return AccountDetails.getText();
    }
    
    public String getTotalBalance() {
        return accountBalance.getText();
    }
    
    
    public TransactionPage clicktransactionButton(){
    	transcationclick.click();
    	return new TransactionPage();
    }
    
    public DepositPage clickDepositButton(){
    	depositclick.click();
    	return new DepositPage();
    }

    public WithdrawPage clickWithdrawButton(){
    	withdrawlclick.click();
    	return new WithdrawPage();
    }
}
