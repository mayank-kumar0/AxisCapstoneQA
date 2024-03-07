package com.xyz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import com.xyz.qa.base.TestBase;
public class LoginPage extends TestBase {

	
	//Page Factory - OR:
			@FindBy(xpath="//button[normalize-space()='Customer Login']")
			WebElement customerLoginBtn;
			
			@FindBy(xpath="//select[@id='userSelect']")
			WebElement namedropdown;
			

            @FindBy(xpath="//button[normalize-space()='Login']")
            WebElement loginButton;  
            
            @FindBy(xpath="//button[normalize-space()='Logout']")
            WebElement logoutButton;
          
            
            
            public LoginPage(){
    			PageFactory.initElements(driver, this); // Initializing elements using PageFactory
    		}
            
            public void customerLogin(){
                customerLoginBtn.click(); // Clicking on the Customer Login button
            
            }
            public String loginPageTitle() {
            	return driver.getTitle(); // Returning the title of the page
            }
            
            
            //Selects a customer from the dropdown list.
            //customerName The name of the customer to be selected.
            
            
            public void selectCustomer(String customerName){
                Select select = new Select(namedropdown); // Creating Select object for dropdown
                select.selectByVisibleText(customerName); // Selecting customer by visible text
                
            }
            
            //Clicks on the login button.
            
            public void clickLoginButton(){
            	loginButton.click(); // Clicking on the Login button
            }
            
            //Logs in as a customer with the provided name.
            //customerName The name of the customer to log in as.
            //CustomerAccountPage object representing the account page after login.
   
            
            public CustomerAccountPage loginAsCustomer(String customerName) {
                customerLogin(); // Performing customer login action
                selectCustomer(customerName); // Selecting customer
                clickLoginButton(); // Clicking on Login button
                return new CustomerAccountPage(); // Returning CustomerAccountPage object
            }
}