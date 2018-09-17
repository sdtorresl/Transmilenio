package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Table(name = "inv_tipo")
public class Tipo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inv_id_tipo")
    private Integer id;

    @Column(name = "inv_tipo_tabla")
    private String tabla;

    @Column(name = "inv_tipo_nombre")
    private String nombre;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

    public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getTabla() {
		return this.tabla;
    }
    
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}
}