package com.xyz.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class ManagerCustomersPage extends TestBase {

    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement bankManagerLoginButton;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customersButton;
    
    @FindBy(xpath = "//thead/tr[1]/td[1]/a[1]")
    WebElement fsortClick;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchCustomerInput;

    @FindBy(xpath = "//td[normalize-space()='Neville']")
    WebElement firstName;

    @FindBy(xpath = "//td[normalize-space()='Longbottom']")
    WebElement lastName;

    @FindBy(xpath = "//td[normalize-space()='E89898']")
    WebElement postCode;

    @FindBy(xpath = "//tbody//td[4]")
    WebElement accountNumber;

    @FindBy(xpath = "//button[normalize-space()='Delete']")
    WebElement deleteButton;

    public ManagerCustomersPage() {
        PageFactory.initElements(driver, this);
    }

    public void BankManagerLogin() {
        bankManagerLoginButton.click();
    }

    public void clickCustomers() {
        customersButton.click();
    }
    
    public void clickFirstName() {
    	fsortClick.click();
    }

    public void searchCustomer(String customerName) {
        searchCustomerInput.sendKeys(customerName);
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getPostCode() {
        return postCode.getText();
    }

    public String getAccountNumber() {
        return accountNumber.getText();
    }

    public void clickDelete() {
        deleteButton.click();
        // Handle alert
        
    }
}
