
import { ChangeEvent, useEffect, useState } from 'react';
import { Stack, MenuItem, Typography, TextField, IconButton, Button} from '@mui/material'
import AttachFileIcon from '@mui/icons-material/AttachFile';
import axios from "axios";
import { useNavigate } from "react-router-dom";

export function CreateTicket() {

    const [auxCategoryName, auxSetCategoryName] = useState([]);

    const [categoryName, setCategoryName] = useState("");

    const [comment, setComment] = useState("");
    const [file, setFile] = useState<File>();
    let navigate = useNavigate();

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setCategoryName(event.target.value);      
    };

    const handleSubmit = (e: any) => {
        e.preventDefault();
    }

    const handleFileChange = (e: ChangeEvent<HTMLInputElement>) => {
        if (e.target.files) {
          setFile(e.target.files[0]);
        }
      };


      const createTicket = () => {
        axios
          .post(
            "http://localhost:8080/tickets",
            { categoryName, comment },
            { withCredentials: true }
          )
          .then((res) => {
            alert("Ticket created!");
            navigate(`/tickets`);
          })
          .catch((err) => {
            console.log(err);
            alert(err);
          });
      };
      

      function processCategoryName(categoryNameArray:any) {
        let retArray: any = []
        for(let categoryName of categoryNameArray.values()) {
            retArray.push(categoryName.name)
        }
        return retArray
      }

    useEffect(() => {
        const fetchExistingCategories = async () => {
                const res = await axios.get(`http://localhost:8080/categories`, { withCredentials: true })
                const categoryName = processCategoryName(res.data)
                auxSetCategoryName(categoryName)     
            } 
            fetchExistingCategories()
      }, []);


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
                        value={categoryName}
                        onChange={handleChange}
                        fullWidth
                        sx={{backgroundColor:'white'}}
                    > 
                    {
                        auxCategoryName.map((categoryName : any) => (
                            <MenuItem value={categoryName}>{categoryName}</MenuItem> 
                        ))
                    }
                    
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
                        <Button onClick={createTicket} variant='outlined' type='submit' sx={{ border: 1, borderColor: 'black', backgroundColor: "#81c784", color:'black'}}>Create</Button>
                    </Stack>
                    <Stack direction='row' paddingTop='15px'>
                        {file && `${file.name} - ${file.type}`}
                    </Stack>
                </Stack>
            </form>
            
        </>
    )
}