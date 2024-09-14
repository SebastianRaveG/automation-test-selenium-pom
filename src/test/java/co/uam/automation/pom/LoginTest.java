package co.uam.automation.pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTest {
    private WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp() throws Exception{
        loginPage = new LoginPage(driver);
        driver = loginPage.chromeDriverConnection();
        loginPage.visit("https://www.demoblaze.com/");
    }
    @AfterMethod
    public void tearDown() throws Exception{
        driver.quit();
    }
    @Test
    public void loginUser() throws InterruptedException {
        loginPage.login("username", "password");
        Thread.sleep(2000);
        loginPage.selectProduct();
        String alertMessage = loginPage.addProductToCart();
        // Validar el mensaje de la alerta
        assertEquals(alertMessage, "Product added.");
    }
}
