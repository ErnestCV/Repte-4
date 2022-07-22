package com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.repository;

import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
