package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_biblioestacion")
public class Biblioestacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_biblioestacion_area")
    private Double BiblioestacionArea;

    @Column(name = "inv_biblioestacion_ancho")
    private Double BiblioestacionAncho;

    @Column(name = "inv_biblioestacion_largo")
    private Double BiblioestacionLargo;

    @Column(name = "inv_biblioestacion_ruta_imagen")
    private String BiblioestacionRutaImagen;

    @Column(name = "inv_biblioestacion_imagen")
    private String BiblioestacionImagen;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setBiblioestacionArea(Double BiblioestacionArea) {this.BiblioestacionArea = BiblioestacionArea;}
	public Double getBiblioestacionArea() {return BiblioestacionArea;}
	public void setBiblioestacionAncho(Double BiblioestacionAncho) {this.BiblioestacionAncho = BiblioestacionAncho;}
	public Double getBiblioestacionAncho() {return BiblioestacionAncho;}
	public void setBiblioestacionLargo(Double BiblioestacionLargo) {this.BiblioestacionLargo = BiblioestacionLargo;}
	public Double getBiblioestacionLargo() {return BiblioestacionLargo;}
	public void setBiblioestacionRutaImagen(String BiblioestacionRutaImagen) {this.BiblioestacionRutaImagen = BiblioestacionRutaImagen;}
	public String getBiblioestacionRutaImagen() {return BiblioestacionRutaImagen;}
	public void setBiblioestacionImagen(String BiblioestacionImagen) {this.BiblioestacionImagen = BiblioestacionImagen;}
	public String getBiblioestacionImagen() {return BiblioestacionImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}