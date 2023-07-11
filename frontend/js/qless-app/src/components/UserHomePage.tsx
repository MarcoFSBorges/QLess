import {
    Stack,
    Paper,
    Card,
    CardContent,
    CardActionArea,
    Button,
    Typography,
    List,
    ListItem,
  } from "@mui/material";
  import axios from "axios";
  
  import { useAuthHeader, useAuthUser } from "react-auth-kit";
  import { useNavigate } from "react-router-dom";
  import { useState, useEffect } from "react";
  
  const ticket_status = [
    { link: "/ticket/:qlessId", label: "Created", bckGrnd: "#90caf9" }, // /ticket/:qlessId?status=created
    { link: "/ticket/:qlessId", label: "Ongoing", bckGrnd: "#ffe082" }, // /ticket/:qlessId?status=ongoing
    { link: "/ticket/:qlessId", label: "Solved", bckGrnd: "#c5e1a5" }, // /ticket/:qlessId?status=solved
    { link: "/ticket/:qlessId", label: "Cancelled", bckGrnd: "#ef9a9a" }, // /ticket/:qlessId?status=cancelled
    { link: "/ticket/:qlessId", label: "Archived", bckGrnd: "#eeeeee" }, // /ticket/:qlessId?status=archived
  ];
  

  export function processTicketDate(dateStr: string) {
    if(dateStr != null) return dateStr.replace("T", ' ').split(".").shift()
    return null
}


 export function ticketStateTextColor(ticket: any) {
  switch(ticket) {
    case 'Created': {
      return "#00b0ff"
    }

    case 'Ongoing':{
      return "#ffea00"
    }
    
    case 'Solved':{
      return "#558b2f"
    }
    
    case 'Cancelled':{
      return "#c62828"
    }

    case 'Archived':{
      return "#a6a6a6"
    }

    default: { 
      break; 
   } 
}
}

  export function UserHomePage() {
    let navigate = useNavigate();
    const authHeader = useAuthHeader();
    const authUser = useAuthUser();
  
    const email = authUser()?.email
  
    const [tickets, setTickets] = useState<any>([]);
  
    function processTicketData(ticketArray:any) {
      let retArray: any = []
      ticketArray.forEach((ticket: any) => {
        retArray.push(
          {
            employeeFname: ticket[0], 
            employeeLname: ticket[1], 
            ticketCategory: ticket[2], 
            ticketState: ticket[3], 
            ticketStateTextColor: ticketStateTextColor(ticket[3]),
            ticketCreationDate: processTicketDate(ticket[4]),
            ticketUpdateDate: processTicketDate(ticket[5]),
            ticketId: ticket[6]
          }) 
      })
      return retArray
    }
  
    useEffect(() => {
      const fetchTicketData = async () => {
          if(email != null) {
              const res2 = await axios.get(`http://localhost:8080/tickets`, { withCredentials: true })
              const ticketData = processTicketData(res2.data)
              setTickets(ticketData)
          } else console.log("email is null!")
      }
      fetchTicketData()
    }, []);
  
  
    function handleNavigation() {
      navigate(`/createTicket`);
    }


    return (
      <>
        <Stack
          direction="row"
          justifyContent="normal"
          spacing={2}
          paddingTop="150px"
          paddingLeft="250px"
        >
          <Stack direction="column" justifyContent="end">
            <Button
              variant="outlined"
              onClick={handleNavigation}
              sx={{
                height: "30px",
                border: 1,
                backgroundColor: "white",
                color: "black",
              }}
            >
              Create Ticket
            </Button>
          </Stack>
          {ticket_status.map((cardInfo) => (
            <>
              <Card
                variant="outlined"
                raised
                sx={{
                  height: "115px",
                  width: "150px",
                  border: 1,
                  backgroundColor: cardInfo.bckGrnd,
                }}
              >
                <CardActionArea href={cardInfo.link}>
                  <CardContent>
                    <Stack direction="column" justifyContent="center" spacing={2}>
                      <Typography
                        variant="h6"
                        fontFamily="monospace"
                        fontSize={25}
                      >
                        {cardInfo.label}
                      </Typography>
                      <Typography
                        variant="body1"
                        fontFamily="monospace"
                        fontSize={15}
                      >
                        # Tickets
                      </Typography>
                    </Stack>
                  </CardContent>
                </CardActionArea>
              </Card>
            </>
          ))}
        </Stack>
  
        <Stack
          direction="row"
          justifyContent="center"
          spacing={1}
          paddingTop="20px"
        >
          <Paper style={{ maxHeight: "100%", width: "140vh", overflow: "auto" }}>
            <List>
              {tickets.map((ticket:any) => (
                <ListItem
                  key={ticket}
                  disableGutters
                  sx={{ justifyContent: "center" }}
                >
                  <Card sx={{ width: "95%", height: "100px", border: 1 }}>
                    <CardActionArea  href={`/ticket/${ticket.ticketId}`}>
                      <CardContent
                        sx={{ display: "flex", justifyContent:'space-between' }}
                      > 
                          <Typography
                              variant="h6"
                              fontFamily="monospace"
                              fontSize={15}     
                              sx={{color: ticket.ticketStateTextColor, fontWeight: 'bold'}}
                          >
                            {ticket.ticketState}
                          </Typography>
                          <Typography
                            variant="h6"
                            fontFamily="monospace"
                            fontSize={25}
                          >
                            {ticket.ticketCategory}
                          </Typography>


                          <Typography
                            variant="h6"
                            fontFamily="monospace"
                            fontSize={15}
                          >
                            {
                              ticket.ticketUpdateDate == null ? ticket.ticketCreationDate : ticket.ticketUpdateDate
                            }
                          </Typography> 
                      </CardContent>
                    </CardActionArea>
                  </Card>
                </ListItem>
              ))}
            </List>
          </Paper>
        </Stack>
      </>
    );
  }
  