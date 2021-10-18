
package restful.Model;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class MovimientoModel {
    private int id;
    private String movimiento;

    public MovimientoModel() {
    }

    public MovimientoModel(int id, String movimiento) {
        this.id = id;
        this.movimiento = movimiento;
    }

    public int getId() {
        return id;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }
    
    
}
