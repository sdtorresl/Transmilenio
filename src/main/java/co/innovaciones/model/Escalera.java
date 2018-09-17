package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_escalera")
public class Escalera implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_escalera")
    private Double IdEscalera;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_escalera_id")
    private Double EscaleraId;

    @Column(name = "inv_escalera_averia")
    private Boolean EscaleraAveria;

    @Column(name = "inv_escalera_porcentajeaveria")
    private Double EscaleraPorcentajeaveria;

    @Column(name = "inv_escalera_tipo")
    private String EscaleraTipo;

	public void setIdEscalera(Double IdEscalera) {this.IdEscalera = IdEscalera;}
	public Double getIdEscalera() {return IdEscalera;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setEscaleraId(Double EscaleraId) {this.EscaleraId = EscaleraId;}
	public Double getEscaleraId() {return EscaleraId;}
	public void setEscaleraAveria(Boolean EscaleraAveria) {this.EscaleraAveria = EscaleraAveria;}
	public Boolean getEscaleraAveria() {return EscaleraAveria;}
	public void setEscaleraPorcentajeaveria(Double EscaleraPorcentajeaveria) {this.EscaleraPorcentajeaveria = EscaleraPorcentajeaveria;}
	public Double getEscaleraPorcentajeaveria() {return EscaleraPorcentajeaveria;}
	public void setEscaleraTipo(String EscaleraTipo) {this.EscaleraTipo = EscaleraTipo;}
	public String getEscaleraTipo() {return EscaleraTipo;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}