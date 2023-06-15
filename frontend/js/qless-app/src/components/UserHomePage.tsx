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
            <Stack direction='column' justifyContent='center' alignItems='center' spacing={2}>
                <Stack direction='row' justifyContent='center' alignItems='flex-end' spacing={2} padding='48px'>
                    <Button variant='outlined' href='/createTicket/:qlessId' sx={{border: 1, backgroundColor: "white", color:'black'}}>Create Ticket</Button>
                    <Stack direction='row' justifyContent='space-evenly' alignItems='center' spacing={0.5}>
                        {ticket_status.map((cardInfo) => (
                            <>
                                <Card variant="outlined" raised sx={{border: 1, backgroundColor: cardInfo.bckGrnd}}> 
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
                </Stack>
                <Paper style={{maxHeight: '100%', maxWidth: '100%', padding: '16px'}}>
                    <List>
                        {[1, 2, 3, 4, 5, 6].map((value) => (
                            <ListItem
                                key={value}
                                disableGutters
                                sx={{justifyContent:'center'}}
                            >
                                <Card sx={{border:1}}>
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