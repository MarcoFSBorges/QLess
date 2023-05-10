import { useState } from 'react'
import './App.css'
import { Login } from './Login'
import { Signup } from './Signup'
import logo from './images/QL_1.png'

function App() {
  const [currForm, setCurrForm] = useState('login')

  const toggleForm = (formName: string) => {
    setCurrForm(formName)
  }

  return (
    <div className="App">
      <img src={logo} className='qlesslogo' alt=""/>
      {
        currForm === "login" ? <Login onFormSwitch={toggleForm}/> : <Signup onFormSwitch={toggleForm}/>
      }
    </div>
  )
}

export default App
