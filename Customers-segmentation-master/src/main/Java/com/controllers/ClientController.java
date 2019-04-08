package com.controllers;

import com.entities.Client;
import com.entities.Manager;
import com.services.ClientService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {


    @Autowired
    private ClientService clientService;

    @RequestMapping("/manager/client")
    public String hello() {
        return "HI Client";
    }

    @RequestMapping("/manager/{id}/clients")
    public List<Client> getAllClients(@PathVariable String id) {

        return clientService.getAllClients(id);
    }


    @RequestMapping("manager/{managerId}/clients/{id}")
    public Optional<Client> getClient(@PathVariable String id, @PathVariable String managerId) {
        return clientService.getClient(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/manager/{managerId}/clients")
    public void addClient(@RequestBody Client client, @PathVariable String managerId) {
        client.setManager(new Manager(managerId));
        clientService.addClient(client);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/manager/{managerId}/clients/{id}")
    public void updateClient(@RequestBody Client client, @PathVariable String managerId, @PathVariable String id) {
        client.setManager(new Manager(managerId));
        clientService.updateClient(client);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/manager/{managerId}/clients/{id}")
    public void deleteClient(@PathVariable String id, @PathVariable String managerId) {
        clientService.deleteClient(id);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/client/{id}/api")
    public void clusterClient(@PathVariable String id) throws JSONException {
        clientService.clusterClient(id);
    }


    @RequestMapping("/manager/{id}/clients/cluster/{cluster}")
    public List<Client> getClientsByCluster(@PathVariable String id, @PathVariable String cluster) {

        return clientService.getClientsByCluster(id, cluster);
    }

}
