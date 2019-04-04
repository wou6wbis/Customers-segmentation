package mainApp.repositories;

import mainApp.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends CrudRepository<Client, String> {

    public List<Client> findByManagerId(String managerId);
}
