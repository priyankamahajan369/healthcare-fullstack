// This declares the service communication client package.
package com.interview.healthcare.appointment.client_ServiceCommunication;
// This imports Spring value injection.
import org.springframework.beans.factory.annotation.Value;
// This imports the component annotation.
import org.springframework.stereotype.Component;
// This imports Spring RestClient for HTTP communication.
import org.springframework.web.client.RestClient;
// This marks this class as an injectable integration component.
@Component
// This class contains the REST call from Appointment Service to Patient Service.
public class PatientClient_ServiceCommunication {
// This stores a RestClient already configured with the Patient Service base URL.
    private final RestClient client;
// This constructor receives the builder and environment-specific Patient Service URL.
    public PatientClient_ServiceCommunication(RestClient.Builder builder, @Value("${patient-service.base-url}") String baseUrl) {
// This creates the reusable HTTP client.
        this.client = builder.baseUrl(baseUrl).build();
// This closes the constructor.
    }
// This method checks that Patient Service can return the requested patient.
    public boolean patientExists(Long patientId) {
// This performs GET /api/patients/{id} on Patient Service.
        PatientSummary response = client.get().uri("/api/patients/{id}", patientId).retrieve().body(PatientSummary.class);
// This returns true only when a patient object came back.
        return response != null && response.id() != null;
// This closes the validation method.
    }
// This record represents only the patient fields Appointment Service needs.
    public record PatientSummary(Long id, String firstName, String lastName, String medicalRecordNumber) {}
// This closes the client class.
}
