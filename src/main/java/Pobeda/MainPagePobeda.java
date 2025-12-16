package Pobeda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPagePobeda {
    protected WebDriver driver;
    protected Actions actions;

    @FindBy(css = ".dp-1e99pvw-root")
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
}