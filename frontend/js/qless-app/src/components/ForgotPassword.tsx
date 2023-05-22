import { useState } from 'react';
import { Paper, Stack, Typography, TextField, Button } from '@mui/material';
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import logo from '../images/QL_1.png'

export function ForgotPassword() {

    const [email, setEmail] = useState('');

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
                        sx={{padding: '8px', width: '50vh'}}>
                        
                        <Stack direction='column' >
                            <Stack direction='row' justifyContent='left'>
                                <Button variant='outlined' href='/login' startIcon={<ArrowBackIcon/>} disableElevation size='small' sx={{ border: 0, color:'black'}}></Button>  
                            </Stack> 
                        </Stack>

                        <Typography align='center' variant='h4' fontFamily='sans-serif' sx={{padding:'4px'}}>Forgot Password</Typography>
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

                        <Stack direction='column' >
                            <Stack direction='row' justifyContent='center'>
                                <Button variant='outlined' type='submit' sx={{ border: 1, borderColor: 'black',backgroundColor: "#e0e0e0", color:'black'}}>Submit</Button>  
                            </Stack> 
                        </Stack>
                    </Paper>       
                </Stack> 
            </form>                         
        </>
        
    );

}