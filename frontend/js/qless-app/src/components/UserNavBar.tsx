import { AppBar, Toolbar, IconButton, Stack, Menu, MenuItem, Link, Paper, Typography} from '@mui/material'
import MenuIcon from '@mui/icons-material/Menu';
import AccountBoxIcon from '@mui/icons-material/AccountBox';
import Divider from '@mui/material/Divider';
import logo from '../images/QL_1.png'
import { useState } from 'react';

const hamburguer_menu = [
    {link:'/tickets/:qlessId', label:'Create Ticket'}, 
    {link:'/tickets/:qlessId', label:'My Tickets'}, 
    {link:'/tickets/:id', label:'Created'}, 
    {link:'/tickets/:id', label:'Ongoing'}, 
    {link:'/tickets/:id', label:'Solved'}, 
    {link:'/tickets/:id', label:'Cancelled'}, 
    {link:'/tickets/:id', label:'Archived'}, 
    {link:'/faq', label:'F.A.Q'}, 
    {link:'/about', label:'About'}, 
];

export function UserNavBar() {

    const [anchorElHamburguer, setAnchorElHamburguer] = useState<null | HTMLElement>(null)
    const openHamburguer = Boolean(anchorElHamburguer)

    const [anchorElProfile, setAnchorElProfile] = useState<null | HTMLElement>(null)
    const openProfile = Boolean(anchorElProfile)

    const handleHamburguerClick = (event: React.MouseEvent<HTMLButtonElement>) => {
        setAnchorElHamburguer(event.currentTarget)
    }

    const handleProfileClick = (event: React.MouseEvent<HTMLButtonElement>) => {
        setAnchorElProfile(event.currentTarget)
    }

    const handleHamburguerClose = () => {
        setAnchorElHamburguer(null)
    }

    const handleProfileClose = () => {
        setAnchorElProfile(null)
    }

    return (
        <AppBar position='absolute' elevation={0} sx={{ background: '#f2ebc9'}}>
            <Toolbar >
                <IconButton 
                    id='hamburguer-button' 
                    onClick={handleHamburguerClick}
                    size='large' edge='start' 
                    aria-controls={openHamburguer ? 'hamburguer-menu' : undefined} aria-haspopup='true' aria-expanded={openHamburguer ? 'true' : undefined} aria-label='menu' 
                >
                    <MenuIcon/>
                </IconButton>
                <Stack direction='row' justifyContent='center' height='150px' sx={{flexGrow: 1}}>
                    <img src={logo} alt="qless-logo"/>
                </Stack>
                <IconButton 
                    id='profile-button'
                    onClick={handleProfileClick}
                    size='large' edge='end' 
                    aria-controls={openProfile ? 'profile-menu' : undefined} aria-haspopup='true' aria-expanded={openProfile ? 'true' : undefined} aria-label='profile'>
                    <AccountBoxIcon/>
                </IconButton>
                <Menu 
                    id='hamburguer-menu' anchorEl={anchorElHamburguer} open={openHamburguer} 
                    MenuListProps={{ 'aria-labelledby' : 'hamburguer-button'}}
                    onClose={handleHamburguerClose}
                >
                    {hamburguer_menu.map((option) => (
                    <>
                        <MenuItem key={option.link}> 
                            {
                                option.link.includes(':id') ? 
                                    <Link href={option.link} underline='hover' textAlign="center" color='inherit' fontFamily='monospace' fontWeight={500} paddingLeft={1}>{option.label}</Link> : 
                                    <Link href={option.link} underline='hover' textAlign="center" color='inherit' fontFamily='monospace' fontWeight={700} >{option.label}</Link>
                            }
                        </MenuItem>
                        {
                            option.label !== 'About' ? 
                                <Divider/> :
                                <div/>
                        }
                       
                    </>  
                ))}
                </Menu>
           
                <Menu 
                    id='profile-menu' anchorEl={anchorElProfile} open={openProfile} 
                    MenuListProps={{ 'aria-labelledby' : 'profile-button'}}
                    onClose={handleProfileClose}
                >
                    <Paper 
                        elevation={24}
                        sx={{padding: '16px', width: '45vh'}}
                    >
                        <Stack direction='row' justifyContent='center' spacing={1}>
                            <Typography variant='h5'  fontFamily='monospace' fontSize={25}>First name</Typography>
                            <Typography variant='h5' fontFamily='monospace' fontSize={25}>Last name</Typography>
                        </Stack>
                        <p/>
                        <Typography align='center' variant='h6' fontFamily='monospace' fontSize={15}>Email</Typography>
                        <Divider/>
                        <Stack direction='column' spacing={1}>
                            <Link href='/settings' underline='hover' textAlign="center" color='inherit' fontFamily='monospace' fontSize={20} paddingTop={1}>Settings</Link>
                            <Link underline='hover' textAlign="center" color='inherit' fontFamily='monospace' fontSize={20}>Logout</Link>
                        </Stack>
                    </Paper>
                </Menu>
            </Toolbar>
        </AppBar>


        
           
    )
}