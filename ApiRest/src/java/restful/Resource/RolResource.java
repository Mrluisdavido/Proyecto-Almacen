
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

import restful.Model.RolModel;
import restful.Service.RolService;

@Path("roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class RolResource {
    RolService servicio = new RolService();
@GET
public ArrayList<RolModel> getRol() {

 return servicio.getRol();
}
@Path("/{Id}")
@GET
public RolModel getRol(@PathParam("Id") int id) {

 return servicio.getRol(id);
}
@POST
public RolModel addRol(String JSON) {
GsonBuilder builder = new GsonBuilder();
builder.setPrettyPrinting();
Gson gson = builder.create();
RolModel rol = gson.fromJson(JSON, RolModel.class);
return servicio.addRol(rol);
}

 @DELETE
@Path("/{Id}")
public String delRol(@PathParam("Id") int id) {

 return servicio.delRol(id);

 }

 @PUT
public RolModel updateRol(String JSON) {
GsonBuilder builder = new GsonBuilder();
builder.setPrettyPrinting();
Gson gson = builder.create();
RolModel rol = gson.fromJson(JSON, RolModel.class);
return servicio.updateRol(rol);
}
}
