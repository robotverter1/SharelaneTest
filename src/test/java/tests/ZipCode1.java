package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class ZipCode1 {
    //Код для тестирования сайта ShareLane
    public WebDriver driver;
    public Wait<WebDriver> wait;



    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
    }
    @Test
    public void ZipCodePositive(){
        driver.findElement(By.name ("zip_code")).sendKeys("12345");
        driver.findElement(By.tagName("input")).click();
        boolean element = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).isDisplayed();

        boolean requiredTextDisplayed = wait.until(driver1 ->
                driver1.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[7]/td/span")).isDisplayed()
        );
        Assert.assertTrue(element);
        driver.quit();
    }


    @Test
    public void ZipCode40(){
        WebDriver driver = new EdgeDriver();
        //Создаётся объект wait, который определяет время ожидания ответа
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Обработ
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name ("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        String error = driver.findElement(By.className("error_message")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits");
        driver.quit();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
