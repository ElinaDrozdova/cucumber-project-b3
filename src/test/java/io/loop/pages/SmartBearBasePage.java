package io.loop.pages;

import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearBasePage {
    public SmartBearBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath="//h2[contains(., 'List of All Orders')]//following-sibling::div//td[2]")
    public WebElement rows;
    @FindBy(xpath="/strong[contains(text(), 'New order has been successfully added.')]")
    public WebElement doneMessage;

//    @FindBy(xpath="//a[.= 'Order']")
//    public WebElement order;
//    public void orderPage(){
//        order.click();
//    }

//    @FindBy(xpath = "//a[@href= 'Products.aspx']")
//    public WebElement viewAllProducts;
//    @FindBy(xpath = "//a[@href= 'Process.aspx']")
//    public WebElement orderButton;


   /* */
}
