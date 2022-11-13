package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WatchPage extends BasePage {

    @FindBy (css = "section.Carousel")
    private List<WebElement> carousels;

    @FindBy (css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCardInCarousel;

    @FindBy (css = "section.lightbox__contentBox")
    private WebElement providerModal;

    @FindBy (css = "svg.icon--color")
    private WebElement closeButtonModal;

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    public boolean carouselIsDisplayed() {
        super.waitForVisibility(this.carousels);
        return this.carousels.size() > 0;
    }

    public void clickCard() {
        super.waitForVisibility(this.secondCardInCarousel);
        super.clickElement(this.secondCardInCarousel);
    }

    public boolean switchToModal() {
        boolean closeButtonModalIsDisplayed = false;
        super.waitForVisibility(this.providerModal);

        String mainWindow = super.getDriver().getWindowHandle();
        Set<String> windowHandles = super.getDriver().getWindowHandles();
        Iterator<String> i1 = windowHandles.iterator();

        while(i1.hasNext()) {
            String childWindow = i1.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)) {
                super.getDriver().switchTo().window(childWindow);
                closeButtonModalIsDisplayed = closeButtonModalIsDisplayed();
                super.clickElement(this.closeButtonModal);
            }
        }
        super.getDriver().switchTo().window(mainWindow);
        return closeButtonModalIsDisplayed;
    }

    public boolean closeButtonModalIsDisplayed() {
        super.waitForVisibility(this.closeButtonModal);
        return this.closeButtonModal.isDisplayed();
    }

    public HomePage returnToHomePage() {
        super.getDriver().navigate().back();
        return new HomePage(getDriver());
    }
}
