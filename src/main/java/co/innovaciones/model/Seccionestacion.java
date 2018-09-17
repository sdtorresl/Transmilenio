package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_seccionestacion")
public class Seccionestacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_estacion")
    private Double IdEstacion;

    @Column(name = "inv_seccion_subseccion")
    private String SeccionSubseccion;

    @Column(name = "inv_id_seccion")
    private Double IdSeccion;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setIdEstacion(Double IdEstacion) {this.IdEstacion = IdEstacion;}
	public Double getIdEstacion() {return IdEstacion;}
	public void setSeccionSubseccion(String SeccionSubseccion) {this.SeccionSubseccion = SeccionSubseccion;}
	public String getSeccionSubseccion() {return SeccionSubseccion;}
	public void setIdSeccion(Double IdSeccion) {this.IdSeccion = IdSeccion;}
	public Double getIdSeccion() {return IdSeccion;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}