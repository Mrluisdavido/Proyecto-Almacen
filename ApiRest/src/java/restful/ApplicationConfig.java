
package restful;

import java.util.Set;
import javax.ws.rs.core.Application;


@javax.ws.rs.ApplicationPath("api") 
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

   
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(restful.Resource.CategoriaResource.class);
        resources.add(restful.Resource.LoginResource.class);
        resources.add(restful.Resource.MovProductoResource.class);
        resources.add(restful.Resource.MovimientoResource.class);
        resources.add(restful.Resource.ProductoResource.class);
        resources.add(restful.Resource.RolResource.class);
        resources.add(restful.Resource.UsuarioResource.class);
        resources.add(restful.prueba.class);
    }
    
}
