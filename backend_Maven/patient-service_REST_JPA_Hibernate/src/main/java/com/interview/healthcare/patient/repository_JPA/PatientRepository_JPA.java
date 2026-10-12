// This declares the repository package.
package com.interview.healthcare.patient.repository_JPA;
// This imports the patient entity type.
import com.interview.healthcare.patient.entity_Hibernate.PatientEntity_Hibernate;
// This imports Spring Data JPA CRUD support.
import org.springframework.data.jpa.repository.JpaRepository;
// This imports Optional for a value that may not exist.
import java.util.Optional;
// This repository gives us save, find, update and delete database operations without boilerplate SQL.
public interface PatientRepository_JPA extends JpaRepository<PatientEntity_Hibernate, Long> {
// This creates a query method used to check duplicate medical record numbers.
    Optional<PatientEntity_Hibernate> findByMedicalRecordNumber(String medicalRecordNumber);
// This closes the repository interface.
}
