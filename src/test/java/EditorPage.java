import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditorPage extends BaseTest {
    By header = By.id("elementor-panel-header-title");

    private WebDriver webDriver;

    EditorPage(WebDriver driver) {
        webDriver = driver;
    }

    public void waitForHeader() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
    }
}
