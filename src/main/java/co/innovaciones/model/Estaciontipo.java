package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_estaciontipo")
public class Estaciontipo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_estaciontipo_intercambio")
    private Boolean EstaciontipoIntercambio;

    @Column(name = "inv_estaciontipo_descripcion")
    private String EstaciontipoDescripcion;

    @Column(name = "inv_estaciontipo_nombre")
    private String EstaciontipoNombre;

	public void setEstaciontipoIntercambio(Boolean EstaciontipoIntercambio) {this.EstaciontipoIntercambio = EstaciontipoIntercambio;}
	public Boolean getEstaciontipoIntercambio() {return EstaciontipoIntercambio;}
	public void setEstaciontipoDescripcion(String EstaciontipoDescripcion) {this.EstaciontipoDescripcion = EstaciontipoDescripcion;}
	public String getEstaciontipoDescripcion() {return EstaciontipoDescripcion;}
	public void setEstaciontipoNombre(String EstaciontipoNombre) {this.EstaciontipoNombre = EstaciontipoNombre;}
	public String getEstaciontipoNombre() {return EstaciontipoNombre;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}