import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {
    By userLoginInput = By.id("user_login");
    By passwordLoginInput = By.id("user_pass");
    By passwordLoginSubmitButton = By.id("wp-submit");
    private WebDriver webDriver;

    LoginPage(WebDriver driver) {
        webDriver = driver;
    }
    public void setLogin(String login) {
        webDriver.findElement(userLoginInput).sendKeys(login);
    }

    public void setPassword(String password) {
        webDriver.findElement(passwordLoginInput).sendKeys(password);
    }

    public void clickSubmitButton() {
        webDriver.findElement(passwordLoginSubmitButton).click();
    }
}
