package FirstTestWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleTest {

    private final WebDriver webDriver = new ChromeDriver();
    //private final WebDriverWait webWait = new WebDriverWait(webDriver, Duration.of(3000, ChronoUnit.MILLIS));

    @BeforeTest
    public void beforeTest(){
        webDriver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(5000,
                TimeUnit.MILLISECONDS);
        webDriver.get("https://www.google.com");

    }

    @Test
    public void simpleTest(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        webDriver.findElement(By.id("L2AGLb")).click();
        webDriver.findElement(By.name("q")).sendKeys("acodemy.lv\n");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriver.manage().window().fullscreen();
        //webDriver.navigate().refresh();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


        List<WebElement> elements = webDriver.findElements(By.xpath("//h3[contains(@class, \"LC20lb\")]"));


        Assert.assertEquals(elements.size(), 16);
    }

    @AfterTest
    public void afterTest(){
    webDriver.close();
    webDriver.quit();
    }
}
