package utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Lctrs;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class Methods extends w_Driver implements Lctrs {

    WebDriver driver;
    WebDriverWait wait;
    public Methods() {
        driver = w_Driver.getDriver("chrome");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    public WebElement coverWebElement(By by){

        return driver.findElement(by);
    }
    public void clickFuntion(By by){
        waitUntilVisible(by);
        waitUntilClickable(by);
        coverWebElement(by).click();
    }

    public void sendKeys(By by, String value){
        WebElement element = coverWebElement(by);
        waitUntilVisible(by);
        waitUntilClickable(by);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void waitUntilClickable(By by){

        wait.until(ExpectedConditions.elementToBeClickable(coverWebElement(by)));
    }
    public void waitUntilVisible(By by) {

        wait.until(ExpectedConditions.visibilityOf(coverWebElement(by)));
    }
    public  boolean verifyLink(String url) {

        boolean ergebnis = true;

        try {
            URL urlSite = new URL(url);  // java.net  import
            HttpURLConnection urlConnection = (HttpURLConnection) urlSite.openConnection();
            urlConnection.setConnectTimeout(3000);
            urlConnection.connect();
            if (urlConnection.getResponseCode() >= 200 && urlConnection.getResponseCode() < 400)
                ergebnis = true;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            ergebnis = false;
        }

        return ergebnis;
    }
}
