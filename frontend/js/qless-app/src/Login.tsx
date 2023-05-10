import { useState } from 'react';
import './Login.css';
import { Signup } from './Signup';

export function Login(props: any) {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e: any) => {
        e.preventDefault();
    }

    return (
        <div className="auth-form">
            <h1 className='formtitle'>Login to QLess</h1>
                <form onSubmit={handleSubmit}>
                    <label className="inputlabeltxt" htmlFor="username">Username</label><br/>
                    <input className="inputform" value={username} onChange={(e) => setUsername(e.target.value)} type="username" placeholder="Your username" id="username" name="username"/>
                    <p/>
                    <label className="inputlabeltxt" htmlFor="password">Password</label><br/>
                    <input className="inputform" value={password}  onChange={(e) => setPassword(e.target.value)} type="password" id="password" name="password"/><br/>
                    <label  className="forgotpass" onClick={Signup /* ForgotPassword */} htmlFor="signup">Forgot password?</label><p></p>
                    <label  className="noacctxt" htmlFor="signup">Don't have an account?</label><br/>
                    <div className="flex-container">
                        <button className="signupbtn" onClick={() => props.onFormSwitch('register')} type="submit" id="signup" name="signup">Sign up</button>
                        <button className="loginbtn" type="submit">Login</button>
                    </div>
                </form>                        
        </div>
    );
}

    

