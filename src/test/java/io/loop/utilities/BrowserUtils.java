//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package io.loop.utilities;

import io.cucumber.java.Scenario;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
    public static Scenario myScenario;

    public BrowserUtils() {
    }

    public static void takeScreenshot() {
        try {
            myScenario.log("Current url is: " + Driver.getDriver().getCurrentUrl());
            byte[] screenshot = (byte[])((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot, "image/png", myScenario.getName());
        } catch (WebDriverException var1) {
            WebDriverException wbd = var1;
            wbd.getMessage();
        } catch (ClassCastException var2) {
            ClassCastException cce = var2;
            cce.getMessage();
        }

    }

    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator var4 = windowHandles.iterator();

        while(var4.hasNext()) {
            String each = (String)var4.next();
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }

       Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        Iterator var3 = driver.getWindowHandles().iterator();

        do {
            if (!var3.hasNext()) {
                driver.switchTo().window(origin);
                return;
            }

            String handle = (String)var3.next();
            driver.switchTo().window(handle);
        } while(!driver.getTitle().contains(targetTitle));

    }

    public static void validateTitle(WebDriver driver, String expectedTitle) {
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

    public static void loopLinkClick(String nameOfPage) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfPage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10L));
        ((WebElement)wait.until(ExpectedConditions.elementToBeClickable(element))).click();
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", new Object[]{element});
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", new Object[]{element});
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();", new Object[]{element});
    }

    public static void doubleClick(WebElement element) {
        (new Actions(Driver.getDriver())).doubleClick(element).perform();
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds((long)timeToWaitInSec));
        return (WebElement)wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForInVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds((long)timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds((long)timeout));
        return (WebElement)wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void justWait(int seconds) {
        try {
            Thread.sleep((long)seconds);
        } catch (InterruptedException var2) {
            InterruptedException e = var2;
            e.printStackTrace();
        }

    }
}
