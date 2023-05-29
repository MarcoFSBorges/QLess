
import { useState } from 'react';
import { Stack, Paper, Card, Menu, MenuItem, Typography, TextField} from '@mui/material'

const categories = [
    {value: 'CD', label: 'Carimbar documento'},
    {value:'MT', label: 'Mudança de turma'} ,
    {value:'CDS', label: 'Candidaturas'},
    {value:'PP', label: 'Pagamento de propinas'},
    {value:'PPP', label: 'Pedido de plano de pagamento'},
    {value:'OT', label: 'Outro'}
  ];

export function CreateTicket() {

    const [category, setCategory] = useState('');
    console.log( {category} )
    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setCategory(event.target.value);
        
    };

    return(
        <>
        <Stack direction='row' justifyContent='normal' spacing={2} paddingTop='150px' paddingLeft='250px'>
                <Typography variant='body1' fontFamily='monospace' fontSize={15}>Ticket Category</Typography>
            </Stack>
            <Stack direction='column' justifyContent='normal'  paddingTop='10px' paddingLeft='250px'>
                <TextField
                    label="Category"
                    select
                    value={category}
                    onChange={handleChange}
                    fullWidth
                    sx={{backgroundColor:'white'}}
                > 
                <MenuItem value='CD'>Carimbar documento</MenuItem> 
                <MenuItem value='MT'>Mudança de turma</MenuItem> 
                <MenuItem value='CDS'>Candidaturas</MenuItem> 
                <MenuItem value='PP'>Pagamento de propinas</MenuItem> 
                <MenuItem value='PPP'>Pedido de plano de pagamento</MenuItem> 
                <MenuItem value='OT'>Outro</MenuItem> 
                </TextField>
                <p/>
                <Typography align='left' variant='body1' fontFamily='monospace' fontSize={15} paddingBottom={1}>Add comment</Typography>
                <TextField 
                    label="Comment"
                    fullWidth
                    multiline
                    rows={8}
                    sx={{backgroundColor:'white'}}>

                </TextField>

            </Stack>
        </>
    )
}