
package restful.Model;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class RolModel {
    private int id;
    private String rol;

    public RolModel() {
    }

    public RolModel(int id, String rol) {
        this.id = id;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public String getRol() {
        return rol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
