// This declares the service-layer package.
package com.interview.healthcare.patient.service_ServiceLayer;
// This imports the patient entity.
import com.interview.healthcare.patient.entity_Hibernate.PatientEntity_Hibernate;
// This imports the JPA repository.
import com.interview.healthcare.patient.repository_JPA.PatientRepository_JPA;
// This imports the Spring service annotation.
import org.springframework.stereotype.Service;
// This imports the list type returned by findAll.
import java.util.List;
// This marks this class as business logic managed by Spring.
@Service
// This class keeps business rules out of the REST controller.
public class PatientService_ServiceLayer {
// This holds the repository dependency used for database work.
    private final PatientRepository_JPA repository;
// This constructor receives the repository through dependency injection.
    public PatientService_ServiceLayer(PatientRepository_JPA repository) { this.repository = repository; }
// This creates a patient after preventing a duplicate medical record number.
    public PatientEntity_Hibernate create(PatientEntity_Hibernate patient) {
// This checks whether the medical record number already exists.
        repository.findByMedicalRecordNumber(patient.getMedicalRecordNumber()).ifPresent(existing -> {
// This throws a clear business error for a duplicate record.
            throw new IllegalArgumentException("Medical record number already exists");
// This closes the duplicate-check callback.
        });
// This asks JPA/Hibernate to insert the row.
        return repository.save(patient);
// This closes the create method.
    }
// This returns all patients.
    public List<PatientEntity_Hibernate> readAll() { return repository.findAll(); }
// This reads one patient or throws when the ID is invalid.
    public PatientEntity_Hibernate read(Long id) { return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found")); }
// This updates an existing patient.
    public PatientEntity_Hibernate update(Long id, PatientEntity_Hibernate request) {
// This first loads the row so a missing ID cannot silently create a new record.
        PatientEntity_Hibernate current = read(id);
// This copies the new first name.
        current.setFirstName(request.getFirstName());
// This copies the new last name.
        current.setLastName(request.getLastName());
// This copies the new medical record number.
        current.setMedicalRecordNumber(request.getMedicalRecordNumber());
// This asks Hibernate to issue the SQL update.
        return repository.save(current);
// This closes the update method.
    }
// This deletes an existing patient.
    public void delete(Long id) {
// This verifies the patient exists before deletion.
        read(id);
// This asks JPA/Hibernate to delete the row by primary key.
        repository.deleteById(id);
// This closes the delete method.
    }
// This closes the service class.
}
