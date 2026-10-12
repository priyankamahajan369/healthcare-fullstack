// This imports Redux Toolkit helpers for state management and asynchronous REST calls.
import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
// This imports the reusable Patient Service HTTP client.
import { patientApi } from '../api_REST_API/apiClient_REST_API.js';
// This asynchronous action reads every patient from the Patient REST API.
export const loadPatients = createAsyncThunk('patients/load', async () => (await patientApi.get('/patients')).data);
// This asynchronous action creates a patient through HTTP POST.
export const createPatient = createAsyncThunk('patients/create', async (patient) => (await patientApi.post('/patients', patient)).data);
// This asynchronous action updates a patient through HTTP PUT.
export const updatePatient = createAsyncThunk('patients/update', async ({ id, patient }) => (await patientApi.put(`/patients/${id}`, patient)).data);
// This asynchronous action deletes a patient through HTTP DELETE.
export const deletePatient = createAsyncThunk('patients/delete', async (id) => { await patientApi.delete(`/patients/${id}`); return id; });
// This creates the centralized Redux feature state for patients.
const slice = createSlice({
  // This gives the feature a readable Redux namespace.
  name: 'patients',
  // This defines the initial patient feature state.
  initialState: { items: [], status: 'idle', error: null },
  // This project uses async actions, so no regular reducers are required here.
  reducers: {},
  // This updates Redux state for every REST call lifecycle.
  extraReducers: (builder) => builder
    // This marks the patient list as loading while GET is running.
    .addCase(loadPatients.pending, (state) => { state.status = 'loading'; state.error = null; })
    // This stores the patients returned by the backend after GET succeeds.
    .addCase(loadPatients.fulfilled, (state, action) => { state.status = 'succeeded'; state.items = action.payload; })
    // This stores a friendly error when GET fails.
    .addCase(loadPatients.rejected, (state, action) => { state.status = 'failed'; state.error = action.error.message; })
    // This adds the patient returned by the backend after POST succeeds.
    .addCase(createPatient.fulfilled, (state, action) => { state.items.push(action.payload); })
    // This replaces the matching patient after PUT succeeds.
    .addCase(updatePatient.fulfilled, (state, action) => { const index = state.items.findIndex((patient) => patient.id === action.payload.id); if (index >= 0) state.items[index] = action.payload; })
    // This removes the deleted patient from browser state after DELETE succeeds.
    .addCase(deletePatient.fulfilled, (state, action) => { state.items = state.items.filter((patient) => patient.id !== action.payload); })
// This closes the Redux slice configuration.
});
// This exports the generated reducer for the global Redux store.
export default slice.reducer;
