import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ElementorRegressionTest extends BaseTest {
  String url = "https://regression-test.elementor.cloud/";
  String adminUrl = "https://regression-test.elementor.cloud/wp-admin/";
  String editorUrl = "https://regression-test.elementor.cloud/?elementor";
  String login = "automation-senior";
  String password = "GoodLuck100:)";
  ;

  @Test
  public void test() throws IOException {
    Assert.assertEquals(driver.getCurrentUrl(), url);
    takeScreenShot(System.getProperty("user.dir") + "\\screenshots\\first.png");

    driver.get(adminUrl);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.setLogin(login);
    loginPage.setPassword(password);
    loginPage.clickSubmitButton();

    driver.get(editorUrl);
    EditorPage editorPage = new EditorPage(driver);
    editorPage.waitForHeader();

    JavascriptExecutor js = (JavascriptExecutor) driver;

    js.executeScript(
        "$e.run('document/elements/settings', {\n"
            + "container: elementor.getPreviewContainer(),\n"
            + "settings: { custom_css: '' }\n"
            + "});\n"
            + "$e.run( 'document/save/default' );");

    js.executeScript(
        "$e.run('document/elements/settings', {\n"
            + "container: elementor.getPreviewContainer(),\n"
            + "settings: { custom_css: '#main h1{font-size: 100px}' }\n"
            + "});\n"
            + "$e.run( 'document/save/default' );");

    driver.get(url);
    Assert.assertEquals(driver.getCurrentUrl(), url);
    takeScreenShot(System.getProperty("user.dir") + "\\screenshots\\second.png");

    driver.get(editorUrl);
    js.executeScript(
        "$e.run('document/elements/settings', {\n"
            + "container: elementor.getPreviewContainer(),\n"
            + "settings: { custom_css: '' }\n"
            + "});\n"
            + "$e.run( 'document/save/default' );");
  }
}
