
package restful.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.Model.ProductoModel;
import restful.Model.Conexion;

public class ProductoService {
  public ArrayList<ProductoModel> getProducto() {
        ArrayList<ProductoModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM productos";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ProductoModel producto = new ProductoModel();
                producto.setId(rs.getInt("id"));
                producto.setNombre_producto(rs.getString("nombre_producto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setReferencia(rs.getString("referencia"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setId_categoria(rs.getInt("id_categoria"));
                lista.add(producto);
            }
        } catch (SQLException e) {
        }

        return lista;
    }

    public ProductoModel getProducto(int id) {
        ProductoModel producto = new ProductoModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM productos WHERE id = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                producto.setId(rs.getInt("id"));
                producto.setNombre_producto(rs.getString("nombre_producto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setReferencia(rs.getString("referencia"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setId_categoria(rs.getInt("id_categoria"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return producto;
    }

    public ProductoModel addProducto(ProductoModel producto) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO productos(id,nombre_producto,descripcion,referencia,cantidad,id_categoria)";
        Sql = Sql + "values (?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, producto.getId());
            pstm.setString(2, producto.getNombre_producto());
            pstm.setString(3, producto.getDescripcion());
            pstm.setString(4, producto.getReferencia());
            pstm.setInt(5, producto.getCantidad());
            pstm.setInt(6, producto.getId_categoria());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return producto;
    }

    public ProductoModel updateProducto(ProductoModel producto) {
        Conexion conn = new Conexion();
        String sql = "UPDATE productos SET nombre_producto=?,descripcion=?,referencia=?,cantidad=?,id_categoria=? WHERE id= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, producto.getNombre_producto());
            pstm.setString(2, producto.getDescripcion());
            pstm.setString(3, producto.getReferencia());
            pstm.setInt(4, producto.getCantidad());
            pstm.setInt(5, producto.getId_categoria());
            pstm.setInt(6, producto.getId());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return producto;
    }

    public String delProducto(int id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM productos WHERE id= ?";
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
