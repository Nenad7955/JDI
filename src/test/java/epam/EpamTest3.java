package epam;

import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;


public class EpamTest3 {

    static DifferentElementsPage dp;


    @Before
    public void before() {
        com.codeborne.selenide.Configuration.browser = "chrome";
        dp = new DifferentElementsPage();
    }

    @Test
    public void test() {

        //logging in
        dp.profilePhoto.click();
        // TODO what the point of PO in case if you use low-level operations ?
        // TODO login should be performed as business action on PO class !
        dp.login.sendKeys("epam");
        dp.password.sendKeys("1234");
        dp.submit.click();
        // !TODO
        //checking username
        dp.profilePhoto.shouldHave(text(epam.HOME_PAGE_DATA.USERNAME.value));

        //checking number of texts and pictures
        dp.images.shouldHave(size(4));
        dp.texts.shouldHave(size(4));

        dp.subServices.click();
        //checking service subcategory
        for (int i = 0; i < epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.optionsArray.length; i++)
            dp.subServices.shouldHave(text(epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.optionsArray[i]));

        dp.hdrServices.click();
        //checking service header
        for (int i = 0; i < epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.optionsArray.length; i++)
            dp.hdrServices.shouldHave(text(epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.optionsArray[i]));

        //opening Different Elements page and checking for existence of elements and comparing values

        dp.differentElementPageButton.click();

        dp.checkbox.shouldHave(size(4));
        dp.radiobox.shouldHave(size(4));
        dp.colors.shouldHave(size(1));

        for (int i = 0; i < epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.elementArray.length; i++)
            dp.checkbox.get(i).shouldHave(text(epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.elementArray[i]));

        for (int i = 0; i < epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.materialArray.length; i++)
            dp.radiobox.get(i).shouldHave(text(epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.materialArray[i]));

        for (int i = 0; i < epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.colorsArray.length; i++)
            dp.colors.get(0).shouldHave(text(epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.colorsArray[i]));


        //selecting Water, Wind, Selen and Yellow
        // TODO actually, PO should have a business action for this purpose...
        // TODO how can i realize that "water" presented via dp.checkbox.get(0) ?
        dp.checkbox.get(0).click();
        dp.checkbox.get(2).click();

        dp.radiobox.get(3).click();

        dp.yellow.click();

        //checking in logs
        for (int i = 0; i < epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.logsChecked.length; i++)
            dp.logs.get(0).shouldHave(text(epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.logsChecked[i]));

        //unselecting Water and Wind
        dp.checkbox.get(0).click();
        dp.checkbox.get(2).click();

        //checking in logs
        for (int i = 0; i < epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.logsUnchecked.length; i++)
            dp.logs.get(0).shouldHave(text(epam.DIFFERENT_ELEMENTS_PAGE.ACCCAT.logsUnchecked[i]));
    }
}