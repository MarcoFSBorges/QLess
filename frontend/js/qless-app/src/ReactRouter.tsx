import {BrowserRouter as Router, Route, Routes} from "react-router-dom"
import './ReactRouter.css'
import { Login } from './Login'
import { Signup } from './Signup'
import { ForgotPassword } from './ForgotPassword'
import { ResetPassword } from "./ResetPassword"
import { UserHomePage } from "./UserHomePage"
import { UserNavBar } from "./UserNavBar"

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

