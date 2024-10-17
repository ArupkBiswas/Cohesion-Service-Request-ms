package com.example.ServiceRequest.Service;

import com.example.ServiceRequest.Model.ServiceRequestDTO;
import com.example.ServiceRequest.Repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceRequestService {

    private final ServiceRequestRepository serviceResponseRepository;

    @Autowired
    public ServiceRequestService(ServiceRequestRepository serviceResponseRepository) {
        this.serviceResponseRepository = serviceResponseRepository;
    }

    public List<ServiceRequestDTO> getAllServiceRequest(){
        return serviceResponseRepository.findAll();
    }

    public boolean saveServiceRequest(ServiceRequestDTO serviceRequestDTO) {
        ServiceRequestDTO newServ = ServiceRequestDTO.builder()
                .buildingCode(serviceRequestDTO.getBuildingCode())
                .createdBy(serviceRequestDTO.getCreatedBy())
                .createdDate(serviceRequestDTO.getCreatedDate())
                .currentStatus(serviceRequestDTO.getCurrentStatus())
                .description(serviceRequestDTO.getDescription())
                .lastModifiedBy(serviceRequestDTO.getLastModifiedBy())
                .lastModifiedDate(serviceRequestDTO.getLastModifiedDate())
                .build();
         serviceResponseRepository.save(newServ);
         return true;
    }

    public void deleteServiceRequest(UUID id) {
        serviceResponseRepository.deleteById(String.valueOf(id));
    }

    public boolean updateServiceRequest(UUID id, ServiceRequestDTO serviceRequestDTO) {
        final Optional<ServiceRequestDTO> serviceReq = serviceResponseRepository.findById(String.valueOf(id));
        if(serviceReq.isEmpty()){
            throw new InputMismatchException("Id not found");
        } else {
            serviceResponseRepository.save(serviceRequestDTO);
        }
        return  true;
    }

}