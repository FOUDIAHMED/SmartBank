package entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RequestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "LOAN_REQUEST_ID")
    private Request loanRequest;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STATE_ID")
    private Status state;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "EXPLANATION")
    private String explanation;

    @JsonProperty
    public Status getState() {
        return state;
    }

    public void setState(Status state) {
        this.state = state;
    }

    public Request getLoanRequest() {
        return loanRequest;
    }

    public void setLoanRequest(Request loanRequest) {
        this.loanRequest = loanRequest;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
