package com.test.stepdefination;

import com.test.base.ConfigHelper;
import com.test.base.Webdriverfactory;
import com.test.pageobjects.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class loginSFSteps {
    LoginPage lp = new LoginPage();
    Fiche_CreationCollaborateur FCC;
    Fiche_VerifEmpKimble FVK;

    String urlSF = ConfigHelper.INSTANCE.getProperty("UrlSf");
    @Given("user launch chrome browser")
    public void user_launch_chrome_browser() {
        lp = new LoginPage();
        FCC = new Fiche_CreationCollaborateur();
        FVK = new Fiche_VerifEmpKimble();
    }
    @When("User opens URL")
    public void user_opens_url() {
        System.out.print(urlSF);
        Webdriverfactory.getDriver().get(urlSF);
    }
    @Given("Se connecter en tant que responsable RH sur SF avec email {string} et le mot de passe {string}")
    public void se_connecter_en_tant_que_responsable_rh_sur_sf_avec_email_et_le_mot_de_passe(String email, String password) {
        lp.setUseName(email);
        lp.setPassword(password);
    }
    @When("Click on login")
    public void click_on_login() throws InterruptedException {
        Webdriverfactory.getDriver().findElement(By.xpath("//*[@id=\"logOnFormSubmit\"]")).click();
        Thread.sleep(3000);
    }
}
