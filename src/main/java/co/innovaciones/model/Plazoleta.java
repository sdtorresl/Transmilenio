package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_plazoleta")
public class Plazoleta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_id_plazoleta")
    private Double IdPlazoleta;

    @Column(name = "inv_plazoleta_id")
    private Double PlazoletaId;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setIdPlazoleta(Double IdPlazoleta) {this.IdPlazoleta = IdPlazoleta;}
	public Double getIdPlazoleta() {return IdPlazoleta;}
	public void setPlazoletaId(Double PlazoletaId) {this.PlazoletaId = PlazoletaId;}
	public Double getPlazoletaId() {return PlazoletaId;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}