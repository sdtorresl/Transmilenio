package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_totem")
public class Totem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_totem")
	private Integer id;

    @Column(name = "inv_totem_imagen")
    private String TotemImagen;

    @Column(name = "inv_totem_ruta_imagen")
    private String TotemRutaImagen;

    @Column(name = "inv_totem_desprendimiento")
    private Boolean TotemDesprendimiento;

    @Column(name = "inv_totem_deterioro_pinturaepoxica")
    private Boolean TotemDeterioroPinturaepoxica;

    @Column(name = "inv_totem_perdida_legibilidad")
    private Boolean TotemPerdidaLegibilidad;

    @Column(name = "inv_totem_contaminacion")
    private Boolean TotemContaminacion;

    @Column(name = "inv_totem_corrosion")
    private Boolean TotemCorrosion;

    @Column(name = "inv_totem_abolladura")
    private Boolean TotemAbolladura;

    @Column(name = "inv_totem_porcentajeaveria")
    private Double TotemPorcentajeaveria;

    @Column(name = "inv_totem_averia")
    private Boolean TotemAveria;

    @Column(name = "inv_totem_largo")
    private Double TotemLargo;

    @Column(name = "inv_totem_alto")
    private Double TotemAlto;

    @Column(name = "inv_totem_ancho")
    private Double TotemAncho;

    @Column(name = "inv_totem_id")
    private Double TotemId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setTotemImagen(String TotemImagen) {this.TotemImagen = TotemImagen;}
	public String getTotemImagen() {return TotemImagen;}
	public void setTotemRutaImagen(String TotemRutaImagen) {this.TotemRutaImagen = TotemRutaImagen;}
	public String getTotemRutaImagen() {return TotemRutaImagen;}
	public void setTotemDesprendimiento(Boolean TotemDesprendimiento) {this.TotemDesprendimiento = TotemDesprendimiento;}
	public Boolean getTotemDesprendimiento() {return TotemDesprendimiento;}
	public void setTotemDeterioroPinturaepoxica(Boolean TotemDeterioroPinturaepoxica) {this.TotemDeterioroPinturaepoxica = TotemDeterioroPinturaepoxica;}
	public Boolean getTotemDeterioroPinturaepoxica() {return TotemDeterioroPinturaepoxica;}
	public void setTotemPerdidaLegibilidad(Boolean TotemPerdidaLegibilidad) {this.TotemPerdidaLegibilidad = TotemPerdidaLegibilidad;}
	public Boolean getTotemPerdidaLegibilidad() {return TotemPerdidaLegibilidad;}
	public void setTotemContaminacion(Boolean TotemContaminacion) {this.TotemContaminacion = TotemContaminacion;}
	public Boolean getTotemContaminacion() {return TotemContaminacion;}
	public void setTotemCorrosion(Boolean TotemCorrosion) {this.TotemCorrosion = TotemCorrosion;}
	public Boolean getTotemCorrosion() {return TotemCorrosion;}
	public void setTotemAbolladura(Boolean TotemAbolladura) {this.TotemAbolladura = TotemAbolladura;}
	public Boolean getTotemAbolladura() {return TotemAbolladura;}
	public void setTotemPorcentajeaveria(Double TotemPorcentajeaveria) {this.TotemPorcentajeaveria = TotemPorcentajeaveria;}
	public Double getTotemPorcentajeaveria() {return TotemPorcentajeaveria;}
	public void setTotemAveria(Boolean TotemAveria) {this.TotemAveria = TotemAveria;}
	public Boolean getTotemAveria() {return TotemAveria;}
	public void setTotemLargo(Double TotemLargo) {this.TotemLargo = TotemLargo;}
	public Double getTotemLargo() {return TotemLargo;}
	public void setTotemAlto(Double TotemAlto) {this.TotemAlto = TotemAlto;}
	public Double getTotemAlto() {return TotemAlto;}
	public void setTotemAncho(Double TotemAncho) {this.TotemAncho = TotemAncho;}
	public Double getTotemAncho() {return TotemAncho;}
	public void setTotemId(Double TotemId) {this.TotemId = TotemId;}
	public Double getTotemId() {return TotemId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}