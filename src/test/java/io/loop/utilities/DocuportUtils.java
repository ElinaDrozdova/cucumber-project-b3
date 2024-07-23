//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package io.loop.utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocuportUtils {
    public DocuportUtils() {
    }

    public static void login(WebDriver driver, String role) throws InterruptedException {
        driver.get("https://beta.docuport.app/");
        WebElement username = driver.findElement(By.xpath("//label[.='Username or email']/following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        switch (role.toLowerCase()) {
            case "client":
                username.sendKeys(new CharSequence[]{"b1g1_client@gmail.com"});
                password.sendKeys(new CharSequence[]{"Group1"});
                break;
            case "supervisor":
                username.sendKeys(new CharSequence[]{"b1g1_supervisor@gmail.com"});
                password.sendKeys(new CharSequence[]{"Group1"});
                break;
            case "advisor":
                username.sendKeys(new CharSequence[]{"b1g1_advisor@gmail.com"});
                password.sendKeys(new CharSequence[]{"Group1"});
                break;
            case "employee":
                username.sendKeys(new CharSequence[]{"b1g1_employee@gmail.com"});
                password.sendKeys(new CharSequence[]{"Group1"});
                break;
            default:
                throw new InterruptedException("There is not such a role: " + role);
        }

        loginButton.click();
        if (role.toLowerCase().equals("client")) {
            Thread.sleep(3000L);
            WebElement cont = driver.findElement(By.xpath("//button[@type='submit']"));
            cont.click();
            Thread.sleep(3000L);
        }

    }

    public static void logOut(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
    }
}
