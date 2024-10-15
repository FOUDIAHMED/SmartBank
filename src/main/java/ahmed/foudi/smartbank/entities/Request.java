package ahmed.foudi.smartbank.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String projet;

    @Column(nullable = false)
    private Double duration;

    @Column(nullable = false)
    private Double monthlyPayments;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String mobilePhone;

    @Column(nullable = false)
    private String civility;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String cinNumber;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate birthDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate hiringDate;

    @Column(nullable = false)
    private Double totalRevenue;

    @Column(nullable = false)
    private boolean hasOngoingCredits;

    @Column(nullable = false)
    private boolean termsAccepted;

    @JsonManagedReference
    @OneToMany(mappedBy = "loanRequest", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RequestStatus> requestStates;

    public Set<RequestStatus> getDemandeStatuts() {
        return requestStates;
    }

    public void setDemandeStatuts(Set<RequestStatus> demandeStatuts) {
        this.requestStates = demandeStatuts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public Double getAmount() {
        return amount;
    }
    //

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setMonthlyPayments(Double monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCinNumber() {
        return cinNumber;
    }

    public void setCinNumber(String cinNumber) {
        this.cinNumber = cinNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public boolean isHasOngoingCredits() {
        return hasOngoingCredits;
    }

    public void setHasOngoingCredits(boolean hasOngoingCredits) {
        this.hasOngoingCredits = hasOngoingCredits;
    }

    public boolean isTermsAccepted() {
        return termsAccepted;
    }

    public void setTermsAccepted(boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }


}