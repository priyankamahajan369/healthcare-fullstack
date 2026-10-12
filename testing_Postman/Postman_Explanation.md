# Postman testing order
1. Create patient with POST. Check HTTP success and returned ID.
2. Read with GET and verify persisted data.
3. Update with PUT and verify changed field.
4. Create appointment using that patient ID; Appointment Service first calls Patient Service.
5. Delete appointment, then patient.

This collection JSON cannot contain comments, so this companion file explains the test flow.
