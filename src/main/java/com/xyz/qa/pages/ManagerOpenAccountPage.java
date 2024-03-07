package com.xyz.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.xyz.qa.base.TestBase;

public class ManagerOpenAccountPage extends TestBase {

    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement bankManagerLoginButton;

    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccountButton;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerNameDropdown;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;

    public ManagerOpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public void BankManagerLogin() {
        bankManagerLoginButton.click();
    }

    public void openAccount() {
        openAccountButton.click();
    }

    public void selectCustomerName(String customerName) {
        Select customerDropdown = new Select(customerNameDropdown);
        customerDropdown.selectByVisibleText(customerName);
    }

    public void selectCurrency(String currency) {
        Select currencyDropdownSelect = new Select(currencyDropdown);
        currencyDropdownSelect.selectByVisibleText(currency);
    }

    public void clickProcessButton() {
        processButton.click();
    }

    public String getAlertMessageText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
    
    public String getWarningMessage() {
        return "Please select an item in the list.";
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
