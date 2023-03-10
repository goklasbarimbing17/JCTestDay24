package com.juaracoding.cucumber.pages;

import com.juaracoding.cucumber.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {
    private WebDriver driver;
    private Actions act;

    public RecruitmentPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    WebElement btnRecruitment;
    @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
    WebElement btnAddCandidates;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    WebElement middleName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    WebElement vacancy;
    @FindBy(xpath = "//input[@type='file']")
    WebElement resume;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")
    WebElement email;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input")
    WebElement contactNumber;
    @FindBy(xpath = "//input[@placeholder='Enter comma seperated words...']")
    WebElement keywords;
    @FindBy(xpath = "//textarea[@placeholder='Type here']")
    WebElement notes;
    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']")
    WebElement dateOfApplication;
    @FindBy(xpath = "//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement consentData;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement btnSave;
    @FindBy(xpath = "//h6[normalize-space()='Application Stage']")
    WebElement txtAddCandidatePass;

    public void fullname(String firstName, String middleName, String lastName) {
        this.firstName.sendKeys(firstName);
        this.middleName.sendKeys(middleName);
        this.lastName.sendKeys(lastName);
    }

    public void setVacancy(){
        this.vacancy.click();
        act = new Actions(driver);
        act.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
    }

    public void setContactPerson(String email, String contactNumber){
        this.email.sendKeys(email);
        this.contactNumber.sendKeys(contactNumber);
    }
    public void setResume(String path){
        this.resume.sendKeys(path);
    }
    public void setKeywordsNotes(String keywords, String notes){
        this.keywords.sendKeys(keywords);
        this.notes.sendKeys(notes);
    }
    public void setDateOfApplication(String date){
        this.dateOfApplication.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
        this.dateOfApplication.sendKeys(date);
    }
    public void save(){
        this.consentData.click();
        this.btnSave.click();
    }
    public String getTextAddCandidatesPass(){
        return txtAddCandidatePass.getText();
    }
    public void btnRecruitment(){
        this.btnRecruitment.click();
    }
    public void btnAddCandidates(){
        this.btnAddCandidates.click();
    }
}
