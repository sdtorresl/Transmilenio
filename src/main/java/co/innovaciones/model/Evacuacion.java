package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_evacuacion")
public class Evacuacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_evacuacion")
    private Double IdEvacuacion;

    @Column(name = "inv_evacuacion_id")
    private Double EvacuacionId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_evacuacion_averia")
    private Boolean EvacuacionAveria;

    @Column(name = "inv_evacuacion_malestado")
    private Boolean EvacuacionMalestado;

    @Column(name = "inv_evacuacion_legible")
    private Boolean EvacuacionLegible;

    @Column(name = "inv_evacuacion_perdida")
    private Boolean EvacuacionPerdida;

    @Column(name = "inv_evacuacion_tipologia")
    private String EvacuacionTipologia;

	public void setIdEvacuacion(Double IdEvacuacion) {this.IdEvacuacion = IdEvacuacion;}
	public Double getIdEvacuacion() {return IdEvacuacion;}
	public void setEvacuacionId(Double EvacuacionId) {this.EvacuacionId = EvacuacionId;}
	public Double getEvacuacionId() {return EvacuacionId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setEvacuacionAveria(Boolean EvacuacionAveria) {this.EvacuacionAveria = EvacuacionAveria;}
	public Boolean getEvacuacionAveria() {return EvacuacionAveria;}
	public void setEvacuacionMalestado(Boolean EvacuacionMalestado) {this.EvacuacionMalestado = EvacuacionMalestado;}
	public Boolean getEvacuacionMalestado() {return EvacuacionMalestado;}
	public void setEvacuacionLegible(Boolean EvacuacionLegible) {this.EvacuacionLegible = EvacuacionLegible;}
	public Boolean getEvacuacionLegible() {return EvacuacionLegible;}
	public void setEvacuacionPerdida(Boolean EvacuacionPerdida) {this.EvacuacionPerdida = EvacuacionPerdida;}
	public Boolean getEvacuacionPerdida() {return EvacuacionPerdida;}
	public void setEvacuacionTipologia(String EvacuacionTipologia) {this.EvacuacionTipologia = EvacuacionTipologia;}
	public String getEvacuacionTipologia() {return EvacuacionTipologia;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}