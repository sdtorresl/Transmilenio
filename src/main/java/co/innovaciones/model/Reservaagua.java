package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_reservaagua")
public class Reservaagua implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_reservaagua")
	private Integer id;

    @Column(name = "inv_reservaagua_id")
    private Double ReservaaguaId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_reservaagua_capacidad")
    private Double ReservaaguaCapacidad;

    @Column(name = "inv_reservaagua_ubicacion")
    private String ReservaaguaUbicacion;

	public void setReservaaguaId(Double ReservaaguaId) {this.ReservaaguaId = ReservaaguaId;}
	public Double getReservaaguaId() {return ReservaaguaId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setReservaaguaCapacidad(Double ReservaaguaCapacidad) {this.ReservaaguaCapacidad = ReservaaguaCapacidad;}
	public Double getReservaaguaCapacidad() {return ReservaaguaCapacidad;}
	public void setReservaaguaUbicacion(String ReservaaguaUbicacion) {this.ReservaaguaUbicacion = ReservaaguaUbicacion;}
	public String getReservaaguaUbicacion() {return ReservaaguaUbicacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}