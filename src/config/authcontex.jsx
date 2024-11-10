import { createContex , useContext, useState,useEffect, createContext } from "react"
import keycloak from "./keycloak"
import toast, { Toaster } from "react-hot-toast";

// creating auth context
const AuthContext = createContext();

// creatring auth provider
export const AuthProvider=({children})=>{

    <Toaster/>
    const [isAuthenticated,setIsAuthenticated] = useState(false)
    const [keyCloakObject,setKeyCloakObject] = useState(null)

    // on component inilization
    useEffect( ()=>{
        keycloak.init({
            onLoad:'check-sso'
        })
        .then((authenticated)=>{
            console.log(authenticated)
            setIsAuthenticated(authenticated);
            setKeyCloakObject(keycloak);
            // console.log(keycloak)
           if(authenticated){
            console.log("login success")
            toast.success("LoggedIn success");
           }
        })
        .catch((error)=>{
            toast.error("Login failed")
            console.log(error)
        })
    }, []);

    return (
        <AuthContext.Provider
        value={{
            isAuthenticated: isAuthenticated,
            keycloak: keyCloakObject
        }}>
            {children}
        </AuthContext.Provider>
    )
}


export const useAuth = () => useContext(AuthContext);
