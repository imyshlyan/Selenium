package Pobeda;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPagePobeda {
    protected WebDriver driver;
    protected Actions actions;

    @FindBy(css = ".dp-1vtz9qg-root")
    WebElement logo;

    @FindBy(css = "[href=\"/information\"]")
    WebElement information;


    public MainPagePobeda(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);

    }

    public String getTitleMainPage() {
        return driver.getTitle();
    }

    public void openInformation() {
        actions.moveToElement(information).pause(Duration.ofMillis(500)).perform();
    }

    public void logoAndTitleAssert(){
        Assertions.assertTrue(getTitleMainPage().contains("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками"));
        Assertions.assertTrue(logo.isDisplayed());
    }

}