package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearLoginPage extends SmartBearBasePage{


    public SmartBearLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath="//*[@name = 'ctl00$MainContent$username']")
    public static WebElement usernameInput;
    @FindBy(xpath = "//*[@name = 'ctl00$MainContent$password']")
    public WebElement passwordInput;
    @FindBy(xpath = "//*[@name = 'ctl00$MainContent$login_button']")
    public WebElement loginButton;
    @FindBy(linkText="Order")
    public WebElement orderButton;

    public void loginSmartBear(){

        Driver.getDriver().get(ConfigurationReader.getProperties("smart.bear"));
        BrowserUtils.waitForVisibility(usernameInput, 10);
        usernameInput.sendKeys(ConfigurationReader.getProperties("smart.username"));
        passwordInput.sendKeys(ConfigurationReader.getProperties("smart.password"));
        loginButton.click();
        orderButton.click();
    }

}
