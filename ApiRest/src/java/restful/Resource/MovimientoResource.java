
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

import restful.Model.MovimientoModel;
import restful.Service.MovimientoService;

@Path("movimientos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class MovimientoResource {
    MovimientoService servicio = new MovimientoService();

    @GET
    public ArrayList<MovimientoModel> getMovimiento() {

        return servicio.getMovimiento();
    }

    @Path("/{Id}")
    @GET
    public MovimientoModel getMovimiento(@PathParam("Id") int id) {

        return servicio.getMovimiento(id);
    }

    @POST
    public MovimientoModel addMovimiento(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        MovimientoModel movimiento = gson.fromJson(JSON, MovimientoModel.class);
        return servicio.addMovimiento(movimiento);
    }

    @DELETE
    @Path("/{Id}")
    public String delMovimiento(@PathParam("Id") int id) {

        return servicio.delMovimiento(id);

    }

    @PUT
    public MovimientoModel updateMovimiento(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        MovimientoModel movimiento = gson.fromJson(JSON, MovimientoModel.class);
        return servicio.updateMovimiento(movimiento);
    }

}
