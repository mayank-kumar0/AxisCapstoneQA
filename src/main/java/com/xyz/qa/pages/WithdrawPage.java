package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xyz.qa.base.TestBase;

public class WithdrawPage extends TestBase {

    // Page Factory - OR:
    @FindBy(xpath="//input[@placeholder='amount']")
    WebElement withdrawAmountInput;
    
    @FindBy(xpath="//button[normalize-space()='Withdraw']")
    WebElement withdrawButton;
    
    @FindBy(xpath="//span[@class='error ng-binding']")
    WebElement withdrawStatusMessage;
    
    @FindBy(xpath="//button[normalize-space()='Transactions']")
    WebElement transcationclick;
    
    @FindBy(xpath="//td[normalize-space()='100']")
    WebElement lastTransactionAmount;

    public WithdrawPage(){
        PageFactory.initElements(driver, this);
    }
    
    public void enterWithdrawAmount(String amount) {
    	
    	 withdrawAmountInput.clear(); // Clear the input field 
        withdrawAmountInput.sendKeys(amount);
        
    }
    
    public void WithdrawButton() {
        withdrawButton.click();
    }
    
    public String getWithdrawStatusMessage() {
        return withdrawStatusMessage.getText();
    }
    
    public void clickTransaction() {
    	transcationclick.click();
    }
    public String getLastTransactionAmount() {
        return lastTransactionAmount.getText();
    }
}
