
package restful.Model;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class ProductoModel {
    private int id;
    private String nombre_producto;
    private String descripcion;
    private String referencia;
    private int cantidad;
    private int id_categoria;

    public ProductoModel() {
    }

    public ProductoModel(int id, String nombre_producto, String descripcion, String referencia, int cantidad, int id_categoria) {
        this.id = id;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.id_categoria = id_categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    
}
