// This declares the appointment entity package.
package com.interview.healthcare.appointment.entity_Hibernate;
// This imports JPA/Hibernate mapping annotations.
import jakarta.persistence.*;
// This imports Java date and time.
import java.time.LocalDateTime;
// This marks the class as a persistent JPA entity.
@Entity
// This maps the entity to the appointments table.
@Table(name = "appointments")
// This class represents one appointment record.
public class AppointmentEntity_Hibernate {
// This marks the primary key.
    @Id
// This lets PostgreSQL generate IDs.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
// This stores the appointment ID.
    private Long id;
// This stores the patient ID owned by Patient Service.
    @Column(nullable = false)
// This keeps only the external patient reference, not a cross-database JPA relationship.
    private Long patientId;
// This stores the appointment date/time.
    @Column(nullable = false)
// This field is required for scheduling.
    private LocalDateTime appointmentTime;
// This stores a simple reason for the visit.
    private String reason;
// This provides the no-argument constructor required by JPA.
    public AppointmentEntity_Hibernate() {}
// This returns the ID.
    public Long getId() { return id; }
// This updates the ID.
    public void setId(Long id) { this.id = id; }
// This returns the patient ID.
    public Long getPatientId() { return patientId; }
// This updates the patient ID.
    public void setPatientId(Long patientId) { this.patientId = patientId; }
// This returns the appointment time.
    public LocalDateTime getAppointmentTime() { return appointmentTime; }
// This updates the appointment time.
    public void setAppointmentTime(LocalDateTime appointmentTime) { this.appointmentTime = appointmentTime; }
// This returns the visit reason.
    public String getReason() { return reason; }
// This updates the visit reason.
    public void setReason(String reason) { this.reason = reason; }
// This closes the entity class.
}
