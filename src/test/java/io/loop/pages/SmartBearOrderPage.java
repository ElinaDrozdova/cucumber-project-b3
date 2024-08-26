package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;




public class SmartBearOrderPage extends SmartBearBasePage {
    public SmartBearOrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement productField;
    @FindBy(xpath = "//select[@name='ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement allProductOptions;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']/option[2]")
    public WebElement chooseOption2;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
    public WebElement quantityField;
    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']")
    public WebElement pricePerUnitField;
    @FindBy(xpath = "//*[@value='Calculate']")
    public WebElement calculateButton;
    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtName']")
    public WebElement customerName;
    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox2']")
    public WebElement street;
    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox3']")
    public WebElement city;
    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox4']")
    public WebElement state;
    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox5']")
    public WebElement zip;
    @FindBy(id = "ct100_MainContent_fmwOrder_cardList_0")
    public WebElement visaRadioButton;

    @FindBy (xpath = "//*[@id='ctl00_MainContent_fmwOrder_cardList_2']")

    public WebElement americanExpress;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox6']")
    public WebElement cardNr;
    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox1']")
    public WebElement expireDate;
    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_InsertButton']")
    public WebElement processButton;
    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder']/tbody/tr/td/div/strong")
    public WebElement successMessage;

    @FindBy(xpath = "//a[.='View all orders']")
    public WebElement viewAllOrders;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_orderGrid']//tr[2]//td[2]")
    public WebElement firstRowOfTable;

}


