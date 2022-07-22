package com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.service;

import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.exception.ElementNotFoundException;
import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.model.Client;
import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client add(Client client) {
        return clientRepository.save(new Client(client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getMobileNo()));
    }

    public Client update(Integer id, Client client) throws ElementNotFoundException {
        Client _client = getOne(id);

        _client.setFirstName(client.getFirstName());
        _client.setLastName(client.getLastName());
        _client.setEmail(client.getEmail());
        _client.setMobileNo(client.getMobileNo());

        return clientRepository.save(_client);
    }

    public void delete(Integer id) throws ElementNotFoundException {
        getOne(id);
        clientRepository.deleteById(id);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getOne(Integer id) throws ElementNotFoundException {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("The element with id " + id + " has not been found"));
    }
}
