import { useState } from 'react';
import { Paper, Stack, Typography, TextField, Button, Link, Box } from '@mui/material';


import logo from '../images/QL_1.png';

export function Info() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e: any) => {
        e.preventDefault();
    }

    return (
        <>
            <Box >
                <Stack direction='column' justifyContent='center' alignItems='center' spacing={2}>
                    <img className="qlessLogo" src={logo} alt="qless-logo"/>
                    <Typography align='center' variant='h3' fontFamily='sans-serif' sx={{color:'black'}}>This page is still a work in progess. It will contain our project info in the near future.</Typography>
                    <Button variant='outlined' href='/login' sx={{border: 1, borderColor: 'black', backgroundColor: "#e0e0e0", color:'black'}}>Get started</Button>
                </Stack>
            </Box>                  
        </>
    );
}
