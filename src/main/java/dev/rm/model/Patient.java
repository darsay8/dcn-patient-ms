package dev.rm.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long patientId;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "status")
    private String status;

    @Column(name = "date_of_admission")
    private LocalDateTime dateOfAdmission;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        dateOfAdmission = LocalDateTime.now();
    }
}