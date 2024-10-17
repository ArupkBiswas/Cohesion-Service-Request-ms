package com.example.ServiceRequest.Controller;

import com.example.ServiceRequest.Model.ServiceReqRequest;
import com.example.ServiceRequest.Model.ServiceRequestDTO;
import com.example.ServiceRequest.Service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@RestController
@RequestMapping(value = "/api")
public class ServiceRequestController {

    private final ServiceRequestService serviceRequestService;

    @Autowired
    public ServiceRequestController(ServiceRequestService serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }

    @GetMapping(value = "/serviceRequest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServiceRequestDTO>> fetchAllServiceRequest() {
        return ResponseEntity.ok(serviceRequestService.getAllServiceRequest());
    }

    @PostMapping(value = "/serviceRequest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceRequestDTO> createServiceRequest(@RequestBody ServiceRequestDTO serviceRequestDTO) {
        return ResponseEntity.ok(serviceRequestService.saveServiceRequest(serviceRequestDTO));
    }

    @PutMapping(value = "/serviceRequest/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateServiceRequest(@PathVariable(value = "id") UUID id,
                                        @RequestBody ServiceRequestDTO serviceRequestDTO) {
        boolean allRequests = serviceRequestService.updateServiceRequest(id, serviceRequestDTO);
        return !allRequests;

    }


    @DeleteMapping(value = "/serviceRequest/{id}")
    public void deleteServiceRequest(@PathVariable(value = "id") UUID id) {
        serviceRequestService.deleteServiceRequest(id);
    }

}
