// This declares the appointment service package.
package com.interview.healthcare.appointment;
// This imports Spring Boot startup support.
import org.springframework.boot.SpringApplication;
// This imports Spring Boot auto-configuration.
import org.springframework.boot.autoconfigure.SpringBootApplication;
// This imports the bean annotation used for RestClient.
import org.springframework.context.annotation.Bean;
// This imports Spring RestClient for service-to-service HTTP calls.
import org.springframework.web.client.RestClient;
// This marks the application starting class.
@SpringBootApplication
// This class starts the appointment microservice.
public class AppointmentApplication_SpringBoot {
// This runs the Spring Boot service.
    public static void main(String[] args) { SpringApplication.run(AppointmentApplication_SpringBoot.class, args); }
// This creates a reusable RestClient builder managed by Spring.
    @Bean
// This method exposes the RestClient builder for dependency injection.
    RestClient.Builder restClientBuilder() { return RestClient.builder(); }
// This closes the application class.
}
