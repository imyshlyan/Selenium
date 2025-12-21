package Pobeda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PobedaTest {

    WebDriver driver;
    MainPagePobeda mainPobedaPage;
    WindowInformation windowInformation;
    SearchTicket searchTicket;


    @BeforeEach
    public void openPobeda() {
        driver = new ChromeDriver();
        driver.get("https://pobeda.aero/");
        driver.manage().window().maximize();
        mainPobedaPage = new MainPagePobeda(driver);
        windowInformation = new WindowInformation(driver);
        searchTicket = new SearchTicket(driver);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void popupWindow() {
        mainPobedaPage.logoAndTitleAssert();
        mainPobedaPage.openInformation();
        Assertions.assertTrue(windowInformation.flightPreparation.isDisplayed());
        Assertions.assertTrue(windowInformation.usefulInformation.isDisplayed());
        Assertions.assertTrue(windowInformation.companyInformation.isDisplayed());
    }

    @Test
    public void InitiatingSearching() {
        mainPobedaPage.logoAndTitleAssert();
        Assertions.assertTrue(searchTicket.fromWhere.isDisplayed());
        Assertions.assertTrue(searchTicket.toWhere.isDisplayed());
        Assertions.assertTrue(searchTicket.departing.isDisplayed());
        Assertions.assertTrue(searchTicket.returing.isDisplayed());
        searchTicket.fromWhere.clear();
        searchTicket.fromWhere.sendKeys("Москва");
        searchTicket.toWhere.sendKeys("Санкт-Петербург");
        searchTicket.startSearching();
        Assertions.assertTrue(searchTicket.departingRedFrame.isDisplayed());
    }
}
