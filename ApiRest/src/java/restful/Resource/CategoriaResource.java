
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

import restful.Model.CategoriaModel;
import restful.Service.CategoriaService;

@Path("categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CategoriaResource {
   CategoriaService servicio = new CategoriaService();

    @GET
    public ArrayList<CategoriaModel> getCategoria() {

        return servicio.getCategoria();
    }

    @Path("/{Id}")
    @GET
    public CategoriaModel getCategoria(@PathParam("Id") int id) {

        return servicio.getCategoria(id);
    }

    @POST
    public CategoriaModel addCategoria(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        CategoriaModel categoria = gson.fromJson(JSON, CategoriaModel.class);
        return servicio.addCategoria(categoria);
    }

    @DELETE
    @Path("/{Id}")
    public String delCategoria(@PathParam("Id") int id) {

        return servicio.delCategoria(id);

    }

    @PUT
    public CategoriaModel updateCategoria(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        CategoriaModel categoria = gson.fromJson(JSON, CategoriaModel.class);
        return servicio.updateCategoria(categoria);
    }
 
}
