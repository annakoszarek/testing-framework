import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
  public WebDriver driver;

  @BeforeClass
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://regression-test.elementor.cloud/");
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }

  public void takeScreenShot(String path) throws IOException {
    TakesScreenshot scrShot =((TakesScreenshot)driver);
    File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
    File destFile = new File(path);

    FileUtils.copyFile(srcFile, destFile);
  }
}
