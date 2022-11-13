package org.espn.configuration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.PageFactory.initElements;
import java.time.Duration;
import java.util.List;

public class WebOperations {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        initElements(driver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void clickElement(WebElement element) {
        this.waitForClickable(element);
        element.click();
    }

    public void waitForClickable(WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void typeOnInput(WebElement element, String text) {
        this.waitForVisibility(element);
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(List<WebElement> elements) {
        this.wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public boolean waitForReload(WebElement element) {
        boolean wasDeleted = true;
        try {
            this.wait.until(ExpectedConditions.stalenessOf(element));
        } catch (TimeoutException e) {
            wasDeleted = false;
        }
        return wasDeleted;
    }

    public void mouseOver(WebElement element) {
        this.waitForVisibility(element);
        new Actions(getDriver()).moveToElement(element).perform();
    }
}
