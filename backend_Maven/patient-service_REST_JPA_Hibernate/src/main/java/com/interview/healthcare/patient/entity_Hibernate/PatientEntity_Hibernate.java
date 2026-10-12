// This declares the entity package.
package com.interview.healthcare.patient.entity_Hibernate;
// This imports JPA mapping annotations implemented by Hibernate.
import jakarta.persistence.*;
// This imports validation for required text.
import jakarta.validation.constraints.NotBlank;
// This marks this Java class as a JPA entity that Hibernate persists.
@Entity
// This maps the entity to the patients table.
@Table(name = "patients")
// This class represents one patient row.
public class PatientEntity_Hibernate {
// This marks id as the database primary key.
    @Id
// This asks PostgreSQL to generate numeric IDs.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
// This stores the unique patient ID.
    private Long id;
// This rejects blank first names during request validation.
    @NotBlank
// This stores the patient first name.
    private String firstName;
// This rejects blank last names.
    @NotBlank
// This stores the patient last name.
    private String lastName;
// This makes medical record number required and unique.
    @Column(nullable = false, unique = true)
// This stores a safe demo medical record identifier.
    private String medicalRecordNumber;
// This provides the empty constructor JPA needs.
    public PatientEntity_Hibernate() {}
// This returns the patient ID.
    public Long getId() { return id; }
// This updates the patient ID.
    public void setId(Long id) { this.id = id; }
// This returns the first name.
    public String getFirstName() { return firstName; }
// This updates the first name.
    public void setFirstName(String firstName) { this.firstName = firstName; }
// This returns the last name.
    public String getLastName() { return lastName; }
// This updates the last name.
    public void setLastName(String lastName) { this.lastName = lastName; }
// This returns the medical record number.
    public String getMedicalRecordNumber() { return medicalRecordNumber; }
// This updates the medical record number.
    public void setMedicalRecordNumber(String medicalRecordNumber) { this.medicalRecordNumber = medicalRecordNumber; }
// This closes the entity class.
}
