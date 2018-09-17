package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_rack")
public class Rack implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_rack_numero")
    private String RackNumero;

    @Column(name = "inv_rack_propietario")
    private String RackPropietario;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setRackNumero(String RackNumero) {this.RackNumero = RackNumero;}
	public String getRackNumero() {return RackNumero;}
	public void setRackPropietario(String RackPropietario) {this.RackPropietario = RackPropietario;}
	public String getRackPropietario() {return RackPropietario;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}