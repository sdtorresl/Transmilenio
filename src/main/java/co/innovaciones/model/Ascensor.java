package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_ascensor")
public class Ascensor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_ascensor_id")
    private Double AscensorId;

    @Column(name = "inv_ascensor_marca")
    private String AscensorMarca;

    @Column(name = "inv_ascensor_averiapuerta")
    private Boolean AscensorAveriapuerta;

    @Column(name = "inv_ascensor_averiatablero")
    private Boolean AscensorAveriatablero;

    @Column(name = "inv_ascensor_sincronizacion")
    private Boolean AscensorSincronizacion;

    @Column(name = "inv_ascensor_emision")
    private Boolean AscensorEmision;

    @Column(name = "inv_ascensor_averialuz")
    private Boolean AscensorAverialuz;

    @Column(name = "inv_ascensor_fisuravidrio")
    private Boolean AscensorFisuravidrio;

    @Column(name = "inv_ascensor_sinservicio")
    private Boolean AscensorSinservicio;

    @Column(name = "inv_ascensor_ruta_imagen")
    private String AscensorRutaImagen;

    @Column(name = "inv_ascensor_imagen")
    private String AscensorImagen;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setAscensorId(Double AscensorId) {this.AscensorId = AscensorId;}
	public Double getAscensorId() {return AscensorId;}
	public void setAscensorMarca(String AscensorMarca) {this.AscensorMarca = AscensorMarca;}
	public String getAscensorMarca() {return AscensorMarca;}
	public void setAscensorAveriapuerta(Boolean AscensorAveriapuerta) {this.AscensorAveriapuerta = AscensorAveriapuerta;}
	public Boolean getAscensorAveriapuerta() {return AscensorAveriapuerta;}
	public void setAscensorAveriatablero(Boolean AscensorAveriatablero) {this.AscensorAveriatablero = AscensorAveriatablero;}
	public Boolean getAscensorAveriatablero() {return AscensorAveriatablero;}
	public void setAscensorSincronizacion(Boolean AscensorSincronizacion) {this.AscensorSincronizacion = AscensorSincronizacion;}
	public Boolean getAscensorSincronizacion() {return AscensorSincronizacion;}
	public void setAscensorEmision(Boolean AscensorEmision) {this.AscensorEmision = AscensorEmision;}
	public Boolean getAscensorEmision() {return AscensorEmision;}
	public void setAscensorAverialuz(Boolean AscensorAverialuz) {this.AscensorAverialuz = AscensorAverialuz;}
	public Boolean getAscensorAverialuz() {return AscensorAverialuz;}
	public void setAscensorFisuravidrio(Boolean AscensorFisuravidrio) {this.AscensorFisuravidrio = AscensorFisuravidrio;}
	public Boolean getAscensorFisuravidrio() {return AscensorFisuravidrio;}
	public void setAscensorSinservicio(Boolean AscensorSinservicio) {this.AscensorSinservicio = AscensorSinservicio;}
	public Boolean getAscensorSinservicio() {return AscensorSinservicio;}
	public void setAscensorRutaImagen(String AscensorRutaImagen) {this.AscensorRutaImagen = AscensorRutaImagen;}
	public String getAscensorRutaImagen() {return AscensorRutaImagen;}
	public void setAscensorImagen(String AscensorImagen) {this.AscensorImagen = AscensorImagen;}
	public String getAscensorImagen() {return AscensorImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}