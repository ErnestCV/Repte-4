package com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.controller;

import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.exception.ElementNotFoundException;
import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.model.Client;
import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.model.ClientAddress;
import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.service.ClientAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients/{client_id}/addresses")
public class ClientAddressController {

    @Autowired
    ClientAddressService clientAddressService;

    @PostMapping("/new")
    public ResponseEntity<ClientAddress> createClientAddress(@Valid @RequestBody ClientAddress clientAddress, @PathVariable("client_id") Integer client_id) throws ElementNotFoundException {
        return new ResponseEntity<>(clientAddressService.add(clientAddress, client_id), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientAddress> updateClientAddress(@PathVariable("id") Integer id, @Valid @RequestBody ClientAddress clientAddress, @PathVariable("client_id") Integer client_id) throws ElementNotFoundException {
        return new ResponseEntity<>(clientAddressService.update(id, clientAddress, client_id), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteClientAddress(@PathVariable("id") Integer id, @PathVariable("client_id") Integer client_id) throws ElementNotFoundException {
        clientAddressService.delete(id, client_id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientAddress> getClientAddressById(@PathVariable("id") Integer id) throws ElementNotFoundException {
        return new ResponseEntity<>(clientAddressService.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientAddress>> getAllClientsAddresses() {
        List<ClientAddress> clientAddresses = clientAddressService.getAll();
        if (clientAddresses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientAddresses, HttpStatus.OK);
    }
}

