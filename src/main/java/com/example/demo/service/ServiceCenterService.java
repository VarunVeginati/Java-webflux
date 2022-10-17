package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.ServiceCenter;
import com.example.demo.repository.ServiceCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Service
public class ServiceCenterService {

    @Autowired
    public ServiceCenterRepository repository;

    public Mono<ServiceCenter> fetchById(Integer id) {
        return Mono.just(repository.findById(id)
                .orElseThrow(() -> {throw new NotFoundException("Service center not found");}));
    }

    public Mono<ServiceCenter> create(ServiceCenter serviceCenter) {
        return Mono.just(repository.save(serviceCenter));
    }

    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow(() -> {throw new NotFoundException("Service center not found");});

        repository.deleteById(id);
    }

    public Flux<ServiceCenter> getAll() {
        return Flux.fromIterable(repository.findAll());
    }
}
