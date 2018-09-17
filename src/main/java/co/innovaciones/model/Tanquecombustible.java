package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_tanquecombustible")
public class Tanquecombustible implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_tanquecombustible_id")
    private Double TanquecombustibleId;

    @Column(name = "inv_id_tanquecombustible")
    private Double IdTanquecombustible;

    @Column(name = "inv_tanquecombustible_ubicacion")
    private String TanquecombustibleUbicacion;

    @Column(name = "inv_tanquecombustible_capacidad")
    private String TanquecombustibleCapacidad;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setTanquecombustibleId(Double TanquecombustibleId) {this.TanquecombustibleId = TanquecombustibleId;}
	public Double getTanquecombustibleId() {return TanquecombustibleId;}
	public void setIdTanquecombustible(Double IdTanquecombustible) {this.IdTanquecombustible = IdTanquecombustible;}
	public Double getIdTanquecombustible() {return IdTanquecombustible;}
	public void setTanquecombustibleUbicacion(String TanquecombustibleUbicacion) {this.TanquecombustibleUbicacion = TanquecombustibleUbicacion;}
	public String getTanquecombustibleUbicacion() {return TanquecombustibleUbicacion;}
	public void setTanquecombustibleCapacidad(String TanquecombustibleCapacidad) {this.TanquecombustibleCapacidad = TanquecombustibleCapacidad;}
	public String getTanquecombustibleCapacidad() {return TanquecombustibleCapacidad;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}