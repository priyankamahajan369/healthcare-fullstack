// This imports Axios for browser HTTP requests.
import axios from 'axios';
// This creates a reusable client for Patient Service.
export const patientApi = axios.create({ baseURL: import.meta.env.VITE_PATIENT_API || 'http://localhost:8081/api' });
// This creates a reusable client for Appointment Service.
export const appointmentApi = axios.create({ baseURL: import.meta.env.VITE_APPOINTMENT_API || 'http://localhost:8082/api' });
