package epam;

import org.junit.*;
import org.openqa.selenium.By;


public class EpamTest {
    @Before
    public void before() {
        work.init(epam.HOME_PAGE_DATA.URL.value);
    }

    @Test
    public void test() {
        //check if correct URL
        Assert.assertEquals(work.driver.getCurrentUrl(), epam.HOME_PAGE_DATA.URL.value);
        //check if correct index
        Assert.assertEquals(work.driver.getTitle(), epam.HOME_PAGE_DATA.LINKINDEX.value);
        //logging in
        work.logIn(epam.HOME_PAGE_DATA.ID.value, epam.HOME_PAGE_DATA.PASSWORD.value);//using xpath
        //work.LogIn2(epam.HOME_PAGE_DATA.ID.value,epam.HOME_PAGE_DATA.password.value);//using css

        // TODO do you have a chance to read IDEA warning ? #1
        // on my idea i didn't get a warning?

        //checking user after logging in
        // TODO im pretty sure that you have warning here ! You have to use different Assertion method... #1
        Assert.assertTrue(work.driver.findElements(By.xpath("//li/a/div/span")).size() == 1);
        Assert.assertEquals(epam.HOME_PAGE_DATA.USERNAME.value, work.driver.findElement(By.xpath("//li/a/div/span")).getText());


        //checking number of pictures and texts
        // TODO #2
        Assert.assertTrue(work.driver.findElements(By.xpath("//div[@class='col-sm-3']")).size() == 4);
        // TODO #3
        Assert.assertTrue(work.driver.findElements(By.xpath("//span[@class='benefit-txt']")).size() == 4);

        //checking if all 4 texts match
        Assert.assertEquals(epam.HOME_PAGE_DATA.FIRSTTEXT.value, work.driver.findElement(By.xpath("//span[text()='To include good practices']")).getText());
        Assert.assertEquals(epam.HOME_PAGE_DATA.SECONDTEXT.value, work.driver.findElement(By.xpath("//span[text()='To be flexible and']")).getText());
        Assert.assertEquals(epam.HOME_PAGE_DATA.THIRDTEXT.value, work.driver.findElement(By.xpath("//span[text()='To be multiplatform ']")).getText());
        Assert.assertEquals(epam.HOME_PAGE_DATA.FOURTHTEXT.value, work.driver.findElement(By.xpath("//span[text()='Already have good base']")).getText());

        //checking for header text and the long weird one
        Assert.assertEquals(epam.HOME_PAGE_DATA.FRAMEWORK.value, work.driver.findElement(By.xpath("//h3")).getText());
        Assert.assertEquals(epam.HOME_PAGE_DATA.WEIRD.value, work.driver.findElement(By.xpath("//p[@class='main-txt text-center']")).getText());
    }

    @After
    public void CloseBrowser() { // <- code convention !
        work.driver.quit();
    }
}