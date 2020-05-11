package itvdn;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    @FindBy(css = ".search-result")
    List<WebElement> searchResultElements;


    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step
    public List<WebElement> getResults() {
        return searchResultElements;
    }
}
