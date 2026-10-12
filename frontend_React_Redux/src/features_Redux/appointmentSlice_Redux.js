// This imports Redux Toolkit helpers for state and asynchronous REST calls.
import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
// This imports the reusable Appointment Service HTTP client.
import { appointmentApi } from '../api_REST_API/apiClient_REST_API.js';
// This asynchronous action reads all appointments through HTTP GET.
export const loadAppointments = createAsyncThunk('appointments/load', async () => (await appointmentApi.get('/appointments')).data);
// This asynchronous action creates an appointment through HTTP POST.
export const createAppointment = createAsyncThunk('appointments/create', async (appointment) => (await appointmentApi.post('/appointments', appointment)).data);
// This asynchronous action updates an appointment through HTTP PUT.
export const updateAppointment = createAsyncThunk('appointments/update', async ({ id, appointment }) => (await appointmentApi.put(`/appointments/${id}`, appointment)).data);
// This asynchronous action deletes an appointment through HTTP DELETE.
export const deleteAppointment = createAsyncThunk('appointments/delete', async (id) => { await appointmentApi.delete(`/appointments/${id}`); return id; });
// This creates the centralized Redux feature state for appointments.
const slice = createSlice({
  // This gives the feature a readable Redux namespace.
  name: 'appointments',
  // This defines the initial appointment state.
  initialState: { items: [], status: 'idle', error: null },
  // This project uses asynchronous actions, so regular reducers are not required here.
  reducers: {},
  // This responds to every REST request lifecycle.
  extraReducers: (builder) => builder
    // This marks the appointment list as loading while GET is running.
    .addCase(loadAppointments.pending, (state) => { state.status = 'loading'; state.error = null; })
    // This stores appointments returned by the backend after GET succeeds.
    .addCase(loadAppointments.fulfilled, (state, action) => { state.status = 'succeeded'; state.items = action.payload; })
    // This stores a friendly error when GET fails.
    .addCase(loadAppointments.rejected, (state, action) => { state.status = 'failed'; state.error = action.error.message; })
    // This adds the appointment returned by POST.
    .addCase(createAppointment.fulfilled, (state, action) => { state.items.push(action.payload); })
    // This replaces the matching appointment after PUT succeeds.
    .addCase(updateAppointment.fulfilled, (state, action) => { const index = state.items.findIndex((appointment) => appointment.id === action.payload.id); if (index >= 0) state.items[index] = action.payload; })
    // This removes the appointment after DELETE succeeds.
    .addCase(deleteAppointment.fulfilled, (state, action) => { state.items = state.items.filter((appointment) => appointment.id !== action.payload); })
// This closes the Redux slice configuration.
});
// This exports the generated reducer for the global Redux store.
export default slice.reducer;
