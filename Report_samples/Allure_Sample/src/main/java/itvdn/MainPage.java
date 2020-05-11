package itvdn;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(css = "#search-on-top")
    WebElement searchElement;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Эта аннотация добавляет шаг в отчет
    @Step
    public void search(final String query) {
        searchElement.click();
        searchElement.sendKeys(query);
        searchElement.sendKeys(Keys.ENTER);
    }
}
