package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_corral")
public class Corral implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_corral_area")
    private Double CorralArea;

    @Column(name = "inv_corral_id")
    private Double CorralId;

    @Column(name = "inv_corral_largo")
    private Double CorralLargo;

    @Column(name = "inv_id_corral")
    private Double IdCorral;

    @Column(name = "inv_corral_ancho")
    private Double CorralAncho;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCorralArea(Double CorralArea) {this.CorralArea = CorralArea;}
	public Double getCorralArea() {return CorralArea;}
	public void setCorralId(Double CorralId) {this.CorralId = CorralId;}
	public Double getCorralId() {return CorralId;}
	public void setCorralLargo(Double CorralLargo) {this.CorralLargo = CorralLargo;}
	public Double getCorralLargo() {return CorralLargo;}
	public void setIdCorral(Double IdCorral) {this.IdCorral = IdCorral;}
	public Double getIdCorral() {return IdCorral;}
	public void setCorralAncho(Double CorralAncho) {this.CorralAncho = CorralAncho;}
	public Double getCorralAncho() {return CorralAncho;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}