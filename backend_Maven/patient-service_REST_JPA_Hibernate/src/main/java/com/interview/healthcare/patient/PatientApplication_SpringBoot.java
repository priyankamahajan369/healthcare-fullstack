// This declares the package for the patient service.
package com.interview.healthcare.patient;
// This imports the Spring Boot launcher helper.
import org.springframework.boot.SpringApplication;
// This imports the annotation that enables Spring Boot auto-configuration.
import org.springframework.boot.autoconfigure.SpringBootApplication;
// This marks this class as the starting point of the patient microservice.
@SpringBootApplication
// This public class starts the patient service.
public class PatientApplication_SpringBoot {
// This main method runs when the service starts.
    public static void main(String[] args) {
// This boots Spring, creates beans, and starts the embedded web server.
        SpringApplication.run(PatientApplication_SpringBoot.class, args);
// This closes the main method.
    }
// This closes the class.
}
