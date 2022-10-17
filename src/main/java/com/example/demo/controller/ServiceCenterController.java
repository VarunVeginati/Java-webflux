package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.ServiceCenter;
import com.example.demo.service.ServiceCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ServiceCenterController {

    @Autowired
    public ServiceCenterService service;

    @GetMapping("/{id}")
    public Mono<ServiceCenter> getServiceCenterById(@PathVariable Integer id) {
        return service.fetchById(id);
    }

    @PostMapping("/{id}")
    public Mono<ServiceCenter> create(@PathVariable Integer id, @RequestBody ServiceCenter serviceCenter) {
        if(!id.equals(serviceCenter.getServiceCenterId())) throw new BadRequestException("Id doesn't math");

        return service.create(serviceCenter);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @GetMapping("/get_all")
    public Flux<ServiceCenter> getAll() {
        return service.getAll();
    }
}
