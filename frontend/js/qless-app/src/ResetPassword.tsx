import { useState } from 'react';
import './ResetPassword.css';

export function ResetPassword() {

    const [password, setPassword] = useState('');
    const [confirmPass, setConfPassword] = useState('');

    const handleSubmit = (e: any) => {
        e.preventDefault();
    }

    return (
        <div className="auth-form">
            <h1 className='formtitle'>Reset Password</h1>
                <form onSubmit={handleSubmit}>
                    <label className="passlabeltxt" htmlFor="password">New password</label><br/>
                    <input className="inputform" value={password} onChange={(e) => setPassword(e.target.value)} type="password" id="password" name="password"/>
                    <p/>
                    <label className="passlabeltxtv2" htmlFor="password">Confirm password</label><br/>
                    <input className="inputform" value={confirmPass} onChange={(e) => setConfPassword(e.target.value)} type="password" id="password" name="password"/>
                    <p/>
                    <div className="flex-container">
                        <button className="submitbtn" onClick={() => null} type="submit" id="signup" name="signup">Submit</button>
                    </div>
                </form>                        
        </div>
    );

}