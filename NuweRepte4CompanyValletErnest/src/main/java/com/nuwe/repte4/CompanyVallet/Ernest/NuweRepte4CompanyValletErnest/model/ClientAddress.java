package com.nuwe.repte4.CompanyVallet.Ernest.NuweRepte4CompanyValletErnest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "clients_address")
public class ClientAddress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 2, message = "Please provide a valid street name")
    private String street;
    @Size(min = 1, message = "Please provide a valid number")
    private String number;
    @Size(min = 1, message = "Please provide a valid city")
    private String city;
    @Size(min = 2, message = "Please provide a valid province")
    private String province;
    @Size(min = 5, message = "Please provide a valid postcode")
    private String postCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore
    private Client client;

    public ClientAddress() {
    }

    public ClientAddress(String street, String number, String city, String province, String postCode, Client client) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.province = province;
        this.postCode = postCode;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
