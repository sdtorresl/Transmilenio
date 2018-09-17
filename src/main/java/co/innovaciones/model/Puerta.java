package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_puerta")
public class Puerta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_puerta_id")
    private Double PuertaId;

    @Column(name = "inv_puerta_tipo")
    private String PuertaTipo;

    @Column(name = "inv_puerta_ancho")
    private Double PuertaAncho;

    @Column(name = "inv_puerta_averia")
    private Boolean PuertaAveria;

    @Column(name = "inv_puerta_porcentajeaveria")
    private Double PuertaPorcentajeaveria;

    @Column(name = "inv_puerta_reja_metalica_rota")
    private Boolean PuertaRejaMetalicaRota;

    @Column(name = "inv_puerta_averia_cierre")
    private Boolean PuertaAveriaCierre;

    @Column(name = "inv_puerta_conta_visual")
    private Boolean PuertaContaVisual;

    @Column(name = "inv_puerta_descolgada")
    private Boolean PuertaDescolgada;

    @Column(name = "inv_puerta_faltabisagra")
    private Boolean PuertaFaltabisagra;

    @Column(name = "inv_puerta_corrosion")
    private Boolean PuertaCorrosion;

    @Column(name = "inv_puerta_perdida")
    private Boolean PuertaPerdida;

    @Column(name = "inv_puerta_malestado")
    private Boolean PuertaMalestado;

    @Column(name = "inv_puerta_alto")
    private Double PuertaAlto;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setPuertaId(Double PuertaId) {this.PuertaId = PuertaId;}
	public Double getPuertaId() {return PuertaId;}
	public void setPuertaTipo(String PuertaTipo) {this.PuertaTipo = PuertaTipo;}
	public String getPuertaTipo() {return PuertaTipo;}
	public void setPuertaAncho(Double PuertaAncho) {this.PuertaAncho = PuertaAncho;}
	public Double getPuertaAncho() {return PuertaAncho;}
	public void setPuertaAveria(Boolean PuertaAveria) {this.PuertaAveria = PuertaAveria;}
	public Boolean getPuertaAveria() {return PuertaAveria;}
	public void setPuertaPorcentajeaveria(Double PuertaPorcentajeaveria) {this.PuertaPorcentajeaveria = PuertaPorcentajeaveria;}
	public Double getPuertaPorcentajeaveria() {return PuertaPorcentajeaveria;}
	public void setPuertaRejaMetalicaRota(Boolean PuertaRejaMetalicaRota) {this.PuertaRejaMetalicaRota = PuertaRejaMetalicaRota;}
	public Boolean getPuertaRejaMetalicaRota() {return PuertaRejaMetalicaRota;}
	public void setPuertaAveriaCierre(Boolean PuertaAveriaCierre) {this.PuertaAveriaCierre = PuertaAveriaCierre;}
	public Boolean getPuertaAveriaCierre() {return PuertaAveriaCierre;}
	public void setPuertaContaVisual(Boolean PuertaContaVisual) {this.PuertaContaVisual = PuertaContaVisual;}
	public Boolean getPuertaContaVisual() {return PuertaContaVisual;}
	public void setPuertaDescolgada(Boolean PuertaDescolgada) {this.PuertaDescolgada = PuertaDescolgada;}
	public Boolean getPuertaDescolgada() {return PuertaDescolgada;}
	public void setPuertaFaltabisagra(Boolean PuertaFaltabisagra) {this.PuertaFaltabisagra = PuertaFaltabisagra;}
	public Boolean getPuertaFaltabisagra() {return PuertaFaltabisagra;}
	public void setPuertaCorrosion(Boolean PuertaCorrosion) {this.PuertaCorrosion = PuertaCorrosion;}
	public Boolean getPuertaCorrosion() {return PuertaCorrosion;}
	public void setPuertaPerdida(Boolean PuertaPerdida) {this.PuertaPerdida = PuertaPerdida;}
	public Boolean getPuertaPerdida() {return PuertaPerdida;}
	public void setPuertaMalestado(Boolean PuertaMalestado) {this.PuertaMalestado = PuertaMalestado;}
	public Boolean getPuertaMalestado() {return PuertaMalestado;}
	public void setPuertaAlto(Double PuertaAlto) {this.PuertaAlto = PuertaAlto;}
	public Double getPuertaAlto() {return PuertaAlto;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}