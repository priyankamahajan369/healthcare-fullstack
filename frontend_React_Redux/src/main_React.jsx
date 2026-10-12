// This imports React.
import React from 'react';
// This imports React DOM rendering.
import ReactDOM from 'react-dom/client';
// This imports the Redux Provider.
import { Provider } from 'react-redux';
// This imports our centralized Redux store.
import { store } from './store_Redux.js';
// This imports the main UI component.
import App_React from './App_React.jsx';
// This imports colorful styling.
import './styles_React.css';
// This finds the root HTML element and starts React rendering.
ReactDOM.createRoot(document.getElementById('root')).render(
  // This makes Redux state available to every child component.
  <Provider store={store}>
    // This renders the healthcare dashboard.
    <App_React />
  // This closes the Redux provider.
  </Provider>
// This closes the render call.
);
