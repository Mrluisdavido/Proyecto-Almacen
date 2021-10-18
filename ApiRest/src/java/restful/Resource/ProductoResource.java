
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

import restful.Model.ProductoModel;
import restful.Service.ProductoService;

@Path("productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProductoResource {
    ProductoService servicio = new ProductoService();

    @GET
    public ArrayList<ProductoModel> getProducto() {

        return servicio.getProducto();
    }

    @Path("/{Id}")
    @GET
    public ProductoModel getProducto(@PathParam("ProductoId") int id) {

        return servicio.getProducto(id);
    }

    @POST
    public ProductoModel addProducto(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ProductoModel producto = gson.fromJson(JSON, ProductoModel.class);
        return servicio.addProducto(producto);
    }

    @DELETE
    @Path("/{Id}")
    public String delProducto(@PathParam("Id") int id) {

        return servicio.delProducto(id);

    }

    @PUT
    public ProductoModel updateProducto(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ProductoModel producto = gson.fromJson(JSON, ProductoModel.class);
        return servicio.updateProducto(producto);
    }

}
