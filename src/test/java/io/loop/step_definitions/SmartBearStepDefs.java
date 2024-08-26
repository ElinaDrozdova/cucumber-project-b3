package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.SmartBearBasePage;
import io.loop.pages.SmartBearLoginPage;

import io.loop.pages.SmartBearOrderPage;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class SmartBearStepDefs {
SmartBearBasePage smartBearBasePage = new SmartBearBasePage();
SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage();
    SmartBearOrderPage smartBearOrderPage = new SmartBearOrderPage();



    @Given("user is already logged in and navigated to order page")
    public void user_is_already_logged_in_and_navigated_to_order_page() {
        smartBearLoginPage.loginSmartBear();

    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String product) {
smartBearOrderPage.chooseOption2.click();
    }
    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer int1) {
smartBearOrderPage.quantityField.sendKeys(int1.toString());

    }
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String customerName) {
smartBearOrderPage.customerName.sendKeys(customerName);

    }
    @When("user enters street {string}")
    public void user_enters_street(String street) {
        smartBearOrderPage.street.sendKeys(street);

    }
    @When("user enters city {string}")
    public void user_enters_city(String city) {
        smartBearOrderPage.city.sendKeys(city);


    }
    @When("user enters state {string}")
    public void user_enters_state(String state) {
        smartBearOrderPage.state.sendKeys(state);

    }
    @When("user enters zip {string}")
    public void user_enters_zip(String zip) {
        smartBearOrderPage.zip.sendKeys(zip);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String string) {
        smartBearOrderPage.americanExpress.click();

    }
    @When("user enters credit car number {string}")
    public void user_enters_credit_car_number(String cardNb) {
        smartBearOrderPage.cardNr.sendKeys(cardNb);
    }
    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String string) {
        smartBearOrderPage.expireDate.sendKeys(string);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        smartBearOrderPage.processButton.click();

    }
    @Then("user should see {string} in the first row of the table")
    public void user_should_see_in_the_first_row_of_the_table(String nameOrder) {
BrowserUtils.waitForVisibility(smartBearOrderPage.successMessage, 10);
        Assert.assertTrue(smartBearOrderPage.successMessage.getText().contains(nameOrder));
    }

}