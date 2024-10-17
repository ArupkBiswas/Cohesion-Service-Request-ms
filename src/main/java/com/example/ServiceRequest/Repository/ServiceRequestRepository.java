package com.example.ServiceRequest.Repository;

import com.example.ServiceRequest.Model.ServiceRequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequestDTO, String> {
}
