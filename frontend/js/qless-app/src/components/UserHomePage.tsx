import { Stack, Paper, Card, CardContent, CardActionArea, Button, Typography, List, ListItem} from '@mui/material'

const ticket_status = [
    {link:'/tickets/:qlessId', label:'Created', bckGrnd:'#90caf9'},   // /tickets/:qlessId?status=created
    {link:'/tickets/:qlessId', label:'Ongoing', bckGrnd:'#ffe082'},   // /tickets/:qlessId?status=ongoing 
    {link:'/tickets/:qlessId', label:'Solved', bckGrnd:'#c5e1a5'},    // /tickets/:qlessId?status=solved 
    {link:'/tickets/:qlessId', label:'Cancelled', bckGrnd:'#ef9a9a'}, // /tickets/:qlessId?status=cancelled 
    {link:'/tickets/:qlessId', label:'Archived', bckGrnd:'#eeeeee'},  // /tickets/:qlessId?status=archived
];


export function UserHomePage() {

    return(
        <>
            <Stack direction='row' justifyContent='normal' spacing={2} paddingTop='150px' paddingLeft='250px'>
                <Stack direction='column' justifyContent='end'>
                    <Button variant='outlined' href='/createTicket/:qlessId' sx={{height:'30px', border: 1, backgroundColor: "white", color:'black'}}>Create Ticket</Button>
                </Stack>
                {ticket_status.map((cardInfo) => (
                    <>
                        <Card variant="outlined" raised sx={{height:'115px', width:'150px', border: 1, backgroundColor: cardInfo.bckGrnd}}> 
                            <CardActionArea href={cardInfo.link}>
                                <CardContent>
                                    <Stack direction='column' justifyContent='center' spacing={2}>
                                        <Typography variant='h6' fontFamily='monospace' fontSize={25}>{cardInfo.label}</Typography>
                                        <Typography variant='body1' fontFamily='monospace' fontSize={15}># Tickets</Typography>
                                    </Stack>
                                </CardContent>
                            </CardActionArea>    
                        </Card>
                    </>
                ))};  
            </Stack>
            
            
            <Stack direction='row' justifyContent='center' spacing={1} paddingTop='20px'>
                <Paper  style={{maxHeight: '100%', width:'140vh', overflow: 'auto'}}>
                    <List>
                        {[1, 2, 3, 4, 5, 6].map((value) => (
                            <ListItem
                                key={value}
                                disableGutters
                                sx={{justifyContent:'center'}}
                            >
                                    <Card sx={{width:'95%', height:'100px' , border:1}}>
                                        <CardActionArea href='/ticket/:id'>
                                            <CardContent sx={{display:'flex', justifyContent:'center'}}>
                                                <Typography variant='h6' fontFamily='monospace' fontSize={25}>Ticket #{value}</Typography>
                                            </CardContent>
                                        </CardActionArea>   
                                    </Card>
                            </ListItem>
                        ))}
                    </List>
                </Paper>
            </Stack>
        </>
        
    ) 
    
}