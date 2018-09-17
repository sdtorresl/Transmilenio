package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_ventilacion")
public class Ventilacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_ventilacion")
	private Integer id;

    @Column(name = "inv_ventilacion_tipo")
    private Double VentilacionTipo;

    @Column(name = "inv_ventilacion_id")
    private Double VentilacionId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setVentilacionTipo(Double VentilacionTipo) {this.VentilacionTipo = VentilacionTipo;}
	public Double getVentilacionTipo() {return VentilacionTipo;}
	public void setVentilacionId(Double VentilacionId) {this.VentilacionId = VentilacionId;}
	public Double getVentilacionId() {return VentilacionId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}