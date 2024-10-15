package ahmed.foudi.smartbank.controller;

import ahmed.foudi.smartbank.db.HibernateDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/submitCreditForm")
public class CreditFormServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req  , HttpServletResponse res) throws ServletException , IOException {
        HibernateDB.getInstance();
        req.getRequestDispatcher("main.jsp").include(req , res);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form data (step 1 - 3)
        String project = request.getParameter("project");
        String status = request.getParameter("status");
        String amount = request.getParameter("amount");
        String duration = request.getParameter("duration");
        String monthly = request.getParameter("monthly");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String civilite = request.getParameter("civilite");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String cin = request.getParameter("cin");
        String birthdate = request.getParameter("birthdate");
        String employmentDate = request.getParameter("employmentDate");
        String income = request.getParameter("income");
        String credit = request.getParameter("credit");
        String terms = request.getParameter("terms");

        // Save the data (this can be storing to a database or file system)
        // For demonstration, we'll just print them to the console
        System.out.println("Project: " + project);
        System.out.println("Status: " + status);
        System.out.println("Amount: " + amount);
        System.out.println("Duration: " + duration);
        System.out.println("Monthly: " + monthly);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Civilité: " + civilite);
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("CIN: " + cin);
        System.out.println("Date de naissance: " + birthdate);
        System.out.println("Date d'embauche: " + employmentDate);
        System.out.println("Revenus mensuels: " + income);
        System.out.println("Crédit en cours: " + credit);
        System.out.println("Conditions acceptées: " + terms);
        request.getRequestDispatcher("main.jsp").include(request , response);

    }
}
