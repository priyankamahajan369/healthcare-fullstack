// This imports Vite configuration support.
import { defineConfig } from 'vite';
// This imports React handling for Vite.
import react from '@vitejs/plugin-react';
// This exports the React-enabled Vite configuration.
export default defineConfig({ plugins: [react()] });
