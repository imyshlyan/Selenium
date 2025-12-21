package Pobeda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchTicket extends MainPagePobeda{

    @FindBy(xpath = "//*[@class=\"dp-zohsg-root\"]//*[@placeholder=\"Откуда\"]")
    WebElement fromWhere;
    @FindBy(xpath = "//*[@class=\"dp-zohsg-root\"]//*[@placeholder=\"Куда\"]")
    WebElement toWhere;
    @FindBy(xpath = "//*[@class=\"dp-zohsg-root\"]//*[@placeholder=\"Туда\"]")
    WebElement departing;
    @FindBy(xpath = "//*[@class=\"dp-zohsg-root\"]//*[@placeholder=\"Обратно\"]")
    WebElement returing;
    @FindBy(xpath = "//*[@class=\"dp-zohsg-root\"]//*[@placeholder=\"Клиенты\"]")
    WebElement customer;
    @FindBy(xpath = "//*[text()[ .= \"Поиск\"]]")
    WebElement searchButton;

    @FindBy(xpath = "//*[@class=\"dp-zohsg-root\"]//*[@placeholder=\"Куда\"]/ancestor::div[@data-failed=\"true\"]")
    WebElement toWhereRedFrame;
    @FindBy(xpath = "//*[@class=\"dp-zohsg-root\"]//*[@placeholder=\"Туда\"]/ancestor::div[@data-failed=\"true\"]")
    WebElement departingRedFrame;

    public SearchTicket(WebDriver driver) {
        super(driver);
    }
    public void startSearching (){
        searchButton.click();
    }
}
