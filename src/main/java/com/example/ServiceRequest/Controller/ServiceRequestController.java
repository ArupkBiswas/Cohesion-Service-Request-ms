package com.example.ServiceRequest.Controller;

import com.example.ServiceRequest.Model.ServiceRequestDTO;
import com.example.ServiceRequest.Service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping(value = "/public/api")
public class ServiceRequestController {

    private final ServiceRequestService serviceRequestService;

    @Autowired
    public ServiceRequestController(ServiceRequestService serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }

    @GetMapping(value = "/serviceRequest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServiceRequestDTO>> fetchAllServiceRequest() {
        List<ServiceRequestDTO> allRequests = serviceRequestService.getAllServiceRequest();
        return ResponseEntity.ok(allRequests);
    }

    @PostMapping(value = "/serviceRequest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createServiceRequest(@RequestBody ServiceRequestDTO serviceRequestDTO) {
        boolean allRequests = serviceRequestService.saveServiceRequest(serviceRequestDTO);
        return ResponseEntity.ok(allRequests);
    }

    @PutMapping(value = "/serviceRequest/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<ServiceRequestDTO>> updateServiceRequest(@PathVariable(value = "id") UUID id,
                                                                            @RequestBody ServiceRequestDTO serviceRequestDTO) {
        boolean allRequests = serviceRequestService.updateServiceRequest(id, serviceRequestDTO);
        if(allRequests){
            return false;
        } else {
            return ResponseEntity.ok();
        }

    }


    @DeleteMapping(value = "/serviceRequest/{id}")
    public void deleteServiceRequest(@PathVariable(value = "id") UUID id) {
        serviceRequestService.deleteServiceRequest(id);
    }

}
