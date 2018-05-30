package epam;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage {

    public WebDriver driver;


    @FindBy(css = ".profile-photo")
    WebElement profilePhoto;

    @FindBy(css = "#Login")
    WebElement loginField;

    @FindBy(css = "#Password")
    WebElement passwordField;

    @FindBy(css = "form .btn-login")
    WebElement submit;

    @FindBy(css = ".icons-benefit")
    List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    List<WebElement> texts;

    @FindBy(css = ".main-title")
    WebElement mainTitle;

    @FindBy(css = ".main-txt")
    WebElement mainText;

    /* ******************************************************************************************** */

    @FindBy(css = "li.dropdown")
    WebElement hdrServices;

    @FindBy(css = "ul.dropdown-menu")
    WebElement hdrServices2;

    @FindBy(css = "ul.sub")
    WebElement subMenu;

    @FindBy(css = "li.sub-menu")
    WebElement subServices;

    @FindBy(css = "label")
    ElementsCollection checkbox;

    @FindBy(css = "label-radio")
    ElementsCollection radiobox;

    @FindBy(css = "div.colors")
    ElementsCollection colors;

    @FindBy(css = "ul.panel-body-list.logs")
    ElementsCollection logs;

    @FindBy(css = "uui-button")
    ElementsCollection buttons;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }


    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.click();
    }
}
