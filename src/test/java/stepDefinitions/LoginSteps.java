package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilites.*;

import java.util.Set;

public class LoginSteps extends Methods {

    String startSeite;
    public static WebDriver driver = w_Driver.getDriver("chrome");

    @When("navigate to Loginseite")
    public void navigate_to_loginseite() {

        waitUntilVisible(loginBtn);
        waitUntilClickable(loginBtn);
        clickFuntion(loginBtn);

    }


    @Then("the user is logged {string} and {string}")
    public void the_user_is_logged_and(String k_Nummer, String pswrd) {

        System.out.println("*** Mit k_Nummer : "+ k_Nummer + " und password : " + pswrd);

        startSeite = driver.getWindowHandle();
        System.out.println("mainSeite: " + startSeite);

        waitUntilClickable(kundenLoginBtn);
        clickFuntion(kundenLoginBtn);

        Set<String> windowHandels =driver.getWindowHandles();

        for (String windowId:windowHandels) {

            if(windowId.equals(startSeite)) continue;

            System.out.println("id : " + windowId);
            driver.switchTo().window(windowId);
            System.out.println("Aktuel Title : " + driver.getTitle());


            sendKeys(kundenNummer,k_Nummer);
            sendKeys(password,pswrd);
            clickFuntion(anmelden);


//            waitUntilVisible(unSuccess);
//            if(coverWebElement(unSuccess).isEnabled()){
//                System.out.println("UnSuccess Message : "+coverWebElement(unSuccess).getText());
//            }

//            driver.close();
        }

    }

    @Then("Login should be not successfully")
    public void login_should_be_not_successfully() {

        waitUntilVisible(unSuccess);
        if(coverWebElement(unSuccess).isEnabled()){
            System.out.println("UnSuccess Message : "+coverWebElement(unSuccess).getText());
        }

        driver.close();

    }

    @Then("navigate to Homepage")
    public void navigate_to_homepage() {

        driver.switchTo().window(startSeite);
        System.out.println("Aktuel Title : " + driver.getTitle());

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.netcologne.de/privatkunden/"));

        System.out.println("Jetz sind Sie Startseite");
    }


}
