package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_parque")
public class Parque implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_parque")
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_parque_id")
    private Double ParqueId;

    @Column(name = "inv_parque_area")
    private Double ParqueArea;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setParqueId(Double ParqueId) {this.ParqueId = ParqueId;}
	public Double getParqueId() {return ParqueId;}
	public void setParqueArea(Double ParqueArea) {this.ParqueArea = ParqueArea;}
	public Double getParqueArea() {return ParqueArea;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}