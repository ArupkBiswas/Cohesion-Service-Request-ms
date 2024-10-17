package com.example.ServiceRequest.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "service", name = "service_request")
public class ServiceRequestDTO {
    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "ID", nullable = false)
    private UUID id;

    @Column(name = "building_code")
    private String buildingCode;

    @Column(name = "description")
    private String description;

    @Column(name = "current_status")
    private String currentStatus;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_ate")
    private Date lastModifiedDate;

}
