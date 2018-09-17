package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_senale")
public class Senale implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_senale")
	private Integer id;

    @Column(name = "inv_senale_ilegible")
    private Boolean SenaleIlegible;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_senale_id")
    private Double SenaleId;

    @Column(name = "inv_senale_tipo")
    private Double SenaleTipo;

    @Column(name = "inv_senale_costado")
    private String SenaleCostado;

    @Column(name = "inv_senale_tipologia")
    private String SenaleTipologia;

    @Column(name = "inv_senale_averia")
    private Boolean SenaleAveria;

    @Column(name = "inv_senale_perdida")
    private Boolean SenalePerdida;

	public void setSenaleIlegible(Boolean SenaleIlegible) {this.SenaleIlegible = SenaleIlegible;}
	public Boolean getSenaleIlegible() {return SenaleIlegible;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setSenaleId(Double SenaleId) {this.SenaleId = SenaleId;}
	public Double getSenaleId() {return SenaleId;}
	public void setSenaleTipo(Double SenaleTipo) {this.SenaleTipo = SenaleTipo;}
	public Double getSenaleTipo() {return SenaleTipo;}
	public void setSenaleCostado(String SenaleCostado) {this.SenaleCostado = SenaleCostado;}
	public String getSenaleCostado() {return SenaleCostado;}
	public void setSenaleTipologia(String SenaleTipologia) {this.SenaleTipologia = SenaleTipologia;}
	public String getSenaleTipologia() {return SenaleTipologia;}
	public void setSenaleAveria(Boolean SenaleAveria) {this.SenaleAveria = SenaleAveria;}
	public Boolean getSenaleAveria() {return SenaleAveria;}
	public void setSenalePerdida(Boolean SenalePerdida) {this.SenalePerdida = SenalePerdida;}
	public Boolean getSenalePerdida() {return SenalePerdida;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}