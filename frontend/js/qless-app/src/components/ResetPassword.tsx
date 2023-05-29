import { useState } from 'react';
import { Paper, Stack, Typography, TextField, Button} from '@mui/material';
import logo from '../images/QL_1.png'

export function ResetPassword() {

    const [password, setPassword] = useState('');
    const [confirmPass, setConfPassword] = useState('');

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
                        sx={{padding: '24px', width: '52vh'}}
                    >

                        <Typography align='center' variant='h4' fontFamily='sans-serif' sx={{padding:'4px'}}>Reset password</Typography>
                        <Stack direction='column'>
                            <TextField 
                                label='New password' 
                                type='password' 
                                variant='outlined' 
                                value={password} 
                                onChange={e => setPassword(e.target.value)}
                                sx={{padding:'4px'}}
                            />
                        </Stack>
                        <p/>
                        <Stack direction='column'>
                            <TextField 
                                label='Confirm password' 
                                type='password' 
                                variant='outlined'
                                value={confirmPass}
                                onChange={e => setConfPassword(e.target.value)}  
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