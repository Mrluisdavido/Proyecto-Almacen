
package restful;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


@Path("pruebas")
public class prueba {

    @Context
    private UriInfo context;

   
    public prueba() {
    }

  
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        return "hola estas conectado al recurso pruebas desde mi API";
        
    }

   
 
}
