package com.example.demo.repository;

import com.example.demo.model.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Integer> {
}
