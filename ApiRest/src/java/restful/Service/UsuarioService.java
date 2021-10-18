
package restful.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.Model.UsuarioModel;
import restful.Model.Conexion;

public class UsuarioService {
    public ArrayList<UsuarioModel> getUsuario() {
        ArrayList<UsuarioModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM usuarios";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setId_rol(rs.getInt("id_rol"));
                lista.add(usuario);
            }
        } catch (SQLException e) {
        }

        return lista;
    }

    public UsuarioModel getUsuario(int id) {
        UsuarioModel usuario = new UsuarioModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM usuarios WHERE id = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id);
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

    public UsuarioModel addUsuario(UsuarioModel usuario) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO usuarios(id,nombre_usuario,correo,usuario,contrasena,id_rol)";
        Sql = Sql + "values (?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, usuario.getId());
            pstm.setString(2, usuario.getNombre_usuario());
            pstm.setString(3, usuario.getCorreo());
            pstm.setString(4, usuario.getUsuario());
            pstm.setString(5, usuario.getContrasena());
            pstm.setInt(6, usuario.getId_rol());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return usuario;
    }

    public UsuarioModel updateUsuario(UsuarioModel usuario) {
        Conexion conn = new Conexion();
        String sql = "UPDATE usuarios SET nombre_usuario=?,correo=?,usuario=?,contrasena=?,id_rol=? WHERE id= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, usuario.getNombre_usuario());
            pstm.setString(2, usuario.getCorreo());
            pstm.setString(3, usuario.getUsuario());
            pstm.setString(4, usuario.getContrasena());
            pstm.setInt(5, usuario.getId_rol());
            pstm.setInt(6, usuario.getId());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return usuario;
    }

    public String delUsuario(int id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM usuarios WHERE id= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return "{\"Accion\":\"Error\"}";
        }
        return "{\"Accion\":\"Registro Borrado\"}";
    }
}
