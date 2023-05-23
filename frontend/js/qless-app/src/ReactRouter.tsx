import {BrowserRouter as Router, Route, Routes} from "react-router-dom"
import './ReactRouter.css'
import { Login } from './components/Login'
import { Signup } from './components/Signup'
import { ForgotPassword } from './components/ForgotPassword'
import { ResetPassword } from "./components/ResetPassword"
import { UserHomePage } from "./components/UserHomePage"
import { UserNavBar } from "./components/UserNavBar"

function ReactRouter() {
  return (
    <Router>
      <div className="reactrouter">
        <Routes>
          <Route path="/login" element={<Login/>}/>
          <Route path="/signup" element={<Signup/>}/>
          <Route path="/forgot" element={<ForgotPassword/>}/>
          <Route path="/reset/:resetId" element={<ResetPassword/>}/>
          <Route 
            path="/tickets/:qlessId" 
            element= {
              <>
                <UserNavBar/>
                <UserHomePage/>
              </>
              
          
          }/>
        </Routes>  
      </div>
    </Router>
    
  )
}

export default ReactRouter

