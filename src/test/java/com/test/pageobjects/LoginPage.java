package com.test.pageobjects;

import com.test.base.ConfigHelper;
import com.test.base.Webdriverfactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
// *********************************login pour SF *****************************************
public class LoginPage{
    public WebDriver driver;

    Fiche_CreationCollaborateur FCC = new Fiche_CreationCollaborateur();

    Fiche_VerifEmpKimble FVK = new Fiche_VerifEmpKimble();

    String urlSF = ConfigHelper.INSTANCE.getProperty("UrlSf");
    String urlkimble = ConfigHelper.INSTANCE.getProperty("Urlkimble");
    public LoginPage() {
        this.driver = Webdriverfactory.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "j_username")
    @CacheLookup
    WebElement txtEmail;
    @FindBy(id = "j_password")
    @CacheLookup
    WebElement txtPassword;
    @FindBy(xpath ="//*[@id=\"logOnFormSubmit\"]")
    @CacheLookup
    WebElement btnLogin;
    public void setUseName(String uname) {
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }
    public void setPassword(String pwd) {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }
    public void clickLogin() {
        driver.findElement(By.xpath("//*[@id=\"logOnFormSubmit\"]")).click();
    }
    @FindBy(xpath = "//*[@id=j_username\"]")
    WebElement txtemailsf;
    @FindBy(xpath = "//*[@id=\"j_password\"]")
    WebElement txtpasssf;
    @FindBy( xpath= "//*[@id=\"logOnFormSubmit\"]")
    WebElement loginsf;
    // ************************login pour kimble************************************
    @FindBy(id = "username")
    @CacheLookup
    WebElement nomutilisateur;
    @FindBy(id = "password")
    @CacheLookup
    WebElement motdepasse;
    @FindBy(id = "Login")
    @CacheLookup
    WebElement se_connecter;
    public void setNomutilisateur(String uname) {
        nomutilisateur.clear();
        nomutilisateur.sendKeys(uname);
    }
    public void setMotdepasse(String pwd) {
        motdepasse.clear();
        motdepasse.sendKeys(pwd);
    }
    public void clickon_seconnecter() {
        se_connecter.click();
    }
    // *****************acceder a SF ************************

    public void user_opens_url() {
        // pour acceder à SF
        System.out.print(urlSF);
        Webdriverfactory.getDriver().get(urlSF);
    }
    public void se_connecter_en_tant_que_responsable_rh_sur_sf_avec_email_et_le_mot_de_passe(String email, String password) {
        this.setUseName(email);
        this.setPassword(password);
    }
    public void click_on_login() throws InterruptedException {
        this.clickLogin();
        Thread.sleep(3000);
    }
    // ****************************acceder a Kimble*********************************
    public void userr_opens_url_kimble() {
        // pour acceder à kimble
        System.out.print(urlkimble);
        Webdriverfactory.getDriver().get(urlkimble);
    }
    public void se_connecter_en_tant_que_responsable_rh_sur_kimbe_avec_email_et_le_mot_de_passe(String nomutilisateur, String motdepasse) {
        this.setNomutilisateur(nomutilisateur);
        this.setMotdepasse(motdepasse);
    }
    public void click_onn_login_kimble() throws InterruptedException {
        this.clickon_seconnecter();
        Thread.sleep(3000);
    }
}
