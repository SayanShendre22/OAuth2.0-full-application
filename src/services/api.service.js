import axios from "axios";
import keycloak from "../config/keycloak";

const apiAxios =axios.create({
    baseURL: 'https://oauth-server-i27l.onrender.com/api/v1'
})


export const getProducts =async () =>{
    // console.log(keycloak?.token)
    const result = await apiAxios.get('/products',{
        headers: {
            Authorization: `Bearer ${keycloak.token}`
        },
    });
    return result.data;
}