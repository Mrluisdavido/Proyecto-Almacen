
package restful.Model;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class UsuarioModel {
    private int id;
    private String nombre_usuario;
    private String correo;
    private String usuario;
    private String contrasena;
    private int id_rol;

    public UsuarioModel() {
    }

    public UsuarioModel(int id, String nombre_usuario, String correo, String usuario, String contrasena, int id_rol) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.id_rol = id_rol;
    }

    public int getId() {
        return id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }
    
    
    
}
