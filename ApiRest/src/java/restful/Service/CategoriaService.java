
package restful.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.Model.CategoriaModel;
import restful.Model.Conexion;

public class CategoriaService {
    public ArrayList<CategoriaModel> getCategoria() {
        ArrayList<CategoriaModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM categorias";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                CategoriaModel categoria = new CategoriaModel();
                categoria.setId(rs.getInt("id"));
                categoria.setCategoria(rs.getString("categoria"));
                categoria.setDescripcion(rs.getString("descripción"));
                
                lista.add(categoria);
            }
        } catch (SQLException e) {
        }

        return lista;
    }

    public CategoriaModel getCategoria(int id) {
        CategoriaModel categoria = new CategoriaModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM categorias WHERE id = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                categoria.setId(rs.getInt("id"));
                categoria.setCategoria(rs.getString("categoria"));
                categoria.setDescripcion(rs.getString("descripción"));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return categoria;
    }

    public CategoriaModel addCategoria(CategoriaModel categoria) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO categorias(id,categoria,descripción)";
        Sql = Sql + "values (?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, categoria.getId());
            pstm.setString(2, categoria.getCategoria());
            pstm.setString(3, categoria.getDescripcion());
            
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return categoria;
    }

    public CategoriaModel updateCategoria(CategoriaModel categoria) {
        Conexion conn = new Conexion();
        String sql = "UPDATE categorias SET categoria=?,descripción=? WHERE id= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, categoria.getCategoria());
            pstm.setString(2, categoria.getDescripcion());
            pstm.setInt(3, categoria.getId());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return categoria;
    }

    public String delCategoria(int id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM categorias WHERE id= ?";
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
