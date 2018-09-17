package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_barandaentrada")
public class Barandaentrada implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_barandaentrada")
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_barandaentrada_id")
    private Double BarandaentradaId;

    @Column(name = "inv_barandaentrada_costado")
    private String BarandaentradaCostado;

    @Column(name = "inv_barandaentrada_largo")
    private Double BarandaentradaLargo;

    @Column(name = "inv_barandaentrada_alto")
    private Double BarandaentradaAlto;

    @Column(name = "inv_barandaentrada_malestado")
    private Boolean BarandaentradaMalestado;

    @Column(name = "inv_barandaentrada_rayones")
    private Boolean BarandaentradaRayones;

    @Column(name = "inv_barandaentrada_fisura")
    private Boolean BarandaentradaFisura;

    @Column(name = "inv_barandaentrada_contaminacion")
    private Boolean BarandaentradaContaminacion;

    @Column(name = "inv_barandaentrada_desaparicionvidrio")
    private Boolean BarandaentradaDesaparicionvidrio;

    @Column(name = "inv_barandaentrada_sinclar")
    private Boolean BarandaentradaSinclar;

    @Column(name = "inv_barandaentrada_perdida")
    private Boolean BarandaentradaPerdida;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setBarandaentradaId(Double BarandaentradaId) {this.BarandaentradaId = BarandaentradaId;}
	public Double getBarandaentradaId() {return BarandaentradaId;}
	public void setBarandaentradaCostado(String BarandaentradaCostado) {this.BarandaentradaCostado = BarandaentradaCostado;}
	public String getBarandaentradaCostado() {return BarandaentradaCostado;}
	public void setBarandaentradaLargo(Double BarandaentradaLargo) {this.BarandaentradaLargo = BarandaentradaLargo;}
	public Double getBarandaentradaLargo() {return BarandaentradaLargo;}
	public void setBarandaentradaAlto(Double BarandaentradaAlto) {this.BarandaentradaAlto = BarandaentradaAlto;}
	public Double getBarandaentradaAlto() {return BarandaentradaAlto;}
	public void setBarandaentradaMalestado(Boolean BarandaentradaMalestado) {this.BarandaentradaMalestado = BarandaentradaMalestado;}
	public Boolean getBarandaentradaMalestado() {return BarandaentradaMalestado;}
	public void setBarandaentradaRayones(Boolean BarandaentradaRayones) {this.BarandaentradaRayones = BarandaentradaRayones;}
	public Boolean getBarandaentradaRayones() {return BarandaentradaRayones;}
	public void setBarandaentradaFisura(Boolean BarandaentradaFisura) {this.BarandaentradaFisura = BarandaentradaFisura;}
	public Boolean getBarandaentradaFisura() {return BarandaentradaFisura;}
	public void setBarandaentradaContaminacion(Boolean BarandaentradaContaminacion) {this.BarandaentradaContaminacion = BarandaentradaContaminacion;}
	public Boolean getBarandaentradaContaminacion() {return BarandaentradaContaminacion;}
	public void setBarandaentradaDesaparicionvidrio(Boolean BarandaentradaDesaparicionvidrio) {this.BarandaentradaDesaparicionvidrio = BarandaentradaDesaparicionvidrio;}
	public Boolean getBarandaentradaDesaparicionvidrio() {return BarandaentradaDesaparicionvidrio;}
	public void setBarandaentradaSinclar(Boolean BarandaentradaSinclar) {this.BarandaentradaSinclar = BarandaentradaSinclar;}
	public Boolean getBarandaentradaSinclar() {return BarandaentradaSinclar;}
	public void setBarandaentradaPerdida(Boolean BarandaentradaPerdida) {this.BarandaentradaPerdida = BarandaentradaPerdida;}
	public Boolean getBarandaentradaPerdida() {return BarandaentradaPerdida;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}