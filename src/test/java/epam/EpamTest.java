package epam;

import org.junit.*;
import org.openqa.selenium.By;

// TODO this code do not match with code convention !
// TODO The idea is that wou should create only ONE test with certain scenario !
// TODO waht is the reason why you have 5 tests ? I dont get it...

// TODO you should leave a comment with each manual step, otherwise thats a bit difficult to compare...
public class EpamTest {

    @Before
    public void init() {
        work.init(texts.link.value);
    }

    @Test // 1
    public void siteOpened() {
        Assert.assertEquals(work.driver.getCurrentUrl(), texts.link.value);
    }

    @Test // 2
    public void checkIndex() {
        Assert.assertEquals(work.driver.getTitle(), texts.linkIndex.value);
    }

    @Test // 3
    public void userInput() {

        work.logIn(texts.ID.value, texts.password.value);//xpath
        //work.LogIn2(texts.ID.value,texts.password.value);//css

        // TODO do you have a chance to read IDEA warning ? #1
        Assert.assertTrue(work.driver.findElements(By.xpath("//li/a/div/span")).size() == 1);
        Assert.assertEquals(texts.userName.value, work.driver.findElement(By.xpath("//li/a/div/span")).getText());
    }

    @Test // 4
    public void PageObject() { // <- code convention !

        // TODO #2
        Assert.assertTrue(work.driver.findElements(By.xpath("//div[@class='col-sm-3']")).size() == 4);
        Assert.assertTrue(work.driver.findElements(By.xpath("//span[@class='benefit-txt']")).size() == 4);

        Assert.assertEquals(texts.first.value, work.driver.findElement(By.xpath("//span[text()='To include good practices']")).getText());
        Assert.assertEquals(texts.second.value, work.driver.findElement(By.xpath("//span[text()='To be flexible and']")).getText());
        Assert.assertEquals(texts.third.value, work.driver.findElement(By.xpath("//span[text()='To be multiplatform ']")).getText());
        Assert.assertEquals(texts.fourth.value, work.driver.findElement(By.xpath("//span[text()='Already have good base']")).getText());

      //  Assert.assertEquals(true,work.driver.findElement(By.cssSelector("To include good practices")));
    }

    @Test // 5
    public void Header() { // <- code convention !
        Assert.assertEquals(texts.framework.value, work.driver.findElement(By.xpath("//h3")).getText());
        Assert.assertEquals(texts.weird.value, work.driver.findElement(By.xpath("//p[@class='main-txt text-center']")).getText());
    }

    @After
    public void CloseBrowser() { // <- code convention !
        work.driver.quit();
    }
}