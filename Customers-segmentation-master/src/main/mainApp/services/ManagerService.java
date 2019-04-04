package mainApp.services;

import mainApp.entities.Manager;
import mainApp.repositories.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepo managerRepo;


    public List<Manager> getAllAManagers() {

        List<Manager> Managers = new ArrayList<>();
        managerRepo.findAll().forEach(Managers::add);
        return Managers;
    }

    public Optional<Manager> getManager(String id) {

        return managerRepo.findById(id);
    }

    public void addManager(Manager manager) {

        managerRepo.save(manager);
    }


    public void updateManager(String id, Manager manager) {

       managerRepo.save(manager);
    }


    public void deleteManager(String id) {

       managerRepo.deleteById(id);
    }
}