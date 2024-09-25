package co.uam.automation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasePage {
    public By loginOption = By.id("login2");
    public By username = By.id("loginusername");
    public By password = By.id("loginpassword");
    public By loginButton = By.xpath("//button[text()='Log in']");
    public By searchProduct = By.xpath("//a[contains(.,'Nokia lumia 1520')]");
    public By addToCartButton = By.xpath("//a[@onclick='addToCart(2)']");
    public By cartOption = By.linkText("Cart");
    public By productInCart = By.xpath("//td[contains(text(),'Nokia lumia 1520')]");
    public By placeOrderButton = By.xpath("//button[text()='Place Order']");
    public By nameField = By.id("name");
    public By cardField = By.id("card");
    public By purchaseButton = By.xpath("//button[text()='Purchase']");
    public By confirmationMessage = By.xpath("//h2[text()='Thank you for your purchase!']");

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

    public void Cart() throws InterruptedException{
        click(cartOption);
        Thread.sleep(2000);
    }

    public boolean isOnCartPage() {
        return driver.getCurrentUrl().contains("/cart.html");
    }

    public boolean isProductInCart() {
        return isDisplayed(productInCart);
    }

    public void placeOrder() throws InterruptedException {
        click(placeOrderButton);
        Thread.sleep(2000);
    }

    public void fillPurchaseForm(String name, String card) throws InterruptedException {
        type(name, nameField);
        type(card, cardField);
        click(purchaseButton);
        Thread.sleep(2000);
    }

    public boolean isPurchaseSuccessful() {
        return isDisplayed(confirmationMessage);
    }

}

