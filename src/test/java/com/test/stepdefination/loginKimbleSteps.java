package com.test.stepdefination;

import com.test.base.ConfigHelper;
import com.test.base.Webdriverfactory;
import com.test.pageobjects.Fiche_CreationCollaborateur;
import com.test.pageobjects.Fiche_VerifEmpKimble;
import com.test.pageobjects.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class loginKimbleSteps{

    LoginPage lp = new LoginPage();
    Fiche_CreationCollaborateur FCC;
    Fiche_VerifEmpKimble FVK;

    String urlkimble = ConfigHelper.INSTANCE.getProperty("Urlkimble");

    @Given("user launch chrome browser  kimble")
    public void userr_launch_chrome_browser() {
        // pour lancer google chrome
        lp = new LoginPage();
        FCC = new Fiche_CreationCollaborateur();
        FVK = new Fiche_VerifEmpKimble();
    }

    @When("User opens URL kimble")
    public void userr_opens_url() {
        // pour acceder à kimble
        System.out.print(urlkimble);
        Webdriverfactory.getDriver().get(urlkimble);
    }
    @Given("Se connecter en tant que responsable RH sur kimble avec email {string} et le mot de passe {string}")
    public void se_connecter_en_tant_que_responsable_rh_sur_kimbe_avec_email_et_le_mot_de_passe(String nomutilisateur, String motdepasse) {
        lp.setNomutilisateur(nomutilisateur);
        lp.setMotdepasse(motdepasse);
    }
    @When("Click on login kimble")
    public void click_onn_login() throws InterruptedException {
        lp.clickon_seconnecter();
        Thread.sleep(3000);
    }
}
