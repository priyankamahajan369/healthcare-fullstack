# Corporate Healthcare Operations Dashboard - Interview Guide

## What changed
This frontend is intentionally designed as an enterprise healthcare operations dashboard instead of a classroom CRUD screen.

## What to point to in the interview
- `src/App_React.jsx`: corporate dashboard, patient registry, appointment work queue, search, edit/delete actions, modal workflows, system integration screen.
- `src/features_Redux/patientSlice_Redux.js`: Redux async thunks for GET, POST, PUT, DELETE against Patient Service.
- `src/features_Redux/appointmentSlice_Redux.js`: Redux async thunks for GET, POST, PUT, DELETE against Appointment Service.
- `src/api_REST_API/apiClient_REST_API.js`: Axios clients and backend service URLs.
- `src/store_Redux.js`: centralized Redux store.
- `src/styles_React.css`: enterprise layout, sidebar, KPI cards, tables, service status, modals, and architecture view.

## 30-second UI explanation
"The frontend is a React operations dashboard. React renders the screens and local form interactions, while Redux Toolkit owns shared patient and appointment state. Async thunks call the Patient and Appointment Spring Boot REST APIs through Axios. The tables demonstrate GET, the create modals demonstrate POST, edit actions demonstrate PUT, and row actions demonstrate DELETE. Appointment creation also demonstrates service-to-service communication because Appointment Service validates the patient through Patient Service before persisting the appointment."
