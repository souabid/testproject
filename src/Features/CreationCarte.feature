Feature: Test One2team
Description: Le but de ce test est d'enregistrer le scénario suivant sous Chrome


Scenario: Verifier la connexion a la session
		Given Lancer votre web application
		And Je saisi mon login candidat et mon mot de passe test avec le domaine telco
		When Je selectionne le slideboard Zz_Taches
       	Then Je ferme ma session