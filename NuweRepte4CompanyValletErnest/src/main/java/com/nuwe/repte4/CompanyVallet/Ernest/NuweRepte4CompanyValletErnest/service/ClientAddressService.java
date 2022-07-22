package com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.service;

import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.exception.ElementNotFoundException;
import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.model.Client;
import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.model.ClientAddress;
import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.repository.ClientAddressRepository;
import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientAddressService {

    @Autowired
    ClientAddressRepository clientAddressRepository;
    @Autowired
    ClientRepository clientRepository;

    public ClientAddress add(ClientAddress clientAddress, Integer client_id) throws ElementNotFoundException {
        Client client = clientRepository.findById(client_id)
                .orElseThrow(() -> new ElementNotFoundException("The element with id " + client_id + " has not been found"));
        return clientAddressRepository.save(new ClientAddress(clientAddress.getStreet(),
                clientAddress.getNumber(),
                clientAddress.getCity(),
                clientAddress.getProvince(),
                clientAddress.getPostCode(),
                client));
    }

    public ClientAddress update(Integer id, ClientAddress clientAddress, Integer client_id) throws ElementNotFoundException {
        ClientAddress _clientAddress = getOne(id);
        Client client = clientRepository.findById(client_id)
                .orElseThrow(() -> new ElementNotFoundException("The element with id " + id + " has not been found"));
        if (_clientAddress.getClient().getId().equals(client_id)) {

            _clientAddress.setNumber(clientAddress.getNumber());
            _clientAddress.setCity(clientAddress.getCity());
            _clientAddress.setProvince(clientAddress.getProvince());
            _clientAddress.setPostCode(clientAddress.getPostCode());
            _clientAddress.setClient(client);

            return clientAddressRepository.save(_clientAddress);
        } else {
            throw new ElementNotFoundException("The client with id " + client_id + " does not have an address with id " + id);
        }
    }

    public void delete(Integer id, Integer client_id) throws ElementNotFoundException {
        if (getOne(id).getClient().getId().equals(client_id)) {
            clientAddressRepository.deleteById(id);
        } else {
            throw new ElementNotFoundException("The client with id " + client_id + " does not have an address with id " + id);
        }
    }

    public List<ClientAddress> getAll() {
        return clientAddressRepository.findAll();
    }

    public ClientAddress getOne(Integer id) throws ElementNotFoundException {
        return clientAddressRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("The element with id " + id + " has not been found"));
    }
}

