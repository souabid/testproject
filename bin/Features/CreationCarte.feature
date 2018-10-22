Feature: Test One2team
Description: Le but de ce test est d'enregistrer le scénario suivant sous Chrome


Scenario: Verifier la connexion a la session
		Given Lancer votre web application
		And Je saisi mon login candidat et mon mot de passe Candidat1* avec le domaine telco
		When Je selectionne le slideboard Zz_Taches
		And Je cree une carte candidat test
		And Je drag and drop la carte generee dans une autre colonne
		And ouvrir la carte creee et uploader un document via le path \src\tests\Resources\Capture.PNG
        Then Je verifie que le document Capture.PNG est bien uploade
       	And Je ferme ma session