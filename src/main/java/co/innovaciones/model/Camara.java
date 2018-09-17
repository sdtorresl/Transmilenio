package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_camara")
public class Camara implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_camara")
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_camara_id")
    private Double CamaraId;

    @Column(name = "inv_camara_tipo_vision")
    private String CamaraTipoVision;

    @Column(name = "inv_camara_tipo")
    private String CamaraTipo;

    @Column(name = "inv_camara_costado")
    private String CamaraCostado;

    @Column(name = "inv_camara_averia")
    private Boolean CamaraAveria;

    @Column(name = "inv_camara_faltapieza")
    private Boolean CamaraFaltapieza;

    @Column(name = "inv_camara_porcentajepiezafalta")
    private Double CamaraPorcentajepiezafalta;

    @Column(name = "inv_camara_falta")
    private Boolean CamaraFalta;

    @Column(name = "inv_camara_averiasoporte")
    private Boolean CamaraAveriasoporte;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCamaraId(Double CamaraId) {this.CamaraId = CamaraId;}
	public Double getCamaraId() {return CamaraId;}
	public void setCamaraTipoVision(String CamaraTipoVision) {this.CamaraTipoVision = CamaraTipoVision;}
	public String getCamaraTipoVision() {return CamaraTipoVision;}
	public void setCamaraTipo(String CamaraTipo) {this.CamaraTipo = CamaraTipo;}
	public String getCamaraTipo() {return CamaraTipo;}
	public void setCamaraCostado(String CamaraCostado) {this.CamaraCostado = CamaraCostado;}
	public String getCamaraCostado() {return CamaraCostado;}
	public void setCamaraAveria(Boolean CamaraAveria) {this.CamaraAveria = CamaraAveria;}
	public Boolean getCamaraAveria() {return CamaraAveria;}
	public void setCamaraFaltapieza(Boolean CamaraFaltapieza) {this.CamaraFaltapieza = CamaraFaltapieza;}
	public Boolean getCamaraFaltapieza() {return CamaraFaltapieza;}
	public void setCamaraPorcentajepiezafalta(Double CamaraPorcentajepiezafalta) {this.CamaraPorcentajepiezafalta = CamaraPorcentajepiezafalta;}
	public Double getCamaraPorcentajepiezafalta() {return CamaraPorcentajepiezafalta;}
	public void setCamaraFalta(Boolean CamaraFalta) {this.CamaraFalta = CamaraFalta;}
	public Boolean getCamaraFalta() {return CamaraFalta;}
	public void setCamaraAveriasoporte(Boolean CamaraAveriasoporte) {this.CamaraAveriasoporte = CamaraAveriasoporte;}
	public Boolean getCamaraAveriasoporte() {return CamaraAveriasoporte;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}