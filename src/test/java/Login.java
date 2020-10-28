import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Login {
    WebDriver driver;
    public static final String EMAIL = "ripes53171@swanticket.com";
    public static final String VALID_PASSWORD = "qwert_123";
    public static final String INVALID_PASSWORD = "qwert";

    public static final String EMAIL_FIELD = "input-email";
    public static final String PASSWORD_FIELD = "input-password";

    public static final String LOGIN_BUTTON = "//*[@value=\"Login\"]";

    @BeforeTest
    public void precondition() {
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    @Test
    public void loginValidData() {
        driver.findElement(By.id(EMAIL_FIELD)).sendKeys(EMAIL);
        driver.findElement(By.id(PASSWORD_FIELD)).sendKeys(VALID_PASSWORD);
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
        String testMyAccountAfterLogin = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).getText();
        assertEquals(testMyAccountAfterLogin, "My Account");
    }

//    @Test
//    public void loginInvalidPassword() {
//        driver.findElement(By.id(EMAIL_FIELD)).sendKeys(EMAIL);
//        driver.findElement(By.id(PASSWORD_FIELD)).sendKeys(INVALID_PASSWORD);
//        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
//        String testMyAccountAfterLogin = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).getText();
//        assertEquals(testMyAccountAfterLogin, "My Account");
//    }

    @AfterTest
    public void afterTest() {
         driver.close();
    }
}
