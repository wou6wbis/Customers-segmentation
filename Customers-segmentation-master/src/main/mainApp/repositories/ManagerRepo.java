package mainApp.repositories;

import mainApp.entities.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepo extends CrudRepository<Manager, String> {

}
