package com.example.ServiceRequest.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Builder
public class ServiceReqRequest {
    UUID id;
    String buildingCode;
    String description;
    String currentStatus;
    String createdBy;
    String createdDate;
    Date lastModifiedBy;
    Date lastModifiedDate;
}
