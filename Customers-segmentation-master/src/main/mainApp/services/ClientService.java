package mainApp.services;

import mainApp.entities.Client;
import mainApp.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;


    public List<Client> getAllClients(String managerId) {

        List<Client> clients = new ArrayList<>();
        clientRepo.findByManagerId(managerId).
        forEach(clients::add);
        return clients;
    }

    public Optional<Client> getClient(String id) {

        return clientRepo.findById(id);
    }

    public void addClient(Client client) {

        clientRepo.save(client);
    }


    public void updateClient(Client client) {

       clientRepo.save(client);
    }


    public void deleteClient(String id) {

       clientRepo.deleteById(id);
    }
}