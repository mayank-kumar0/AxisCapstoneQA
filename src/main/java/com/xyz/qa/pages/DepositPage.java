package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.xyz.qa.base.TestBase;

public class DepositPage extends TestBase {

    // Page Factory - OR:
    @FindBy(xpath="//input[@placeholder='amount']")
    WebElement depositAmountInput;
    
    @FindBy(xpath="//button[@type='submit']")
    WebElement depositButton;
    
    @FindBy(xpath="//span[@class='error ng-binding']")
    WebElement depositStatusMessage;


    public DepositPage(){
        PageFactory.initElements(driver, this);
    }
    
    public void enterDepositAmount(String amount) {
        depositAmountInput.sendKeys(amount);
    }
    
    public void clickDepositButton() {
        depositButton.click();
    }
    
    public String getDepositStatusMessage() {
        return depositStatusMessage.getText();
    }
}
