package FirstTestWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;


public class SimpleTestWork {

    private final WebDriver webDriver = new ChromeDriver();


    @BeforeTest
    public void beforeTest() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        webDriver.get("https://www.google.com");
        webDriver.findElement(By.id("L2AGLb")).click();
        webDriver.findElement(By.name("q")).sendKeys("acodemy.lv\n");
        delayForSomething(1000);
        js.executeScript("window.scrollTo(0, 5000)");

    }

    @Test
    public void simpleTest() {

        delayForSomething(2000);
        List<WebElement> elements = webDriver.findElements(By.xpath("//h3[contains(@class, \"LC20lb\")]"));
        Assert.assertEquals(elements.size(), 16);
    }

    @AfterTest
    public void afterTest() {
        webDriver.close();
        webDriver.quit();
    }


    private void delayForSomething(int delayInMillis) {

        var startTime = System.currentTimeMillis();
        var endTime = startTime;
        do {
            endTime = System.currentTimeMillis();
        } while (endTime - startTime < delayInMillis);

    }
}
