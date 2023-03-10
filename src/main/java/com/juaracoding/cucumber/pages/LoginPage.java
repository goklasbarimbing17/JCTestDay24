package com.juaracoding.cucumber.pages;

import com.juaracoding.cucumber.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Username']")
    @CacheLookup
    WebElement username;
    @FindBy(xpath = "//input[@placeholder='Password']")
    @CacheLookup
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement txtDashboard;
    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
    WebElement loginTitle;
    @FindBy(xpath = "//div[@role='alert']")
    WebElement txtInvalidCredential;
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement txtRequired;
    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement menuLogout;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement btnLogout;

    public String getMessageRequired(){
        return txtRequired.getAttribute("Required");
    }
    public String getInvalidCredential(){
        return txtInvalidCredential.getText();
    }

    public String getLoginTitle(){
        return loginTitle.getText();
    }

    public String getTextDashboard(){
        return txtDashboard.getText();
    }
    public void setUsername(String username){
        this.username.clear();
        this.username.sendKeys(username);
    }
    public void setPassword(String password){
        this.password.sendKeys(password);
    }
    public void clickLogin(){
        this.btnLogin.click();
    }
    public void logout(){
        this.menuLogout.click();
        this.btnLogout.click();
    }
}
