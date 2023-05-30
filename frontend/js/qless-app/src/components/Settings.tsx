import {Stack, TextField, Typography, Dialog, DialogTitle, DialogContent, Button} from '@mui/material'
import CloseIcon from '@mui/icons-material/Close';
import ModeEditIcon from '@mui/icons-material/ModeEdit';
import { useState } from 'react';


export function Settings() {

    const [closeSettings, setCloseSettings] = useState(true);

    const [isDisabledFn, setIsDisabledFN] = useState(true);

    const [isDisabledLn, setIsDisabledLN] = useState(true);

    const [isDisabledSaveChanges, setIsDisabledSaveChanges] = useState(true);

    const handleClickCloseSettings = () => {
        setCloseSettings(false);
    };

    const handleEditFnButton = () => {
        setIsDisabledFN(false)
    } 

    const handleEditLnButton = () => {
        setIsDisabledLN(false)
    } 

    const [firstName, setFirstName] = useState('António');
    const [lastName, setLastName] = useState('Silva');

    const handleFirstNameChanged = (value: string) => {
        setIsDisabledSaveChanges(false)
        setFirstName(value)
    }

    const handleLastNameChanged = (value: string) => {
        setIsDisabledSaveChanges(false)
        setLastName(value)
    }


    const [newPassword, setNewPassword] = useState('');
    const [confirmNewPassword, setConfirmNewPassword] = useState('');

    const handleNewPassword = (value: any) => {
        setIsDisabledSaveChanges(false)
        setNewPassword(value)
    }

    const handleConfirmPassword = (value: any) => {
        setIsDisabledSaveChanges(false)
        setConfirmNewPassword(value)
    }

    return (
        <Dialog open={closeSettings} fullWidth maxWidth='md'>
                                <DialogTitle>
                                    <Stack direction='row' justifyContent='end' spacing={25}>
                                        <Stack>
                                            <Typography variant="h6" fontFamily='monospace' fontSize={25}>
                                                Your personal info
                                            </Typography>
                                        </Stack>
                                        <Stack direction='row'>
                                            <Button
                                                sx={{color:'black'}}
                                                onClick={handleClickCloseSettings}
                                            >
                                                <CloseIcon />
                                            </Button>
                                        </Stack>
                                    </Stack>         
                                </DialogTitle>
                                <DialogContent dividers>
                                    <Stack direction='row' spacing={1}>
                                        <Stack direction='column' spacing={1} paddingLeft='20px'>
                                            <Typography variant="h6" fontFamily='monospace' fontSize={35}>Profile</Typography>
                                            <Typography variant='body1' fontFamily='monospace' fontSize={20}>First name</Typography>
                                            <Stack direction='row' spacing={1}>
                                                <TextField
                                                    disabled = {isDisabledFn}
                                                    value={firstName}
                                                    onChange={e => handleFirstNameChanged(e.target.value)}
                                                    sx={{width:'250px'}}
                                                ></TextField>
                                                <Button
                                                    sx={{color:'black'}}
                                                    onClick={handleEditFnButton}
                                                >
                                                    <ModeEditIcon/>
                                                </Button>
                                            </Stack>
                                            <Typography variant='body1' fontFamily='monospace' fontSize={20} sx={{paddingTop:'10px'}}>Last name</Typography>
                                            <Stack direction='row' spacing={1}>
                                                <TextField
                                                    disabled = {isDisabledLn}
                                                    value={lastName}
                                                    onChange={e => handleLastNameChanged(e.target.value)}
                                                    sx={{width:'250px'}}
                                                ></TextField>
                                                <Button
                                                    sx={{color:'black'}}
                                                    onClick={handleEditLnButton}
                                                >
                                                    <ModeEditIcon/>
                                                </Button>
                                            </Stack>
                                            <p/>
                                            <Typography variant="h6" fontFamily='monospace' fontSize={20}>Email</Typography>
                                            <Stack direction='row' spacing={1}>
                                                <TextField
                                                    disabled
                                                    value='antoniosilva@benfica.pt'
                                                    sx={{width:'250px'}}
                                                ></TextField>
                                            </Stack>
                                        </Stack>

                                        <Stack direction='column' spacing={1} paddingLeft='250px'>
                                            <Typography variant="h6" fontFamily='monospace' fontSize={35}>Password</Typography>
                                            <Typography variant='body1' fontFamily='monospace' fontSize={20}>Old password</Typography>
                                            <Stack direction='row' spacing={1}>
                                                <TextField
                                                    disabled
                                                    value='************'
                                                    sx={{width:'250px'}}
                                                ></TextField>
                                            </Stack>
                                            <Typography variant='body1' fontFamily='monospace' fontSize={20} sx={{paddingTop:'10px'}}>New password</Typography>
                                            <Stack direction='row' spacing={1}>
                                                <TextField
                                                    type='password' 
                                                    value={newPassword}
                                                    onChange={e => handleNewPassword(e.target.value)}
                                                    sx={{width:'250px'}}
                                                ></TextField>       
                                            </Stack>

                                            <Typography variant='body1' fontFamily='monospace' fontSize={20} sx={{paddingTop:'10px'}}>Confirm new password</Typography>
                                            <Stack direction='row' spacing={1}>
                                                <TextField
                                                    type='password' 
                                                    value={confirmNewPassword}
                                                    onChange={e => handleConfirmPassword(e.target.value)}
                                                    sx={{width:'250px'}}
                                                ></TextField>       
                                            </Stack>
                                            <p/>
                                            <Button
                                                disabled = {isDisabledSaveChanges} 
                                                variant='outlined'
                                                type='submit'
                                                sx={{ border: 1, borderColor: 'black', backgroundColor: "#4fc3f7", color:'black'}}
                                            >
                                                Save changes
                                            </Button>
                                        </Stack>

                                    </Stack>
                                </DialogContent>
                            </Dialog>
    )
}