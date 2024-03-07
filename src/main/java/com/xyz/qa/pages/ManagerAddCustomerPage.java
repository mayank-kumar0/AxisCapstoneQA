package com.xyz.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class ManagerAddCustomerPage extends TestBase {
	
	@FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement BankManagerLoginButton;
	
	@FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement customerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCodeInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerButton;

    public ManagerAddCustomerPage() {
        PageFactory.initElements(driver, this);
    }
    public void BankManagerLogin() {
    	BankManagerLoginButton.click();
    }
    public void addCustomer() {
    	customerButton.click();
    }
    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterPostCode(String postCode) {
        postCodeInput.sendKeys(postCode);
    }

    public void clickAddCustomerButton() {
        addCustomerButton.click();
    }

    public String getAlertMessageText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
