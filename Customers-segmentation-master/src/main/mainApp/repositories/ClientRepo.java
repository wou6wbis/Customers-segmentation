package mainApp.repositories;

import mainApp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepo extends CrudRepository<Client, String> {

    public List<Client> findByManagerId(String managerId);
    public Optional<Client> findById(String id);
}
