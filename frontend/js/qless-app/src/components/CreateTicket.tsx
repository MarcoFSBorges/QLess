
import { ChangeEvent, useState } from 'react';
import { Stack, MenuItem, Typography, TextField, IconButton, Button} from '@mui/material'
import AttachFileIcon from '@mui/icons-material/AttachFile';

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
    const [comment, setComment] = useState('');
    const [file, setFile] = useState<File>();

    console.log(file)

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setCategory(event.target.value);      
    };

    const handleSubmit = (e: any) => {
        e.preventDefault();
    }

    const handleFileChange = (e: ChangeEvent<HTMLInputElement>) => {
        if (e.target.files) {
          setFile(e.target.files[0]);
        }
      };


    return(
        <>
            <Stack direction='row' justifyContent='normal' spacing={2} paddingTop='150px' paddingLeft='250px'>
                <Typography variant='body1' fontFamily='monospace' fontSize={15}>Ticket Category</Typography>
            </Stack>
            <form onSubmit={handleSubmit}>
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
                        value={comment}
                        onChange={e => setComment(e.target.value)}  
                        fullWidth
                        multiline
                        rows={8}
                        sx={{backgroundColor:'white'}}>
                    </TextField>

                    <Stack direction='row' paddingTop='15px' spacing={155}>    
                         <IconButton
                            component="label"
                            sx={{width:'40px',height:'40px', paddingTop:'15px', justifyContent:'left'}}
                        >
                            <AttachFileIcon/>
                            <input
                                style={{display:"none"}}
                                type="file"
                                hidden
                                onChange={handleFileChange}
                                name="[licenseFile]"
                            />
                        </IconButton>
                        <Button variant='outlined' type='submit' sx={{ border: 1, borderColor: 'black', backgroundColor: "#81c784", color:'black'}}>Create</Button>
                    </Stack>
                    <Stack direction='row' paddingTop='15px'>
                        {file && `${file.name} - ${file.type}`}
                    </Stack>
                </Stack>
            </form>
            
        </>
    )
}