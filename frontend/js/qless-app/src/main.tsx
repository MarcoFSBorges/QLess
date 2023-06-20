import React from 'react'
import { createRoot } from 'react-dom/client'
import ReactRouter from './ReactRouter'
import './index.css'

const root = createRoot(document.getElementById('root')!);
root.render(
  <React.StrictMode>
    <ReactRouter />
  </React.StrictMode>
);