// This imports the Redux Toolkit store helper.
import { configureStore } from '@reduxjs/toolkit';
// This imports patient state logic.
import patientReducer from './features_Redux/patientSlice_Redux.js';
// This imports appointment state logic.
import appointmentReducer from './features_Redux/appointmentSlice_Redux.js';
// This creates one predictable application-wide Redux store.
export const store = configureStore({
  // This registers each feature state under a clear key.
  reducer: { patients: patientReducer, appointments: appointmentReducer }
// This closes store configuration.
});
