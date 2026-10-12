// This declares the patient API test package.
package com.interview.healthcare.patient.controller_REST_API;
// This imports JUnit test annotation.
import org.junit.jupiter.api.Test;
// This imports Spring Boot integration testing.
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// This imports the full Spring Boot test context.
import org.springframework.boot.test.context.SpringBootTest;
// This imports dependency injection for MockMvc.
import org.springframework.beans.factory.annotation.Autowired;
// This imports MockMvc for HTTP-like testing without Postman.
import org.springframework.test.web.servlet.MockMvc;
// This imports HTTP test request builders.
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// This imports expected HTTP result matchers.
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// This starts the patient Spring application for integration tests.
@SpringBootTest(properties = {"spring.datasource.url=jdbc:h2:mem:testdb", "spring.jpa.hibernate.ddl-auto=create-drop"})
// This enables MockMvc.
@AutoConfigureMockMvc
// This class demonstrates automated API testing from Java code.
public class PatientControllerTest_PostmanAndJUnit {
// This injects MockMvc.
    @Autowired private MockMvc mvc;
// This marks one automated API test.
    @Test
// This test verifies GET /api/patients responds successfully.
    void readAllPatients_returns200() throws Exception {
// This performs the GET request and checks status 200.
        mvc.perform(get("/api/patients")).andExpect(status().isOk());
// This closes the test method.
    }
// This closes the test class.
}
