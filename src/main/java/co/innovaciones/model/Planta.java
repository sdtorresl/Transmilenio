package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_planta")
public class Planta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_planta_potencia")
    private Double PlantaPotencia;

    @Column(name = "inv_planta_imagen")
    private String PlantaImagen;

    @Column(name = "inv_planta_ruta_imagen")
    private String PlantaRutaImagen;

    @Column(name = "inv_planta_ubicacion")
    private String PlantaUbicacion;

    @Column(name = "inv_planta_tension")
    private Double PlantaTension;

    @Column(name = "inv_planta_id")
    private Double PlantaId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setPlantaPotencia(Double PlantaPotencia) {this.PlantaPotencia = PlantaPotencia;}
	public Double getPlantaPotencia() {return PlantaPotencia;}
	public void setPlantaImagen(String PlantaImagen) {this.PlantaImagen = PlantaImagen;}
	public String getPlantaImagen() {return PlantaImagen;}
	public void setPlantaRutaImagen(String PlantaRutaImagen) {this.PlantaRutaImagen = PlantaRutaImagen;}
	public String getPlantaRutaImagen() {return PlantaRutaImagen;}
	public void setPlantaUbicacion(String PlantaUbicacion) {this.PlantaUbicacion = PlantaUbicacion;}
	public String getPlantaUbicacion() {return PlantaUbicacion;}
	public void setPlantaTension(Double PlantaTension) {this.PlantaTension = PlantaTension;}
	public Double getPlantaTension() {return PlantaTension;}
	public void setPlantaId(Double PlantaId) {this.PlantaId = PlantaId;}
	public Double getPlantaId() {return PlantaId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}