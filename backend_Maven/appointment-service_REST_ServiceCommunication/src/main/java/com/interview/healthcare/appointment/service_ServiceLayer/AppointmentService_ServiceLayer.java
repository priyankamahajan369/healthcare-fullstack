// This declares the appointment service package.
package com.interview.healthcare.appointment.service_ServiceLayer;
// This imports the patient REST client.
import com.interview.healthcare.appointment.client_ServiceCommunication.PatientClient_ServiceCommunication;
// This imports the appointment entity.
import com.interview.healthcare.appointment.entity_Hibernate.AppointmentEntity_Hibernate;
// This imports the appointment repository.
import com.interview.healthcare.appointment.repository_JPA.AppointmentRepository_JPA;
// This imports the Spring service annotation.
import org.springframework.stereotype.Service;
// This imports list results.
import java.util.List;
// This marks this class as appointment business logic.
@Service
// This class coordinates validation, service communication and persistence.
public class AppointmentService_ServiceLayer {
// This stores the appointment database repository.
    private final AppointmentRepository_JPA repository;
// This stores the Patient Service integration client.
    private final PatientClient_ServiceCommunication patientClient;
// This constructor receives both dependencies.
    public AppointmentService_ServiceLayer(AppointmentRepository_JPA repository, PatientClient_ServiceCommunication patientClient) {
// This saves the injected repository.
        this.repository = repository;
// This saves the injected REST client.
        this.patientClient = patientClient;
// This closes the constructor.
    }
// This creates an appointment only for a valid patient.
    public AppointmentEntity_Hibernate create(AppointmentEntity_Hibernate appointment) {
// This calls Patient Service before writing appointment data.
        if (!patientClient.patientExists(appointment.getPatientId())) {
// This rejects an invalid cross-service patient reference.
            throw new IllegalArgumentException("Patient does not exist");
// This closes the validation condition.
        }
// This inserts the appointment through JPA/Hibernate.
        return repository.save(appointment);
// This closes the create method.
    }
// This returns all appointments.
    public List<AppointmentEntity_Hibernate> readAll() { return repository.findAll(); }
// This returns one appointment or a clear error.
    public AppointmentEntity_Hibernate read(Long id) { return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Appointment not found")); }
// This updates an existing appointment.
    public AppointmentEntity_Hibernate update(Long id, AppointmentEntity_Hibernate request) {
// This loads the current appointment.
        AppointmentEntity_Hibernate current = read(id);
// This verifies that the newly selected patient still exists.
        if (!patientClient.patientExists(request.getPatientId())) throw new IllegalArgumentException("Patient does not exist");
// This copies the patient reference.
        current.setPatientId(request.getPatientId());
// This copies the new appointment time.
        current.setAppointmentTime(request.getAppointmentTime());
// This copies the new reason.
        current.setReason(request.getReason());
// This saves the update.
        return repository.save(current);
// This closes the update method.
    }
// This deletes an appointment.
    public void delete(Long id) { read(id); repository.deleteById(id); }
// This closes the service class.
}
