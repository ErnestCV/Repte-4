package com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.repository;

import com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.model.ClientAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAddressRepository extends JpaRepository<ClientAddress, Integer> {
}
