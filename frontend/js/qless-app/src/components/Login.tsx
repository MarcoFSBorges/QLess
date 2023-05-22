import { useState } from 'react';
import { Paper, Stack, Typography, TextField, Button, Link } from '@mui/material';
import logo from '../images/QL_1.png'

export function Login() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e: any) => {
        e.preventDefault();
    }

    return (
        <>
            <Stack direction='row' justifyContent='center' height='300px'>
                <img src={logo} alt="qless-logo"/>
            </Stack>
            
            <p/>
            <form onSubmit={handleSubmit}>
                <Stack direction='row' justifyContent='center'>
                    <Paper 
                        elevation={24}
                        sx={{padding: '24px', width: '52vh'}}>

                        <Typography align='center' variant='h3' fontFamily='sans-serif' sx={{padding:'4px'}}>Login to QLess</Typography>
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
                                label='Password' 
                                type='password' 
                                variant='outlined'
                                value={password}
                                onChange={e => setPassword(e.target.value)}  
                                sx={{padding:'4px'}}  
                            />
                            <Typography align='left' variant='subtitle2'>
                                <Link href='/forgot' underline='hover' color='#757575'>Forgot password?</Link>
                            </Typography>    
                        </Stack>
                        <p/>

                        <Stack direction='column' >
                            <Typography align='left' variant='subtitle1'>Don't have an account?</Typography>
                            <Stack spacing={24} direction='row'>
                                <Button variant='outlined' href='/signup' sx={{border: 1, borderColor: 'black', backgroundColor: "#e0e0e0", color:'black'}}>Sign up</Button>
                                <Button variant='outlined' type='submit' sx={{ border: 1, borderColor: 'black',backgroundColor: "#e0e0e0", color:'black'}}>Login</Button>  
                            </Stack>
                        </Stack>
                    </Paper>       
                </Stack> 
            </form>                         
        </>
  
    );
}

    

