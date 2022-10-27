@Test
Feature: login
    @LoginSF
    Scenario: login SF
        Given user launch chrome browser
        When User opens URL
        Given Se connecter en tant que responsable RH sur SF avec email "testDEV@talan.com" et le mot de passe "Talan1234!"
#        And  Click on login
#    @LoginKimble
#    Scenario: login Kimble
#        Given user launch chrome browser
#        When User opens URL kimble
#        Given Se connecter en tant que responsable RH sur kimble avec email "malek.hammami@talan.com.fulluat" et le mot de passe "Recette-2022"
#        Then Click on login kimble
