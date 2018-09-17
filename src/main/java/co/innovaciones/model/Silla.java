package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_silla")
public class Silla implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_silla_largo")
    private Double SillaLargo;

    @Column(name = "inv_silla_id")
    private Double SillaId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_id_silla")
    private Double IdSilla;

    @Column(name = "inv_silla_faltante")
    private Boolean SillaFaltante;

    @Column(name = "inv_silla_carbonatacion")
    private Boolean SillaCarbonatacion;

    @Column(name = "inv_silla_desintegracion")
    private Boolean SillaDesintegracion;

    @Column(name = "inv_silla_pandeo")
    private Boolean SillaPandeo;

    @Column(name = "inv_silla_pandeo_estructura")
    private Boolean SillaPandeoEstructura;

    @Column(name = "inv_silla_alto")
    private Double SillaAlto;

    @Column(name = "inv_silla_averia")
    private Boolean SillaAveria;

    @Column(name = "inv_silla_corrosion")
    private Boolean SillaCorrosion;

    @Column(name = "inv_silla_ancho")
    private Double SillaAncho;

	public void setSillaLargo(Double SillaLargo) {this.SillaLargo = SillaLargo;}
	public Double getSillaLargo() {return SillaLargo;}
	public void setSillaId(Double SillaId) {this.SillaId = SillaId;}
	public Double getSillaId() {return SillaId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setIdSilla(Double IdSilla) {this.IdSilla = IdSilla;}
	public Double getIdSilla() {return IdSilla;}
	public void setSillaFaltante(Boolean SillaFaltante) {this.SillaFaltante = SillaFaltante;}
	public Boolean getSillaFaltante() {return SillaFaltante;}
	public void setSillaCarbonatacion(Boolean SillaCarbonatacion) {this.SillaCarbonatacion = SillaCarbonatacion;}
	public Boolean getSillaCarbonatacion() {return SillaCarbonatacion;}
	public void setSillaDesintegracion(Boolean SillaDesintegracion) {this.SillaDesintegracion = SillaDesintegracion;}
	public Boolean getSillaDesintegracion() {return SillaDesintegracion;}
	public void setSillaPandeo(Boolean SillaPandeo) {this.SillaPandeo = SillaPandeo;}
	public Boolean getSillaPandeo() {return SillaPandeo;}
	public void setSillaPandeoEstructura(Boolean SillaPandeoEstructura) {this.SillaPandeoEstructura = SillaPandeoEstructura;}
	public Boolean getSillaPandeoEstructura() {return SillaPandeoEstructura;}
	public void setSillaAlto(Double SillaAlto) {this.SillaAlto = SillaAlto;}
	public Double getSillaAlto() {return SillaAlto;}
	public void setSillaAveria(Boolean SillaAveria) {this.SillaAveria = SillaAveria;}
	public Boolean getSillaAveria() {return SillaAveria;}
	public void setSillaCorrosion(Boolean SillaCorrosion) {this.SillaCorrosion = SillaCorrosion;}
	public Boolean getSillaCorrosion() {return SillaCorrosion;}
	public void setSillaAncho(Double SillaAncho) {this.SillaAncho = SillaAncho;}
	public Double getSillaAncho() {return SillaAncho;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}