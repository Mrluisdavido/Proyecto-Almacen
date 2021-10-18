
package restful.Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

import restful.Model.Conexion;
import restful.Model.RolModel;


public class RolService {
    public ArrayList<RolModel> getRol() {
ArrayList<RolModel> lista = new ArrayList<>();
Conexion conn = new Conexion();
String sql = "SELECT * FROM Roles";

 try {
Statement stm = conn.getCon().createStatement();
ResultSet rs = stm.executeQuery(sql);
while (rs.next()) {
RolModel rol = new RolModel();
rol.setId(rs.getInt("id"));
rol.setRol(rs.getString("rol"));

lista.add(rol);
}
} catch (SQLException e) {
}

 return lista;
}

 public RolModel getRol(int id) {
RolModel rol = new RolModel();
Conexion conex = new Conexion();
String Sql = "SELECT * FROM Roles WHERE id = ?";

 try {

 PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
pstm.setInt(1, id);
ResultSet rs = pstm.executeQuery();

 while (rs.next()) {

 rol.setId(rs.getInt("id"));
rol.setRol(rs.getString("rol"));

}
} catch (SQLException e) {
System.out.println(e);
}

 return rol;
}

 public RolModel addRol(RolModel rol) {
Conexion conex = new Conexion();
String Sql = "INSERT INTO Roles(id,rol)";
Sql = Sql + "values (?,?)";

 try {
PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
pstm.setInt(1, rol.getId());
pstm.setString(2, rol.getRol());

pstm.executeUpdate();

 } catch (SQLException e) {
System.out.println(e);
return null;
}
return rol;
}

 public RolModel updateRol(RolModel rol) {
Conexion conn = new Conexion();
String sql = "UPDATE Roles SET rol=? WHERE id= ?";
try {
PreparedStatement pstm = conn.getCon().prepareStatement(sql);
pstm.setString(1, rol.getRol());
pstm.setInt(2, rol.getId());
pstm.executeUpdate();
} catch (SQLException excepcion) {
System.out.println("Ha ocurrido un error al eliminar " + excepcion.getMessage());
return null;
}
return rol;
}

 public String delRol(int id) {
Conexion conn = new Conexion();

 String sql = "DELETE FROM Roles WHERE id= ?";
try {
PreparedStatement pstm = conn.getCon().prepareStatement(sql);
pstm.setInt(1, id);
pstm.executeUpdate();
} catch (SQLException excepcion) {
System.out.println("Ha ocurrido un error al eliminar " + excepcion.getMessage());
return "{\"Accion\":\"Error\"}";
}
return "{\"Accion\":\"Registro Borrado\"}";
}
}
