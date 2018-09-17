package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_reStringida")
public class ReStringida implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_reStringida")
    private Double IdReStringida;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_reStringida_id")
    private Double ReStringidaId;

	public void setIdReStringida(Double IdReStringida) {this.IdReStringida = IdReStringida;}
	public Double getIdReStringida() {return IdReStringida;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setReStringidaId(Double ReStringidaId) {this.ReStringidaId = ReStringidaId;}
	public Double getReStringidaId() {return ReStringidaId;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}