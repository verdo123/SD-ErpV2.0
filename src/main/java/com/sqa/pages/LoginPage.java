package com.sqa.pages;

import com.sqa.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }


    //Locator find element
    @FindBy(xpath = "//input[@id='login_email']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='login_password']")
    private WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//h3[@title='Home']")
    private WebElement TxtHome;

    @FindBy(xpath = "//button[normalize-space()='Invalid Login. Try again.']")
    private WebElement TxtInvalid;

    @FindBy(xpath = "//span[@title='Benediktus Verdo Daviarta']//span[@title='Benediktus Verdo Daviarta']")
    private WebElement avatar;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    private WebElement btnLogout;

    public void formLogin(){
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        btnLogin.click();
    }

    public void inputUsername(String username){
        this.username.sendKeys(username);
    }

    public void inputPassword (String password){
        this.password.sendKeys(password);
    }

    public void clickBtnLogin(){
        btnLogin.click();
    }

    public String getTxtHome(){
        return TxtHome.getText();
    }


    public void formBtnLogout(){
        avatar.click();
        btnLogout.click();
    }

    public String getTxtInvalid(){
        return TxtInvalid.getText();
    }

}
