package com.test.stepdefination;

import io.cucumber.java.en.*;
import com.test.base.ConfigHelper;
import com.test.base.Webdriverfactory;
import com.test.pageobjects.Fiche_VerifEmpKimble;
import com.test.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class VerfiEmpKimbleSteps {

    public WebDriver driver;

    LoginPage lp = new LoginPage();
    Fiche_VerifEmpKimble FVK = new Fiche_VerifEmpKimble();

    String urlkimble = ConfigHelper.INSTANCE.getProperty("Urlkimble");
    @Then("Vérifier que l\"employé n'est pas ajouter")
    public void vérifier_que_l_employé_n_est_pas_ajouter() throws InterruptedException {
        lp = new LoginPage();
        FVK= new Fiche_VerifEmpKimble();
        Thread.sleep(2000);
        lp.userr_opens_url_kimble();
        Thread.sleep(2000);
        lp.se_connecter_en_tant_que_responsable_rh_sur_kimbe_avec_email_et_le_mot_de_passe("malek.hammami@talan.com.fulluat","Recette--2022");
        Thread.sleep(2000);
        lp.click_onn_login_kimble();
        FVK.verif_emp_nestpas_ajouter();
        Thread.sleep(1500);
        //  FVK.verifier_les_champs();
        }
    @Then("extraction des données de l'employée de SF")
    public void extraction_des_données_de_l_employée_de_sf() throws InterruptedException {
        lp = new LoginPage();
        FVK = new Fiche_VerifEmpKimble();
        Thread.sleep(2000);
        lp.user_opens_url();
        Thread.sleep(2000);
        lp.se_connecter_en_tant_que_responsable_rh_sur_sf_avec_email_et_le_mot_de_passe("testDEV@talan.com","Talan1234!");
        Thread.sleep(2000);
        lp.clickLogin();
        Thread.sleep(2000);
        FVK.get_champs_a_verifier();
        Thread.sleep(1500);
    }
}
