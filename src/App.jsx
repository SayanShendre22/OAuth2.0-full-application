import { useEffect, useState } from 'react'
import './App.css'
import toast, { Toaster } from 'react-hot-toast';
import { useAuth } from './config/authcontex';
import { getProducts } from './services/api.service';

function App() {

  const { isAuthenticated, keycloak } = useAuth();
  // console.log(isAuthenticated);
  console.log(keycloak?.token);

  const [products, setProducts] = useState([]);

  const loadProducts = async () => {
    try {
      const data = await getProducts();
      setProducts(data);
      toast.success("Product loaded")
    } catch (error) {
      console.log(error)
      toast.error("error loading products")
      toast.error("login required")
    }
  }

  useEffect(() => {
    loadProducts()
  }, [isAuthenticated])

  return (
    <>
      <Toaster />
      {isAuthenticated ?
        <div>
          <h1>Welcome to Oauth client</h1>
          <p>you are logged in</p>
          <h2>Name: {keycloak.tokenParsed.name}</h2>
          <p>product list: </p>
          {console.log(products)}
          {products.map( (item)=>
          (
            <p key={item.productId}>{item.name}</p>
          )
           )
          
          }


          <button onClick={() => {
            keycloak.logout()
            toast.success("Logout success")
          }
          } >logout</button>
        </div>
        :
        <div>
          <h1>Login Required</h1>
          <button
            onClick={() => {
              keycloak.login()
            }}
          >login</button>
        </div>
      }

    </>
  )
}

export default App
