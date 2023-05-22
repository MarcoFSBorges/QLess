import { useState } from 'react'
import { Paper, Stack, Typography, TextField, Button} from '@mui/material';
import logo from '../images/QL_1.png'

export function Signup() {

    const [username, setUsername] = useState('');
    const [fname, setFname] = useState('');
    const [lname, setLname] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e: any) => {
        e.preventDefault();
    }

    return (
        <>
            <Stack direction='row' justifyContent='center' height='300px'>
                <img src={logo} className='qlesslogo' alt="qless-logo"/>
            </Stack>
            
            <p/>
            <form onSubmit={handleSubmit}>
                <Stack direction='row' justifyContent='center'>
                    <Paper 
                        elevation={24}
                        sx={{padding: '16px', width: '50vh'}}>

                        <Typography align='center' variant='h4' fontFamily='sans-serif' sx={{padding:'4px'}}>Sign up to QLess</Typography>
                        <Stack direction='column'>
                            <TextField 
                                label='Username' 
                                variant='outlined' 
                                value={username} 
                                onChange={e => setUsername(e.target.value)}
                                sx={{padding:'4px'}}
                            />
                        </Stack>
                        <p/>
                        <Stack direction='column'>
                            <TextField 
                                label='First Name' 
                                variant='outlined' 
                                value={fname} 
                                onChange={e => setFname(e.target.value)}
                                sx={{padding:'4px'}}
                            />
                        </Stack>
                        <p/>
                        <Stack direction='column'>
                            <TextField 
                                label='Last Name' 
                                variant='outlined' 
                                value={lname} 
                                onChange={e => setLname(e.target.value)}
                                sx={{padding:'4px'}}
                            />
                        </Stack>
                        <p/>
                        <Stack direction='column'>
                            <TextField 
                                label='Email' 
                                variant='outlined' 
                                value={email} 
                                onChange={e => setEmail(e.target.value)}
                                sx={{padding:'4px'}}
                            />
                        </Stack>
                        <p/>
                        
                        <Stack direction='column'>
                            <TextField 
                                label='Password' 
                                type='password' 
                                variant='outlined'
                                value={password}
                                onChange={e => setPassword(e.target.value)}  
                                sx={{padding:'4px'}}  
                            />
                        </Stack>
                        <p/>   
                        <Stack direction='column' >
                        <Typography align='left' variant='subtitle1'>Already have an account?</Typography>
                            <Stack spacing={24} direction='row'>
                                <Button variant='outlined' href='/login' sx={{border: 1, borderColor: 'black', backgroundColor: "#e0e0e0", color:'black'}}>Login</Button>
                                <Button variant='outlined' type='submit' sx={{ border: 1, borderColor: 'black',backgroundColor: "#e0e0e0", color:'black'}}>Sign up</Button>  
                            </Stack>
                        </Stack>
                    </Paper>       
                </Stack> 
            </form>                         
        </>      
    );
}
