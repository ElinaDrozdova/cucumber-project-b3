package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.WikipediaPage;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;

import static org.junit.Assert.assertEquals;

public class WikipediaStepDefs {
    WikipediaPage wikipediaPage = new WikipediaPage();
    String actual;

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("wikipedia"));
    }
    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        WikipediaPage.searchBox.sendKeys("Steve Jobs");
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        WikipediaPage.searchButton.click();
    }
    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
        actual = Driver.getDriver().getTitle();
        assertEquals("Steve Jobs - Wikipedia", actual);
    }
    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String string) {
        actual = wikipediaPage.firstHeading.getText();
        assertEquals("Steve Jobs", actual);
    }
    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String string) {
        actual = wikipediaPage.imageHeader.getText();
        assertEquals("Steve Jobs", actual);
    }
}
