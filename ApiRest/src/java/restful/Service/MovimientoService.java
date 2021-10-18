
package restful.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.Model.MovimientoModel;
import restful.Model.Conexion;

public class MovimientoService {
   public ArrayList<MovimientoModel> getMovimiento() {
        ArrayList<MovimientoModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM tipo_movimientos";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                MovimientoModel movimiento = new MovimientoModel();
                movimiento.setId(rs.getInt("id"));
                movimiento.setMovimiento(rs.getString("movimiento"));
                
                lista.add(movimiento);
            }
        } catch (SQLException e) {
        }

        return lista;
    }

    public MovimientoModel getMovimiento(int id) {
        MovimientoModel movimiento = new MovimientoModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM tipo_movimientos WHERE id = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                movimiento.setId(rs.getInt("id"));
                movimiento.setMovimiento(rs.getString("movimiento"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return movimiento;
    }

    public MovimientoModel addMovimiento(MovimientoModel movimiento) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO tipo_movimientos(id,movimiento)";
        Sql = Sql + "values (?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, movimiento.getId());
            pstm.setString(2, movimiento.getMovimiento());
            
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return movimiento;
    }

    public MovimientoModel updateMovimiento(MovimientoModel movimiento) {
        Conexion conn = new Conexion();
        String sql = "UPDATE tipo_movimientos SET movimiento=? WHERE id= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, movimiento.getMovimiento());
            pstm.setInt(2, movimiento.getId());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return movimiento;
    }

    public String delMovimiento(int id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM tipo_movimientos WHERE id= ?";
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
