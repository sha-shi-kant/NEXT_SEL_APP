package com.test.stepdefination;
import com.test.base.ConfigHelper;
import com.test.base.Webdriverfactory;
import com.test.pageobjects.Fiche_CreationCollaborateur;
import com.test.pageobjects.Fiche_MAJmanagerCollab;
import com.test.pageobjects.Fiche_VerifEmpKimble;
import com.test.pageobjects.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class MAJmanagerCollab {

    LoginPage lp;

    Fiche_MAJmanagerCollab MAJ;

    Fiche_VerifEmpKimble FVK;

    @Then("Chercher un collaborateur déjà créé")
    public void chercher_un_collaborateur_déjà_créé() throws InterruptedException {
        lp = new LoginPage();
        FVK = new Fiche_VerifEmpKimble();
        MAJ = new Fiche_MAJmanagerCollab();
        Thread.sleep(2000);
        lp.user_opens_url();
        Thread.sleep(2000);
        lp.se_connecter_en_tant_que_responsable_rh_sur_sf_avec_email_et_le_mot_de_passe("testDEV@talan.com","Talan1234!");
        Thread.sleep(2000);
        lp.clickLogin();
        Thread.sleep(2000);
        MAJ.chercher_collab();
        Thread.sleep(2000);
    }
    @When("Modifier son manager au niveau des données emploi")
    public void modifier_son_manager_au_niveau_des_données_emploi() throws InterruptedException {
        MAJ.modifier_manager();
        Thread.sleep(3000);
    }
    @Then("Lancer le job de update du collaborateur")
    public void lancer_le_job_de_update_du_collaborateur() {
    }
    @Then("Se connecter ayant droit de gestion des collaborateur dans Kimble")
    public void se_connecter_ayant_droit_de_gestion_des_collaborateur_dans_kimble() throws InterruptedException {
        lp = new LoginPage();
        Thread.sleep(2000);
        lp.userr_opens_url_kimble();
        Thread.sleep(2000);
        lp.se_connecter_en_tant_que_responsable_rh_sur_kimbe_avec_email_et_le_mot_de_passe("malek.hammami@talan.com.fulluat","Recette-2022");
        Thread.sleep(2000);
        lp.click_onn_login_kimble();
    }
    @Then("Vérifier que la fiche collaborateur s'est mise à jour au niveau de Kimble")
    public void vérifier_que_la_fiche_collaborateur_s_est_mise_à_jour_au_niveau_de_kimble() throws InterruptedException {
        MAJ.modif_manager_kimble();
        Thread.sleep(1000);

    }

}

