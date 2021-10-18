
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

import restful.Model.UsuarioModel;
import restful.Service.UsuarioService;

@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UsuarioResource {
  UsuarioService servicio = new UsuarioService();

    @GET
    public ArrayList<UsuarioModel> getUsuario() {

        return servicio.getUsuario();
    }

    @Path("/{Id}")
    @GET
    public UsuarioModel getUsuario(@PathParam("Id") int id) {

        return servicio.getUsuario(id);
    }

    @POST
    public UsuarioModel addUsuario(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        UsuarioModel usuario = gson.fromJson(JSON, UsuarioModel.class);
        return servicio.addUsuario(usuario);
    }

    @DELETE
    @Path("/{Id}")
    public String delUsuario(@PathParam("Id") int id) {

        return servicio.delUsuario(id);

    }

    @PUT
    public UsuarioModel updateCliente(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        UsuarioModel usuario = gson.fromJson(JSON, UsuarioModel.class);
        return servicio.updateUsuario(usuario);
    }
  
}
