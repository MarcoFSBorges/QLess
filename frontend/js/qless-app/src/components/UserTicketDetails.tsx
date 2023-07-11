import { Button, Divider, IconButton, Paper, Stack, TextField, Typography } from "@mui/material";
import axios from "axios";
import { useState, useEffect, ChangeEvent } from "react";
import { useParams } from "react-router-dom";
import { processTicketDate, ticketStateTextColor } from "./UserHomePage";
import SendIcon from '@mui/icons-material/Send';
import AttachFileIcon from '@mui/icons-material/AttachFile';

export function UserTicketDetails() {

    let { ticketId } = useParams()

    const [ticket, setTicket] = useState<any>([]);
    const [message, setMessage] = useState("");



    const handleSendMessage = (e: ChangeEvent<HTMLInputElement>) => {
            setMessage(e.target.value);
    };

    
    function processTicketData(ticket:any) {
          let ticketDetails = 
            {
              employeeFname: ticket[0],
              employeeLname: ticket[1],
              ticketCategory: ticket[2], 
              ticketCreationDate: processTicketDate(ticket[3]), 
              ticketUpdateDate:  processTicketDate(ticket[4]), 
              ticketState: ticket[5], 
            }
        return ticketDetails
    }

    useEffect(() => {
        const fetchTicketData = async () => {
            const res = await axios.get(`http://localhost:8080/ticket/${ticketId}`,  {
                params: {
                    ticketId: ticketId
                },
                withCredentials: true,
                
            }) 
            
                const ticketData = processTicketData(res.data)
                console.log(res.data)
                setTicket(ticketData)
        }
        fetchTicketData()
      }, []);


    function ButtonStateOptions() {
            if(ticket.ticketState == 'Created') {
                return <>
                        <Button
                            variant="outlined"
                            sx={{
                                height: "30px",
                                border: 1,
                                backgroundColor: "white",
                                color: "black",
                            }}
                            >
                            Cancel Ticket   
                        </Button>
                    </> 
            }
            else if(ticket.ticketState == 'Solved' || ticket.ticketState == 'Cancelled' ) {
                return <>
                        <Button
                            variant="outlined"
                            sx={{
                                height: "30px",
                                border: 1,
                                backgroundColor: "white",
                                color: "black",
                            }}
                            >
                            Archive Ticket  
                        </Button>
                        
                        <Button
                            variant="outlined"
                            sx={{
                                height: "30px",
                                border: 1,
                                backgroundColor: "white",
                                color: "black",
                            }}
                            >
                            Reopen Ticket  
                        </Button>
                    </> 
                
                }
            else {
                return <></>
            }
                
    }

    return(
        <>
            <Stack
                direction="row"
                justifyContent='flex-start'
                spacing={2}
                paddingTop="200px"
                paddingLeft="375px"
            >
                <ButtonStateOptions/>
            </Stack>



        <Stack
            direction="row"
            justifyContent="center"
            paddingTop="8px"
            >
            <Paper elevation={8} style={{ height:"40vh", width: "120vh"}}>

                

                <Stack
                    direction="row"
                >

                    <Stack
                        direction="column"
                        width='350px'
                        height='40vh'
                        spacing={2.5}
                    >
                        <Stack
                            direction="row"
                            justifyContent='center'
                            paddingTop="32px"
                            width='350px'
                        >

                            <Typography
                                variant="h6"
                                fontFamily="monospace"
                                fontSize={15}     
                                sx={{color: 'black' }}
                            >
                                Employee: {ticket.employeeFname} {ticket.employeeLname}  
                            </Typography>
                        
                        </Stack>
                        <Divider   />
                        <Stack
                            direction="row"
                            justifyContent='center'
                            paddingTop="8px"
                            width='350px'
                        >

                            <Typography
                                variant="h6"
                                fontFamily="monospace"
                                fontSize={15}     
                                sx={{color: 'black' }}
                            >
                                Ticket Category:  {ticket.ticketCategory}
                            </Typography>
                        
                        </Stack>
                        <Divider   />
                        <Stack
                            direction="row"
                            justifyContent='center'
                            paddingTop="8px"
                            width='350px'
                        >
                            <Typography
                                variant="h6"
                                fontFamily="monospace"
                                fontSize={15}     
                                sx={{color: 'black' }}
                            >
                                Creation date:  {ticket.ticketCreationDate}
                            </Typography>

                        </Stack>

                        <Divider   />
                        <Stack
                            direction="row"
                            justifyContent='center'
                            paddingTop="8px"
                            width='350px'
                        >

                            <Typography
                                variant="h6"
                                fontFamily="monospace"
                                fontSize={15}     
                                sx={{color: 'black' }}
                            >
                                Last update:  {ticket.ticketUpdateDate}
                            </Typography>
                        </Stack>

                        <Divider   />

                        <Stack
                            direction="row"
                            justifyContent='center'
                            paddingTop="8px"
                            width='350px'
                        >

                            <Typography
                                variant="h6"
                                fontFamily="monospace"
                                fontSize={15}     
                                sx={{color: 'black' }}
                            >
                                Ticket Status:  &nbsp; 
                            </Typography>
                           
                            <Typography
                                variant="h6"
                                fontFamily="monospace"
                                fontSize={15}     
                                sx={{color: ticketStateTextColor(ticket.ticketState), fontWeight: 'bold'}}
                            >
                                {ticket.ticketState}
                            </Typography>
                            
                        </Stack>


                    </Stack>

                    <Stack
                            direction="column"    
                    >
                        <Divider orientation='vertical'    />
                    
                    </Stack>


                    <Stack
                            direction="column"    
                            sx={{backgroundColor:'#f5f5f5', width:'100%'}}
                            justifyContent='end'
                    >

                        <Stack
                            direction="column"    
                            sx={{backgroundColor:'white', height:'80px' ,  width:'100%'}}
                        >
                            <TextField 
                                disabled = {ticket.ticketState != 'Created' && ticket.ticketState != 'Ongoing'}
                                label="Message"
                                value={message}
                                onChange={e => setMessage(e.target.value)}  
                                fullWidth
                                multiline
                                rows={2}
                                sx={{backgroundColor:'white'}}>
                                   
                            </TextField>

                        </Stack>
                    </Stack>


                    <Stack
                            direction="column"    
                            sx={{backgroundColor:'#f5f5f5', width:'100px'}}
                            justifyContent='end'
                            spacing={2}
                    >
                         <IconButton
                            component="label"
                        >
                            <SendIcon/>
                            <input
                                style={{display:"none"}}
                                hidden
                                onChange={handleSendMessage}
                            />
                        </IconButton>

                        <IconButton
                            component="label"
                        >
                            <AttachFileIcon/>
                            <input
                                style={{display:"none"}}
                                hidden
                                onChange={handleSendMessage} // ?
                            />
                        </IconButton>
                        
                    </Stack>
                    

                </Stack>
            </Paper>
        </Stack>




        </>
    )
}


