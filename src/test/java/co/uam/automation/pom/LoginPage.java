package co.uam.automation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasePage {
    public By loginOption = By.linkText("Log in");
    public By nameofuser = By.id("nameofuser");
    public By username = By.id("loginusername");
    public By password = By.id("loginpassword");
    public By loginButton = By.xpath("//button[text()='Log in']");
    public By searchProduct = By.xpath("//a[contains(.,'Nokia lumia 1520')]");
    public By addToCartButton = By.xpath("//a[@onclick='addToCart(2)']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) throws InterruptedException {
        click(loginOption);
        Thread.sleep(2000);
        type(username, this.username);
        type(password, this.password);
        click(loginButton);
    }

    public void selectProduct() throws InterruptedException {
        click(searchProduct);
        Thread.sleep(2000);
    }

    public String addProductToCart() throws InterruptedException {
        click(addToCartButton);
        Thread.sleep(2000);
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertMessage;
    }
}

