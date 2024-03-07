package com.xyz.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class TransactionPage extends TestBase {

    @FindBy(xpath = "//input[@id='start']")
    WebElement startDateIcon;
    
    @FindBy(xpath = "//input[@id='end']")
    WebElement endDateIcon;
    
    @FindBy(xpath = "//body//div[@class='ng-scope']//div[@class='ng-scope']//div[2]")
    WebElement pagenextclick;
    
    @FindBy(xpath = "//button[@class='btn'][2]")
    WebElement resetClick;
    
    @FindBy(xpath = "//button[@class='btn'][1]")
    WebElement backClick;
    
    public TransactionPage(){
        PageFactory.initElements(driver, this);
    }

    
    public void setStartDate(String startDate) {
        startDateIcon.sendKeys(startDate);
    }
    
    public void setEndDate(String endDate) {
        endDateIcon.sendKeys(endDate);
    }
    
    public void pageNextClick() {
        pagenextclick.click();
    }
    
    public void resetClick() {
    	resetClick.click();
    }
    
    public void backClick() {
        backClick.click();
    }
}
