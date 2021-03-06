package by.it.tsyhanova;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckFindImageGoogleSiteTest {

    private WebDriver driver;

    private static WebElement waitAndGetWebElement(WebDriver driver, By queryLocator) {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
    }

    @Before
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void taskA() throws Exception {
        driver.get("https://www.google.com");
        // Engish page
        // driver.get("https://www.google.com/webhp?hl=en");
        By byQueryInput = By.xpath("//input[@class='gLFyf gsfi']");
        WebElement queryInput = waitAndGetWebElement(driver, byQueryInput);
        queryInput.sendKeys("seleniumhq\n");

        By byLinkImagesSearch = By.xpath("//a[@class='q qs'][contains(@href,'tbm=isch')]");
        WebElement linkImagesSearch = waitAndGetWebElement(driver, byLinkImagesSearch);
        linkImagesSearch.click();

        By byLinkResultFirstImage = By.xpath("//*[@class='rg_bx rg_di rg_el ivg-i'][@data-ri='0']");
        WebElement linkResultFirstImage = waitAndGetWebElement(driver, byLinkResultFirstImage);
        linkResultFirstImage.click();

        By byLinkResultSite = By.xpath("//a[@class='irc_vpl i3599 irc_lth'][@tabindex=0]");
        WebElement linkResultSite = waitAndGetWebElement(driver, byLinkResultSite);

        //wait rendering (но лучше проверить это явно)
        Thread.sleep(333);
        linkResultSite.click();

        //open a new tab and check url at the last tab
        Set<String> handles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(handles);
        String newTab = handlesList.get(handlesList.size() - 1);

        // switch to new tab
        driver.switchTo().window(newTab);

        String url = driver.getCurrentUrl();
        assertTrue("not complete find", url.startsWith("https://www.seleniumhq.org"));
    }

    @After
    public void tearDownBrowser() {
        driver.quit();
    }


}
