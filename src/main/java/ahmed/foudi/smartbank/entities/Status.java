package ahmed.foudi.smartbank.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "state")
    private Set<RequestStatus> requestStates;

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public Set<RequestStatus> getRequestStates(){
        return requestStates;
    }

    public void setRequestStates(Set<RequestStatus> requestStates){
        this.requestStates = requestStates;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
