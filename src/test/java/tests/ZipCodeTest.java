package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import pages.RegistrationPage;
import pages.ZipCodePage;


public class ZipCodeTest extends tests.BaseTest{

    ZipCodePage zipCodePage = new ZipCodePage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @BeforeMethod
    public void initPage(){
        zipCodePage = new ZipCodePage(driver);
        registrationPage = new RegistrationPage(driver);
    }
    @Test
    public void checkZipCode4Digits(){
        zipCodePage.open().enterZipCode("1234").clickContinue();
        String errorMessage = zipCodePage.getError();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
    }
    @Test
    public void checkZipCode5Digits(){
        zipCodePage
                .open()
                .enterZipCode("12345")
                .clickContinue();
        Assert.assertTrue(zipCodePage.isRegistrationFromVisible(), "Message right");
    }
    @Test
    public void checkRegistrationForm(){
        checkZipCode5Digits();
        registrationPage
                .enterFirstName("Fernando")
                .enterSurname("Alonso")
                .enterEmail("abc@abc.abc")
                .enterPassword("12345")
                .enterConfirmation("12345")
                .clickRegister();
        Assert.assertTrue(registrationPage.isConfirmationFromVisible(), "Message right!");
    }

    @Test
    public void dropRegistrationForm(){
        checkZipCode5Digits();
        registrationPage
                .enterFirstName("Fernando")
                .enterSurname("Alonso")
                .enterEmail("abc@abc.abc")
                .enterPassword("1234")
                .enterConfirmation("12345")
                .clickRegister();
        String errorMessage = registrationPage.getError();
        Assert.assertEquals(errorMessage, "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }

    @AfterMethod
    public void tearDowm(){
        if(driver!=null){
            driver.quit();
        }
    }

}
