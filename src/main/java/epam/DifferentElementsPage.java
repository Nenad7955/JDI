package epam;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage {

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/div[4]/select/option[4]")
    SelenideElement yellow;

    @FindBy(css = ".profile-photo")
    SelenideElement profilePhoto;

    @FindBy(css = "#Login")
    SelenideElement login;

    @FindBy(css = "#Password")
    SelenideElement password;

    @FindBy(css = "form .btn-login")
    SelenideElement submit;

    @FindBy(css = ".icons-benefit")
    ElementsCollection images;

    @FindBy(css = ".benefit-txt")
    ElementsCollection texts;

    @FindBy(css = "li.sub-menu")
    SelenideElement subServices;

    @FindBy(css = "li.dropdown")
    SelenideElement hdrServices;


    @FindBy(css = ".label-checkbox")
    ElementsCollection checkbox;

    @FindBy(css = ".label-radio")
    ElementsCollection radiobox;

    @FindBy(css = "div.colors")
    ElementsCollection colors;

    @FindBy(css = "ul.panel-body-list.logs")
    ElementsCollection logs;

    @FindBy(css = "uui-button")
    ElementsCollection buttons;

    @FindBy(css = ".dropdown-menu | [href=\"page8.htm\"]")
    SelenideElement differentElementPageButton;

    @FindBy(css = ".ui-slider-handle")
    ElementsCollection sliders;

    @FindBy(css = ".dropdown-menu | [href=\"page4.htm\"]")
    SelenideElement datesPageButton;

    public DifferentElementsPage() {
        Selenide.page(this);
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
    }

}
