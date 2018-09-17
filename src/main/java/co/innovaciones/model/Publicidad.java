package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_publicidad")
public class Publicidad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_publicidad_fisuravidrio")
    private Boolean PublicidadFisuravidrio;

    @Column(name = "inv_id_publicidad")
    private Double IdPublicidad;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_ventilacion_id")
    private Double VentilacionId;

    @Column(name = "inv_publicidad_alto")
    private Double PublicidadAlto;

    @Column(name = "inv_publicidad_ancho")
    private Double PublicidadAncho;

    @Column(name = "inv_publicidad_costado")
    private String PublicidadCostado;

    @Column(name = "inv_publicidad_averia")
    private Boolean PublicidadAveria;

    @Column(name = "inv_publicidad_deteriorometalico")
    private Boolean PublicidadDeteriorometalico;

    @Column(name = "inv_publicidad_iluminacion")
    private Boolean PublicidadIluminacion;

    @Column(name = "inv_publicidad_parpadeoluz")
    private Boolean PublicidadParpadeoluz;

    @Column(name = "inv_publicidad_sinvidrio")
    private Boolean PublicidadSinvidrio;

    @Column(name = "inv_publicidad_deteriorovidrio")
    private Boolean PublicidadDeteriorovidrio;

    @Column(name = "inv_publicidad_contaminacionvisual")
    private Boolean PublicidadContaminacionvisual;

    @Column(name = "inv_publicidad_conpublicidad")
    private Boolean PublicidadConpublicidad;

	public void setPublicidadFisuravidrio(Boolean PublicidadFisuravidrio) {this.PublicidadFisuravidrio = PublicidadFisuravidrio;}
	public Boolean getPublicidadFisuravidrio() {return PublicidadFisuravidrio;}
	public void setIdPublicidad(Double IdPublicidad) {this.IdPublicidad = IdPublicidad;}
	public Double getIdPublicidad() {return IdPublicidad;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setVentilacionId(Double VentilacionId) {this.VentilacionId = VentilacionId;}
	public Double getVentilacionId() {return VentilacionId;}
	public void setPublicidadAlto(Double PublicidadAlto) {this.PublicidadAlto = PublicidadAlto;}
	public Double getPublicidadAlto() {return PublicidadAlto;}
	public void setPublicidadAncho(Double PublicidadAncho) {this.PublicidadAncho = PublicidadAncho;}
	public Double getPublicidadAncho() {return PublicidadAncho;}
	public void setPublicidadCostado(String PublicidadCostado) {this.PublicidadCostado = PublicidadCostado;}
	public String getPublicidadCostado() {return PublicidadCostado;}
	public void setPublicidadAveria(Boolean PublicidadAveria) {this.PublicidadAveria = PublicidadAveria;}
	public Boolean getPublicidadAveria() {return PublicidadAveria;}
	public void setPublicidadDeteriorometalico(Boolean PublicidadDeteriorometalico) {this.PublicidadDeteriorometalico = PublicidadDeteriorometalico;}
	public Boolean getPublicidadDeteriorometalico() {return PublicidadDeteriorometalico;}
	public void setPublicidadIluminacion(Boolean PublicidadIluminacion) {this.PublicidadIluminacion = PublicidadIluminacion;}
	public Boolean getPublicidadIluminacion() {return PublicidadIluminacion;}
	public void setPublicidadParpadeoluz(Boolean PublicidadParpadeoluz) {this.PublicidadParpadeoluz = PublicidadParpadeoluz;}
	public Boolean getPublicidadParpadeoluz() {return PublicidadParpadeoluz;}
	public void setPublicidadSinvidrio(Boolean PublicidadSinvidrio) {this.PublicidadSinvidrio = PublicidadSinvidrio;}
	public Boolean getPublicidadSinvidrio() {return PublicidadSinvidrio;}
	public void setPublicidadDeteriorovidrio(Boolean PublicidadDeteriorovidrio) {this.PublicidadDeteriorovidrio = PublicidadDeteriorovidrio;}
	public Boolean getPublicidadDeteriorovidrio() {return PublicidadDeteriorovidrio;}
	public void setPublicidadContaminacionvisual(Boolean PublicidadContaminacionvisual) {this.PublicidadContaminacionvisual = PublicidadContaminacionvisual;}
	public Boolean getPublicidadContaminacionvisual() {return PublicidadContaminacionvisual;}
	public void setPublicidadConpublicidad(Boolean PublicidadConpublicidad) {this.PublicidadConpublicidad = PublicidadConpublicidad;}
	public Boolean getPublicidadConpublicidad() {return PublicidadConpublicidad;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}