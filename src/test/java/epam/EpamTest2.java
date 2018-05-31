package epam;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EpamTest2 {

    private WebDriver driver;

    @Before
    public void before() {
        // System.setProperty("webdriver.chrome.driver", c);
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        driver.navigate().to(epam.HOME_PAGE_DATA.URL.value);
        work.initHP(this.driver);
        work.homePage.login(epam.HOME_PAGE_DATA.ID.value, epam.HOME_PAGE_DATA.PASSWORD.value);
    }

    @After
    public void after() {
        work.homePage.driver.close();
    }

    @Test
    public void test() {
        //checking if URL is correct
        Assert.assertEquals(work.homePage.driver.getCurrentUrl(), epam.HOME_PAGE_DATA.URL.value);
        //checking username
        Assert.assertEquals(work.homePage.profilePhoto.getAttribute("innerText"), " " + epam.HOME_PAGE_DATA.USERNAME.value);
        //checking title / index
        Assert.assertEquals(work.homePage.driver.getTitle(), epam.HOME_PAGE_DATA.LINKINDEX.value);
        //checking number of pictures
        Assert.assertEquals(work.homePage.images.size(), 4);
        //checking if all 4 pictures are dispayed
        // TODO loop required
        Assert.assertTrue(work.homePage.images.get(0).isDisplayed());
        Assert.assertTrue(work.homePage.images.get(1).isDisplayed());
        Assert.assertTrue(work.homePage.images.get(2).isDisplayed());
        Assert.assertTrue(work.homePage.images.get(3).isDisplayed());
        //checking number of texts
        Assert.assertEquals(work.homePage.images.size(), 4);
        //comparing all 4 texts
        // TODO loop required
        Assert.assertEquals(work.homePage.texts.get(0).getText(), epam.HOME_PAGE_DATA.FIRSTTEXT.value);
        Assert.assertEquals(work.homePage.texts.get(1).getText(), epam.HOME_PAGE_DATA.SECONDTEXT.value);
        Assert.assertEquals(work.homePage.texts.get(2).getText(), epam.HOME_PAGE_DATA.THIRDTEXT.value);
        Assert.assertEquals(work.homePage.texts.get(3).getText(), epam.HOME_PAGE_DATA.FOURTHTEXT.value);
        //checking header and the weird long text
        Assert.assertEquals(work.homePage.mainText.getText(), epam.HOME_PAGE_DATA.WEIRD.value);
        Assert.assertEquals(work.homePage.mainTitle.getText(), epam.HOME_PAGE_DATA.FRAMEWORK.value);


    }

}