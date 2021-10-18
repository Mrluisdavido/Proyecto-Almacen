
package restful.Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restful.Model.LoginModel;
import restful.Model.Conexion;


public class LoginService {
    public LoginModel getUser(String user) {
        LoginModel usuario = new LoginModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM usuarios WHERE usuario = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, user);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                usuario.setId(rs.getInt("id"));
                usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setId_rol(rs.getInt("id_rol"));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return usuario;
    }
}
