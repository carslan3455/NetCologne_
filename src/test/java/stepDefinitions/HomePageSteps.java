package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import utilites.Methods;
import utilites.w_Driver;


public class HomePageSteps extends Methods {
    public static WebDriver driver = w_Driver.getDriver("chrome");

    @Given("navigate to NetCologne")
    public void navigate_to_net_cologne() {

        driver.get("https://www.netcologne.de/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        List<WebElement> akzeptirenList = driver.findElements(akzeptieren);

        if (akzeptirenList.size()>0) {
            waitUntilVisible(akzeptieren);
            clickFuntion(akzeptieren);

        }

}

    @When("Home Page icon link verify")
    public void home_page_icon_link_verify() {
        System.out.println("Verify");

        int count = driver.findElements(iconLinks).size();
        System.out.println("iconLinks count : " + count);

        for (WebElement link : driver.findElements(iconLinks)) {
            System.out.println("link: " + link.getAttribute("href"));
            Assert.assertTrue(verifyLink(link.getAttribute("href")));
        }

    }

    @Then("All link verify")
    public void all_link_verify() {
        System.out.println("Home page");

        int count = driver.findElements(allLinks).size();
        System.out.println("allLinks count : " + count);

//        for (WebElement link : driver.findElements(allLinks)) {
//            System.out.println("allLink: " + link.getAttribute("href"));
//            Assert.assertTrue(verifyLink(link.getAttribute("href")));
//        }

    }


}
