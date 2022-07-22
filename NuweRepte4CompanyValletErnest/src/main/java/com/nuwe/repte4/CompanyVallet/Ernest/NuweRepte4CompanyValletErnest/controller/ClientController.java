package com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.controller;

import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.exception.ElementNotFoundException;
import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.model.Client;
import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/new")
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
        return new ResponseEntity<>(clientService.add(client), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Integer id,@Valid @RequestBody Client client) throws ElementNotFoundException {
        return new ResponseEntity<>(clientService.update(id, client), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") Integer id) throws ElementNotFoundException {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id) throws ElementNotFoundException {
        return new ResponseEntity<>(clientService.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAll();
        if (clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
