import { useState } from 'react';
import { Paper, Stack, Typography, TextField, Button, Box } from '@mui/material';
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import logo from '../images/QL_1.png'

export function ForgotPassword() {

    const [email, setEmail] = useState('');

    const handleSubmit = (e: any) => {
        e.preventDefault();
    }

    return (
        <>
            <Box>
                <Stack direction='column' justifyContent='center' alignItems='center' spacing={2}>
                    <img className="qlessLogo" src={logo} alt="qless-logo"/>

                    <form className="qlessResponsiveForm" onSubmit={handleSubmit}>
                        <Paper 
                            elevation={24}
                            sx={{padding: '24px'}}>
                            <Box>
                                <Button variant='outlined' href='/login' startIcon={<ArrowBackIcon/>} disableElevation size='small' sx={{ border: 0, color:'black'}}></Button>
                            </Box> 
                            <Stack direction='column' justifyContent='flex-start' alignItems='center' spacing={2}>
                                
                                <Typography align='center' variant='h3' fontFamily='sans-serif'>Forgot Password</Typography>
                                
                                <TextField 
                                    fullWidth
                                    label='Email' 
                                    variant='outlined' 
                                    value={email} 
                                    onChange={e => setEmail(e.target.value)}
                                />
                            </Stack>
                            
                            <Stack direction='row' justifyContent="center" alignItems='center' spacing={18} sx={{paddingTop:'8px'}}>
                                <Button variant='outlined' type='submit' sx={{ border: 1, borderColor: 'black',backgroundColor: "#e0e0e0", color:'black'}}>Submit</Button>  
                            </Stack>    
                        </Paper> 
                    </form>   
                </Stack>
            </Box>                  
        </>
    );
}