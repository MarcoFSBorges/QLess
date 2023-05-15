import { useState } from 'react';
import './ForgotPassword.css';

export function ForgotPassword() {

    const [email, setEmail] = useState('');

    const handleSubmit = (e: any) => {
        e.preventDefault();
    }

    return (
        <div className="auth-form">
            <button className="backbtn" onClick={() => history.back()}>&larr; Back</button>
            <h1 className='formtitle'>Forgot Password</h1>
                <form onSubmit={handleSubmit}>
                    <label className="labeltxt" htmlFor="email">Email</label><br/>
                    <input className="inputform" value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="Your email" id="email" name="email"/>
                    <p/>
                    <div className="flex-container">
                        <button className="submitbtn" onClick={() => null} type="submit" id="signup" name="signup">Submit</button>
                    </div>
                </form>                        
        </div>
    );

}