package pages;

import org.openqa.selenium.By;


public interface Locators  {

    By akzeptieren= By.cssSelector("a[class='c-button c-text__t4_2']");
    By iconLinks= By.cssSelector("div.socialMediaWrapper__a8b45 a");
    By allLinks= By.cssSelector("div a[href");

    By loginBtn = By.cssSelector("a[href='#login']");
    By kundenLoginBtn = By.xpath("//span[text()='MeineKundenwelt-Login']");
    By kundenNummer = By.id("username");
    By password = By.id("password");
    By anmelden = By.cssSelector("input[value='Anmelden']");
    //(//span[@class='innerText__5cf27'])[69]

    By unSuccess = By.cssSelector("span[th=\"err : ${#fields.errors('*')}\"]");


}
