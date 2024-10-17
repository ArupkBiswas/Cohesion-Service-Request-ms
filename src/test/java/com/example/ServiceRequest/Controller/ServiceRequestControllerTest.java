package com.example.ServiceRequest.Controller;

import com.example.ServiceRequest.Model.ServiceRequestDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceRequestControllerTest {

    @Mock
    ServiceRequestController serviceRequestController;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void fetchAllServiceRequest() {
        ResponseEntity<List<ServiceRequestDTO>> listResponseEntity = serviceRequestController.fetchAllServiceRequest();
        Assertions.assertEquals(200, listResponseEntity.getStatusCode().value(), 200);
    }
}