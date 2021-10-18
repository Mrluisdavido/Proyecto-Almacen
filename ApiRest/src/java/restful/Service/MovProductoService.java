
package restful.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.Model.MovProductoModel;
import restful.Model.Conexion;

public class MovProductoService {
   public ArrayList<MovProductoModel> getMovProducto() {
        ArrayList<MovProductoModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM movimiento_productos";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                MovProductoModel movproducto = new MovProductoModel();
                movproducto.setId(rs.getInt("id"));
                movproducto.setId_producto(rs.getInt("id_producto"));
                movproducto.setId_usuario(rs.getInt("id_usuario"));
                movproducto.setCantidad(rs.getInt("cantidad"));
                movproducto.setFecha_registro(rs.getInt("fecha_registro"));
                movproducto.setId_tipo_movimiento(rs.getInt("id_tipo_movimiento"));
                lista.add(movproducto);
            }
        } catch (SQLException e) {
        }

        return lista;
    }

    public MovProductoModel getMovProducto(int id) {
        MovProductoModel movproducto = new MovProductoModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM movimiento_productos WHERE id = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                movproducto.setId(rs.getInt("id"));
                movproducto.setId_producto(rs.getInt("id_producto"));
                movproducto.setId_usuario(rs.getInt("id_usuario"));
                movproducto.setCantidad(rs.getInt("cantidad"));
                movproducto.setFecha_registro(rs.getInt("fecha_registro"));
                movproducto.setId_tipo_movimiento(rs.getInt("id_tipo_movimiento"));
            }
                
        } catch (SQLException e) {
            System.out.println(e);
        }

        return movproducto;
    }

    public MovProductoModel addMovProducto(MovProductoModel movproducto) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO movimiento_productos(id,id_producto,id_usuario,cantidad,fecha_registro,id_tipo_movimiento)";
        Sql = Sql + "values (?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, movproducto.getId());
            pstm.setInt(2, movproducto.getId_producto());
            pstm.setInt(3, movproducto.getId_usuario());
            pstm.setInt(4, movproducto.getCantidad());
            pstm.setInt(5, movproducto.getFecha_registro());
            pstm.setInt(6, movproducto.getId_tipo_movimiento());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return movproducto;
    }

    public MovProductoModel updateMovProducto(MovProductoModel movproducto) {
        Conexion conn = new Conexion();
        String sql = "UPDATE movimiento_productos SET id_producto=?,id_usuario=?,cantidad=?,fecha_registro=?,id_tipo_movimiento=? WHERE id= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setInt(1, movproducto.getId_producto());
            pstm.setInt(2, movproducto.getId_usuario());
            pstm.setInt(3, movproducto.getCantidad());
            pstm.setInt(4, movproducto.getFecha_registro());
            pstm.setInt(5, movproducto.getId_tipo_movimiento());
            pstm.setInt(6, movproducto.getId());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return movproducto;
    }

    public String delMovProducto(int id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM movimiento_productos WHERE id= ?";
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
