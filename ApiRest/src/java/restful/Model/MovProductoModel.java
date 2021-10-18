
package restful.Model;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class MovProductoModel {
    private int id;
    private int id_producto;
    private int id_usuario;
    private int cantidad;
    private int fecha_registro;
    private int id_tipo_movimiento;

    public MovProductoModel() {
    }

    public MovProductoModel(int id, int id_producto, int id_usuario, int cantidad, int fecha_registro, int id_tipo_movimiento) {
        this.id = id;
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
        this.cantidad = cantidad;
        this.fecha_registro = fecha_registro;
        this.id_tipo_movimiento = id_tipo_movimiento;
    }

    public int getId() {
        return id;
    }

    public int getId_producto() {
        return id_producto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getFecha_registro() {
        return fecha_registro;
    }

    public int getId_tipo_movimiento() {
        return id_tipo_movimiento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha_registro(int fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public void setId_tipo_movimiento(int id_tipo_movimiento) {
        this.id_tipo_movimiento = id_tipo_movimiento;
    }
    
    
    
    
}
