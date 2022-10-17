package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_center")
@Getter
@Setter
public class ServiceCenter {

    @Id
    @Column(name = "service_center_id")
    public Integer serviceCenterId;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "open_on_saturday")
    private Boolean openOnSaturday;
}
