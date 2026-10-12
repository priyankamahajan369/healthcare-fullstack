// This declares the appointment REST controller package.
package com.interview.healthcare.appointment.controller_REST_API;
// This imports the appointment entity.
import com.interview.healthcare.appointment.entity_Hibernate.AppointmentEntity_Hibernate;
// This imports appointment business logic.
import com.interview.healthcare.appointment.service_ServiceLayer.AppointmentService_ServiceLayer;
// This imports Spring MVC REST annotations.
import org.springframework.web.bind.annotation.*;
// This imports list responses.
import java.util.List;
// This makes the class a JSON REST controller.
@RestController
// This defines the appointment API base path.
@RequestMapping("/api/appointments")
// This lets our React UI call this service locally.
@CrossOrigin(origins = "http://localhost:3000")
// This class exposes appointment CRUD operations over HTTP.
public class AppointmentController_REST_API {
// This stores the service layer.
    private final AppointmentService_ServiceLayer service;
// This injects the service layer.
    public AppointmentController_REST_API(AppointmentService_ServiceLayer service) { this.service = service; }
// This maps POST requests to create.
    @PostMapping
// This turns incoming JSON into an appointment object and creates it.
    public AppointmentEntity_Hibernate create(@RequestBody AppointmentEntity_Hibernate appointment) { return service.create(appointment); }
// This maps GET to read all appointments.
    @GetMapping
// This returns all appointments.
    public List<AppointmentEntity_Hibernate> readAll() { return service.readAll(); }
// This maps GET /{id} to read one appointment.
    @GetMapping("/{id}")
// This reads the requested appointment.
    public AppointmentEntity_Hibernate read(@PathVariable Long id) { return service.read(id); }
// This maps PUT /{id} to update.
    @PutMapping("/{id}")
// This performs the appointment update.
    public AppointmentEntity_Hibernate update(@PathVariable Long id, @RequestBody AppointmentEntity_Hibernate appointment) { return service.update(id, appointment); }
// This maps DELETE /{id} to delete.
    @DeleteMapping("/{id}")
// This deletes the appointment.
    public void delete(@PathVariable Long id) { service.delete(id); }
// This closes the controller.
}
