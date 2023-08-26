package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilites.Methods;
import utilites.wd;

import java.util.Set;

public class LoginStepdefs extends Methods {

    public static WebDriver driver = wd.getDriver("chrome");

    @When("navigate to Loginseite")
    public void navigate_to_loginseite() {



    }


    @Then("the user is logged {string} and {string}")
    public void the_user_is_logged_and(String k_Nummer, String pswrd) {

       waitUntilVisible(loginBtn);
        waitUntilClickable(loginBtn);
        clickFuntion(loginBtn);

        String mainSeite = driver.getWindowHandle();
        System.out.println("mainSeite: " + mainSeite);

        waitUntilClickable(kundenLoginBtn);
        clickFuntion(kundenLoginBtn);

        Set<String> windowHandels =driver.getWindowHandles();

        for (String windowId:windowHandels) {

            if(windowId.equals(mainSeite)) continue;

            System.out.println("id : " + windowId);
            driver.switchTo().window(windowId);
            System.out.println("Aktuel Title : " + driver.getTitle());


            sendKeys(kundenNummer,k_Nummer);
            sendKeys(password,pswrd);
            clickFuntion(anmelden);


            waitUntilVisible(unSuccess);
            if(coverWebElement(unSuccess).isEnabled()){
                System.out.println("UnSuccess Message : "+coverWebElement(unSuccess).getText());
            }

            driver.close();
        }

        driver.switchTo().window(mainSeite);
        System.out.println("Aktuel Title : " + driver.getTitle());


    }

    @Then("Login should be not successfully")
    public void login_should_be_not_successfully() {



    }

    @Then("navigate to Homepage")
    public void navigate_to_homepage() {

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.netcologne.de/privatkunden/"));


    }


}
