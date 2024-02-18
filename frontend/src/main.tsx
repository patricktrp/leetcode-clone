import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import {
  createBrowserRouter,
  RouterProvider,
} from 'react-router-dom'
import Root from '@/pages/root'
import ProblemWorkspace from '@/pages/problem-workspace'
import ProblemSelection from '@/pages/problem-selection'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'

const queryClient = new QueryClient()

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
  },
  {
    path: "/problems",
    element: <ProblemSelection />
  },
  {
    path: "/problems/:problemId",
    element: <ProblemWorkspace />
  }
])

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
      <RouterProvider router={router} />
    </QueryClientProvider>
  </React.StrictMode>,
)
