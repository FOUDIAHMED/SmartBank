<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Demander mon crédit en ligne - Wafasalaf</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ressources/css/styles.css">


</head>
<body>
<header>

</header>

<main>
    <div class="breadcrumb">
        <a href="#">Accueil</a> / Demander mon crédit en ligne
    </div>


    <div class="application-container">
        <div class="application-form">
            <div class="steps">
                <div class="step active" id="step1">1<br>Simuler mon crédit</div>
                <div class="step" id="step2">2<br>Mes coordonnées</div>
                <div class="step" id="step3">3<br>Mes infos personnelles</div>
            </div>

            <form id="creditForm" action="${pageContext.request.contextPath}/submitCreditForm" method="POST">
                <div class="step-content" id="step1-content">
                    <label for="project">Mon projet</label>
                    <select id="project" required>
                        <option value="personal">J'ai besoin d'argent</option>
                        <option value="used_vehicle">je finance mon véhicule d'occasion</option>
                        <option value="personal_expenses">je gére mes imprevus</option>
                        <option value="new_vehicle">je finance mon véhicule neuf</option>
                        <option value="home_equipment">j'équipe ma maison</option>
                    </select>

                    <label for="status">Je suis</label>
                    <select id="status" required>
                        <option value="private_employee">salarié du sectuer prive</option>
                        <option value="civil_servant">fonctionnaire </option>
                        <option value="merchant">profession liberale</option>
                        <option value="artisan">Commercant</option>
                        <option value="liberal_profession">Artisan</option>
                        <option value="retiree">retraite</option>
                    </select>

                    <label for="amount">Montant (en DH)</label>
                    <div class="slider-container">
                        <input type="range" id="amount" min="1000" max="100000" value="10000" step="100" required>
                        <output for="amount" id="amount-output">10000 DH</output>
                    </div>

                    <label for="duration">Durée (en mois)</label>
                    <div class="slider-container">
                        <input type="range" id="duration" min="12" max="60" value="24" step="1" required>
                        <output for="duration" id="duration-output">24 mois</output>
                    </div>

                    <label for="monthly">Mensualités (en DH)</label>
                    <div class="input-with-icon">
                        <input type="number" id="monthly" readonly>
                        <span class="icon">⇌</span>
                    </div>

                    <button type="button" id="continueStep1" class="btn-primary">Continuer</button>
                </div>

                <div class="step-content" id="step2-content" style="display: none;">
                    <label for="email">Email*</label>
                    <input type="email" id="email" required>

                    <label for="phone">Téléphone mobile*</label>
                    <input type="tel" id="phone" required>

                    <button type="button" id="continueStep2" class="btn-primary">Continuer</button>
                </div>
                <div class="step-content" id="step3-content" style="display: none;">
                    <label>Civilité</label>
                    <div class="radio-group">
                        <input type="radio" id="madame" name="civilite" value="Madame" required>
                        <label for="madame">Madame</label>
                        <input type="radio" id="mademoiselle" name="civilite" value="Mademoiselle">
                        <label for="mademoiselle">Mademoiselle</label>
                        <input type="radio" id="monsieur" name="civilite" value="Monsieur">
                        <label for="monsieur">Monsieur</label>
                    </div>

                    <label for="nom">Nom*</label>
                    <input type="text" id="nom" required>

                    <label for="prenom">Prénom*</label>
                    <input type="text" id="prenom" required>

                    <label for="cin">Numéro CIN / Carte de séjour*</label>
                    <input type="text" id="cin" required>

                    <label for="birthdate">Date de naissance*</label>
                    <input type="date" id="birthdate" required>

                    <label for="employmentDate">Date d'embauche/début de l'activité*</label>
                    <input type="date" id="employmentDate" required>

                    <label for="income">Total revenus mensuels (net en DH)*</label>
                    <input type="number" id="income" required>

                    <label>Avez vous des crédits en cours ?</label>
                    <div class="radio-group">
                        <input type="radio" id="creditOui" name="credit" value="Oui" required>
                        <label for="creditOui">Oui</label>
                        <input type="radio" id="creditNon" name="credit" value="Non">
                        <label for="creditNon">Non</label>
                    </div>

                    <div class="checkbox-group">
                        <input type="checkbox" id="terms" required>
                        <label for="terms">J'ai lu et j'accepte les conditions générales d'utilisation figurant sur les informations légales, notamment la mention relative à la protection des données personnelles</label>
                    </div>

                    <button type="submit" class="btn-primary">Demander ce crédit</button>
                    <button type="button" id="showSummary" class="btn-secondary">Voir mon récapitulatif</button>
                </div>
            </form>
        </div>

        <div class="summary">
            <h2>Mon récapitulatif</h2>
            <div class="summary-progress">
                <div class="progress-bar"></div>
            </div>
            <div class="summary-content" >
                <h3>Mon projet</h3>
                <p id="summaryProject">Prêt Personnel</p>
                <div id="coord" style="display:block;">
                    <h3>Coordonnées et infos personnelles</h3>
                    <p>Civilité: <span id="summaryCivilite"></span></p>
                    <p>Nom: <span id="summaryNom"></span></p>
                    <p>Prénom: <span id="summaryPrenom"></span></p>
                    <p>CIN / Carte de séjour: <span id="summaryCIN"></span></p>
                    <p>Date de naissance: <span id="summaryBirthdate"></span></p>
                    <p>Date d'embauche: <span id="summaryEmploymentDate"></span></p>
                    <p>Revenus mensuels: <span id="summaryIncome"></span></p>
                    <p>Crédits en cours: <span id="summaryCredit"></span></p>
                    <p>Email: <span id="summaryEmail"></span></p>
                    <p>Téléphone: <span id="summaryPhone" ></span></p>
                </div>
                <div id="details"  >
                <h3>Détails de mon crédit</h3>
                <p>Vous êtes: <span id="summaryStatus"></span></p>
                <p>Montant: <span id="summaryAmount"></span> DH</p>
                <p>Durée: <span id="summaryDuration"></span> mois</p>
                <p>Mensualité: <span id="summaryMonthly"></span> DH</p>
                <p>Frais de dossier: <span id="summaryFees"></span> DH</p>
                </div>
            </div>
        </div>
    </div>
</main>


<script src="${pageContext.request.contextPath}/ressources/js/scripts.js"></script>
</body>
</html>

