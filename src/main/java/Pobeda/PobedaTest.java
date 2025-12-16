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


    @BeforeEach
    public void openPobeda() {
        driver = new ChromeDriver();
        driver.get("https://pobeda.aero/");
        driver.manage().window().maximize();
        mainPobedaPage = new MainPagePobeda(driver);
        windowInformation = new WindowInformation(driver);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void popupWindow() {
        Assertions.assertTrue(mainPobedaPage.getTitleMainPage().contains("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками"));
        Assertions.assertTrue(mainPobedaPage.logo.isDisplayed());
        windowInformation.openInformation();
        Assertions.assertTrue(windowInformation.flightPreparation.isDisplayed());
        Assertions.assertTrue(windowInformation.usefulInformation.isDisplayed());
        Assertions.assertTrue(windowInformation.companyInformation.isDisplayed());
    }
}
