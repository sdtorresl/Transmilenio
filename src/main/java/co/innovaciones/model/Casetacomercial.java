package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_casetacomercial")
public class Casetacomercial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_casetacomercial_averia")
    private Boolean CasetacomercialAveria;

    @Column(name = "inv_casetacomercial_alto")
    private Double CasetacomercialAlto;

    @Column(name = "inv_casetacomercial_largo")
    private Double CasetacomercialLargo;

    @Column(name = "inv_casetacomercial_id")
    private Double CasetacomercialId;

    @Column(name = "inv_casetacomercial_numeracion")
    private Double CasetacomercialNumeracion;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_casetacomercial_imagen")
    private String CasetacomercialImagen;

    @Column(name = "inv_casetacomercial_ruta_imagen")
    private String CasetacomercialRutaImagen;

    @Column(name = "inv_casetacomercial_contaminacion")
    private Boolean CasetacomercialContaminacion;

    @Column(name = "inv_casetacomercial_averiaestructura")
    private Boolean CasetacomercialAveriaestructura;

	public void setCasetacomercialAveria(Boolean CasetacomercialAveria) {this.CasetacomercialAveria = CasetacomercialAveria;}
	public Boolean getCasetacomercialAveria() {return CasetacomercialAveria;}
	public void setCasetacomercialAlto(Double CasetacomercialAlto) {this.CasetacomercialAlto = CasetacomercialAlto;}
	public Double getCasetacomercialAlto() {return CasetacomercialAlto;}
	public void setCasetacomercialLargo(Double CasetacomercialLargo) {this.CasetacomercialLargo = CasetacomercialLargo;}
	public Double getCasetacomercialLargo() {return CasetacomercialLargo;}
	public void setCasetacomercialId(Double CasetacomercialId) {this.CasetacomercialId = CasetacomercialId;}
	public Double getCasetacomercialId() {return CasetacomercialId;}
	public void setCasetacomercialNumeracion(Double CasetacomercialNumeracion) {this.CasetacomercialNumeracion = CasetacomercialNumeracion;}
	public Double getCasetacomercialNumeracion() {return CasetacomercialNumeracion;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCasetacomercialImagen(String CasetacomercialImagen) {this.CasetacomercialImagen = CasetacomercialImagen;}
	public String getCasetacomercialImagen() {return CasetacomercialImagen;}
	public void setCasetacomercialRutaImagen(String CasetacomercialRutaImagen) {this.CasetacomercialRutaImagen = CasetacomercialRutaImagen;}
	public String getCasetacomercialRutaImagen() {return CasetacomercialRutaImagen;}
	public void setCasetacomercialContaminacion(Boolean CasetacomercialContaminacion) {this.CasetacomercialContaminacion = CasetacomercialContaminacion;}
	public Boolean getCasetacomercialContaminacion() {return CasetacomercialContaminacion;}
	public void setCasetacomercialAveriaestructura(Boolean CasetacomercialAveriaestructura) {this.CasetacomercialAveriaestructura = CasetacomercialAveriaestructura;}
	public Boolean getCasetacomercialAveriaestructura() {return CasetacomercialAveriaestructura;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}