package org.espn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WatchPage extends BasePage {

    @FindBy (css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li")
    private List<WebElement> cardsInCarousel;

    @FindBy (css = "h2.WatchTile__Title")
    private List<WebElement> cardTitle;

    @FindBy (css = ".WatchTile__Meta")
    private List<WebElement> streamingSourceDescription;

    @FindBy (css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCardInCarousel;

    @FindBy (css = "section.lightbox__contentBox")
    private WebElement providerModal;

    @FindBy (css = ".lightbox__closebtn")
    private WebElement closeButtonModal;

    @FindBy (css = ".CarouselArrow--right")
    private WebElement carouselArrow;

    @FindBy (css = "a[href='/watch/collections/40653/tenis/_/redirected/true']:last-child")
    private WebElement seeAll;

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkAllCardsTitle() {
        List<Boolean> isTitle = new ArrayList<>();
        waitForPresenceOfElements("div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li");
        cardsInCarousel.stream().forEach(element -> {
            isTitle.add(element.findElement(By.cssSelector("h2.WatchTile__Title")).isEnabled());
        });
        return !isTitle.contains(false);
    }

    public boolean checkAllCardsDescription() {
        List<Boolean> isDescription = new ArrayList<>();
        waitForPresenceOfElements("div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li");
        cardsInCarousel.stream().forEach(element -> {
            isDescription.add(element.findElement(By.cssSelector(".WatchTile__Meta")).isEnabled());
        });
        return !isDescription.contains(false);
    }

    public void clickCard() {
        super.waitForVisibility(this.secondCardInCarousel);
        super.clickElement(this.secondCardInCarousel);
    }

    public boolean closeButtonModalIsDisplayed() {
        super.waitForVisibility(this.closeButtonModal);
        return this.closeButtonModal.isDisplayed();
    }

    public void clickOnCloseButtonModal() {
        super.clickElement(this.closeButtonModal);
    }

    public HomePage returnToHomePage() {
        super.getDriver().navigate().back();
        return new HomePage(getDriver());
    }
}
