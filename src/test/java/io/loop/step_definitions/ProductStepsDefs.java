package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.loop.pages.ProductPage;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.DocuportConstants;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class ProductStepsDefs {
    private static final Logger LOG = LogManager.getLogger();
    ProductPage productPage = new ProductPage();

    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("product.url"));
        LOG.info("User is on Homepage");

    }

    @Then("User should be able to see expected prices in the following products")
    public void user_should_be_able_to_see_expected_prices_in_the_following_products(List<Map<String, String>> productDetails) {
        for (Map<String, String> productDetail : productDetails) {
//            System.out.println("========Product Details=========");
//            System.out.println("productDetail.get(\"Category\") = " + productDetail.get("Category"));
//            System.out.println("productDetail.get(\"Product\") = " + productDetail.get("Product"));
//            System.out.println("productDetail.get(\"expectedPrice\") = " + productDetail.get("expectedPrice"));
            BrowserUtils.justWait(DocuportConstants.small);
            // click the category
            productPage.clickCategory(productDetail.get("Category"));
            BrowserUtils.justWait(DocuportConstants.small);
            // get actual price
            String actualPrice = productPage.getProductPrice(productDetail.get("Product"));
            BrowserUtils.justWait(DocuportConstants.small);
            // get product price
            String expectedPrice = productDetail.get("expectedPrice");
            BrowserUtils.justWait(DocuportConstants.small);
            assertEquals("Expected does not match the actual", expectedPrice, actualPrice);
            LOG.info("Validation of the price");

        }
    }

    @Then("User should be able to see expected prices in following products with listOflist")
    public void user_should_be_able_to_see_expected_prices_in_following_products_with_list_oflist(List<List<String>> productDetails) {

        for (List<String> productDetail : productDetails) {
            // category
            productPage.clickCategory(productDetail.get(0));

            // get actual price
            String actualPrice = productPage.getProductPrice(productDetail.get(1));

            // get expected price
            String expectedPrice = productDetail.get(2);
            assertEquals("Expected does not match the actual", expectedPrice, actualPrice);
            LOG.info("Validation of the price for: " + productDetail.get(0) +", for Product: " + productDetail.get(1));
        }
    }
    @Then("User should be able to see the following names in their groups")
    public void user_should_be_able_to_see_the_following_names_in_their_groups(Map<String, List<String>> students) {
     List<String> group2 = students.get("Group2");
        System.out.println(group2);
        List<String> group3 = students.get("Group3");
        System.out.println(group3);
    }
}