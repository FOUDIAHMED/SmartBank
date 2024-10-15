package ahmed.foudi.smartbank.dao;

import ahmed.foudi.smartbank.entities.Request;

import java.util.List;
import java.util.Optional;

public interface CreditDAO {
    Request save(Request creditRequest);

    Optional<Request> findById(Long id);

    Request update(Request creditRequest);

    void deleteById(Long id);

    List<Request> findAll();
}
