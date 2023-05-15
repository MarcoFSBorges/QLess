import {BrowserRouter as Router, Route, Routes} from "react-router-dom"
import './ReactRouter.css'
import { Login } from './Login'
import { Signup } from './Signup'
import logo from './images/QL_1.png'
import { ForgotPassword } from './ForgotPassword'

function ReactRouter() {
  return (
    <Router>
      <div className="ReactRouter">
        <img src={logo} className='qlesslogo' alt=""/>
        <Routes>
          <Route path="/login" element={<Login/>}/>
          <Route path="/signup" element={<Signup/>}/>
          <Route path="/forgot" element={<ForgotPassword/>}/>
        </Routes>  
      </div>
    </Router>
    
  )
}

export default ReactRouter

