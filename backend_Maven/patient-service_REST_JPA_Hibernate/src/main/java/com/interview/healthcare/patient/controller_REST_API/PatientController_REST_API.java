// This declares the REST controller package.
package com.interview.healthcare.patient.controller_REST_API;
// This imports the patient entity used as JSON request and response data.
import com.interview.healthcare.patient.entity_Hibernate.PatientEntity_Hibernate;
// This imports the business service.
import com.interview.healthcare.patient.service_ServiceLayer.PatientService_ServiceLayer;
// This imports validation support.
import jakarta.validation.Valid;
// This imports Spring MVC REST annotations.
import org.springframework.web.bind.annotation.*;
// This imports list responses.
import java.util.List;
// This tells Spring that return values should be serialized as JSON.
@RestController
// This gives every patient endpoint the /api/patients base URL.
@RequestMapping("/api/patients")
// This allows the local React development UI to call this service.
@CrossOrigin(origins = "http://localhost:3000")
// This class defines patient CRUD REST APIs.
public class PatientController_REST_API {
// This stores the service dependency.
    private final PatientService_ServiceLayer service;
// This constructor injects the service.
    public PatientController_REST_API(PatientService_ServiceLayer service) { this.service = service; }
// This maps HTTP POST to create a new patient.
    @PostMapping
// This validates JSON and passes it to business logic.
    public PatientEntity_Hibernate create(@Valid @RequestBody PatientEntity_Hibernate patient) { return service.create(patient); }
// This maps HTTP GET to read all patients.
    @GetMapping
// This returns every patient.
    public List<PatientEntity_Hibernate> readAll() { return service.readAll(); }
// This maps HTTP GET with an ID to read one patient.
    @GetMapping("/{id}")
// This reads the ID from the URL path.
    public PatientEntity_Hibernate read(@PathVariable Long id) { return service.read(id); }
// This maps HTTP PUT to update an existing patient.
    @PutMapping("/{id}")
// This combines the URL ID and incoming JSON for the update.
    public PatientEntity_Hibernate update(@PathVariable Long id, @Valid @RequestBody PatientEntity_Hibernate patient) { return service.update(id, patient); }
// This maps HTTP DELETE to remove a patient.
    @DeleteMapping("/{id}")
// This forwards the delete request to business logic.
    public void delete(@PathVariable Long id) { service.delete(id); }
// This closes the controller class.
}
