package co.uam.automation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public By searchedProduct = By.linkText("//A[@href='prod.html?idp_=1'][text()='Samsung galaxy s6']");
    public By addToCartButton = By.xpath("//a[text()='Add to cart']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectProduct() {
        click(searchedProduct);
    }

    public void addToCart() {
        click(addToCartButton);
    }
}
