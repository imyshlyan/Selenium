package Pobeda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class WindowInformation extends MainPagePobeda {

    @FindBy(css = "[href=\"/information#flight\"]")
    WebElement flightPreparation;

    @FindBy(css = "[href=\"/information#useful\"]")
    WebElement usefulInformation;

    @FindBy(css = "[href=\"/information#company\"]")
    WebElement companyInformation;

    public WindowInformation(WebDriver driver) {
        super(driver);
    }


}
