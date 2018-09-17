package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_noopera")
public class Noopera implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_noopera")
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_noopera_tipo")
    private String NooperaTipo;

    @Column(name = "inv_noopera_area")
    private Double NooperaArea;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setNooperaTipo(String NooperaTipo) {this.NooperaTipo = NooperaTipo;}
	public String getNooperaTipo() {return NooperaTipo;}
	public void setNooperaArea(Double NooperaArea) {this.NooperaArea = NooperaArea;}
	public Double getNooperaArea() {return NooperaArea;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}