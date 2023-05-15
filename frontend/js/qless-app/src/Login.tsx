import { useState } from 'react';
import {BrowserRouter as Router, Link, Route, Routes} from "react-router-dom"
import './Login.css';
import { ForgotPassword } from './ForgotPassword';
import logo from './images/QL_1.png'

export function Login(props: any) {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e: any) => {
        e.preventDefault();
    }

    return (
        <div>
            <div className="auth-form">
            <h1 className='formtitle'>Login to QLess</h1>
                <form onSubmit={handleSubmit}>
                    <label className="inputlabeltxt" htmlFor="username">Username</label><br/>
                    <input className="inputform" value={username} onChange={(e) => setUsername(e.target.value)} type="username" id="username" name="username"/>
                    <p/>
                    <label className="inputlabeltxt" htmlFor="password">Password</label><br/>
                    <input className="inputform" value={password}  onChange={(e) => setPassword(e.target.value)} type="password" id="password" name="password"/><br/>
                    <Link to="/forgot">
                        <button  className="forgotpassbtn">Forgot password?</button><p></p>
                    </Link>         
                    <label  className="noacctxt" htmlFor="signup">Don't have an account?</label><br/>
                    <div className="flex-container">
                        <Link to="/signup"> 
                            <button className="signupbtn" type="submit" id="signup" name="signup">Sign up</button>
                        </Link>
                        <button className="loginbtn" type="submit">Login</button>
                    </div>
                </form>                        
            </div>
        </div>
  
    );
}

    

