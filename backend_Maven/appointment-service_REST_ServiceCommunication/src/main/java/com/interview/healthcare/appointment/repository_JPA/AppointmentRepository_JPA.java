// This declares the appointment repository package.
package com.interview.healthcare.appointment.repository_JPA;
// This imports the appointment entity.
import com.interview.healthcare.appointment.entity_Hibernate.AppointmentEntity_Hibernate;
// This imports the Spring Data JPA base repository.
import org.springframework.data.jpa.repository.JpaRepository;
// This interface automatically receives standard CRUD methods.
public interface AppointmentRepository_JPA extends JpaRepository<AppointmentEntity_Hibernate, Long> {
// This closes the repository.
}
