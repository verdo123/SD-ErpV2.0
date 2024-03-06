package com.sqa;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sqa.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    private static WebDriver driver;

    public static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();

    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("User on login page")
    public void User_on_login_page(){
        driver.get("http://192.168.101.88:3033/login");
        extentTest.log(LogStatus.PASS,"User on login page");
    }

    @When("User input username")
    public void User_input_username(){
        loginPage.inputUsername("verdo@falahtech.co.id");
        extentTest.log(LogStatus.PASS,"User input username");
    }

    @And("User input password")
    public void User_input_password(){
        loginPage.inputPassword("Falah0918");
        extentTest.log(LogStatus.PASS,"User input password");
    }

    @And("User click button login")
    public void User_click_button_login(){
        loginPage.clickBtnLogin();
        extentTest.log(LogStatus.PASS,"User click button login");
    }

    @Then("User go to home page")
    public void User_go_to_home_page(){
        loginPage.getTxtHome();
        extentTest.log(LogStatus.PASS,"User go to home page");
    }




}
