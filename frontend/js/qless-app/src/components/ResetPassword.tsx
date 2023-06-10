import { useState } from 'react';
import { Paper, Stack, Typography, TextField, Button, Box} from '@mui/material';
import logo from '../images/QL_1.png'

export function ResetPassword() {

    const [password, setPassword] = useState('');
    const [confirmPass, setConfPassword] = useState('');

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
                            <Stack direction='column' justifyContent='flex-start' alignItems='center' spacing={2}>
                                <Typography align='center' variant='h4' fontFamily='sans-serif' sx={{padding:'4px'}}>Reset password</Typography>
                                <TextField 
                                    fullWidth
                                    label='New password' 
                                    type='password' 
                                    variant='outlined' 
                                    value={password} 
                                    onChange={e => setPassword(e.target.value)}
                                />
                                <TextField 
                                    fullWidth
                                    label='Confirm password' 
                                    type='password' 
                                    variant='outlined'
                                    value={confirmPass}
                                    onChange={e => setConfPassword(e.target.value)}  
                                /> 
                                <Button variant='outlined' type='submit' sx={{ border: 1, borderColor: 'black',backgroundColor: "#e0e0e0", color:'black'}}>Submit</Button>
                            </Stack>
                        </Paper> 
                    </form>   
                </Stack>
            </Box>                  
        </>
    );

}