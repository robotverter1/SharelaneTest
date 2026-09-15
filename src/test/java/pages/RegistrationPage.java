package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;
    private Wait<WebDriver> wait;

    private final By firstName = By.name("first_name");
    private final By lastName = By.name("last_name");
    private final By email = By.name("email");
    private final By password = By.name("password1");
    private final By confirmPassword = By.name("password2");
    private final By registerButton = By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input");
    private final By registrationErrorMessage = By.className("error_message");
    private final By confirmationMessage = By.className("confirmation_message");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public RegistrationPage enterFirstName(String name){
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(name);
        return this;
    }
    public RegistrationPage enterSurname(String surname){
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(surname);
        return this;
    }
    public RegistrationPage enterEmail(String Email){
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(Email);
        return this;
    }
    public RegistrationPage enterPassword(String enteredPassword){
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(enteredPassword);
        return this;
    }
    public RegistrationPage enterConfirmation(String checkPass){
        driver.findElement(confirmPassword).clear();
        driver.findElement(confirmPassword).sendKeys(checkPass);
        return this;
    }
    public RegistrationPage clickRegister(){
        driver.findElement(registerButton).click();
        return this;
    }

    public String getError(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationErrorMessage));
        return driver.findElement(registrationErrorMessage).getText();
    }
    public boolean isConfirmationFromVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return driver.findElement(confirmationMessage).isDisplayed();
    }
}
