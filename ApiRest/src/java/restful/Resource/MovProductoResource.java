
package restful.Resource;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

import restful.Model.MovProductoModel;
import restful.Service.MovProductoService;

@Path("movproductos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class MovProductoResource {
    MovProductoService servicio = new MovProductoService();

    @GET
    public ArrayList<MovProductoModel> getMovProducto() {

        return servicio.getMovProducto();
    }

    @Path("/{Id}")
    @GET
    public MovProductoModel getMovProducto(@PathParam("Id") int id) {

        return servicio.getMovProducto(id);
    }

    @POST
    public MovProductoModel addMovProducto(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        MovProductoModel movproducto = gson.fromJson(JSON, MovProductoModel.class);
        return servicio.addMovProducto(movproducto);
    }

    @DELETE
    @Path("/{Id}")
    public String delCliente(@PathParam("Id") int id) {

        return servicio.delMovProducto(id);

    }

    @PUT
    public MovProductoModel updateCliente(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        MovProductoModel movproducto = gson.fromJson(JSON, MovProductoModel.class);
        return servicio.updateMovProducto(movproducto);
    }

}
