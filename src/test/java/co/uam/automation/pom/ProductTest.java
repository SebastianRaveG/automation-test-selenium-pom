package co.uam.automation.pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest {
    private WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void setUp() throws Exception {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        driver = loginPage.chromeDriverConnection();
        loginPage.visit("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void loginAndSearchProduct() throws InterruptedException {
        loginPage.login("username", "password");
        Thread.sleep(2000);

        productPage.selectProduct();
        Thread.sleep(2000);

        productPage.addToCart();
    }
}
