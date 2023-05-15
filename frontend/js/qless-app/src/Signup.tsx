import { useState } from 'react'
import './Signup.css'
import { Link } from 'react-router-dom';

export function Signup(props: any) {

    const [username, setUsername] = useState('');
    const [fname, setFname] = useState('');
    const [lname, setLname] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e: any) => {
        e.preventDefault();
    }

    return (
        <div className="auth-form">
            <h1 className='formtitle'>Sign up to QLess</h1>
            <form onSubmit={handleSubmit}>
            <label className="inputlabeltxt" htmlFor="username">Username</label><br/>
            <input className="inputform" value={username} onChange={(e) => setUsername(e.target.value)} type="username"  id="username" name="username"/>
            <p/>
            <label className="inputlabeltxt" htmlFor="fname">First Name</label><br/>
            <input className="inputform" value={fname} onChange={(e) => setFname(e.target.value)} type="fname"  id="fname" name="fname"/>
            <p/>
            <label className="inputlabeltxt" htmlFor="lname">Last Name</label><br/>
            <input className="inputform" value={lname} onChange={(e) => setLname(e.target.value)} type="lname"  id="lname" name="lname"/>
            <p/>
            <label className="inputlabeltxtv2" htmlFor="email">Email</label><br/>
            <input className="inputform" value={email} onChange={(e) => setEmail(e.target.value)} type="email"  id="email" name="email"/>
            <p/>
            <label className="inputlabeltxt" htmlFor="password">Password</label><br/>
            <input className="inputform" value={password}  onChange={(e) => setPassword(e.target.value)} type="password" id="password" name="password"/><p/>
            
            <label  className="hasacctxt" htmlFor="signup">Already have an account?</label><br/>
            <div className="flex-containerv2">
                <Link to="/login">
                    <button className="loginbtnv2" type="submit">Login</button>
                </Link>
                <button className="signupbtnv2" type="submit" id="signup" name="signup">Sign up</button>
            </div>

            </form>
        </div>
        
    );
}
