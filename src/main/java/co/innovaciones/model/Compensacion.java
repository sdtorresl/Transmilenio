package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_compensacion")
public class Compensacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_compensacion")
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_compensacion_potenciareactiva")
    private String CompensacionPotenciareactiva;

    @Column(name = "inv_compensacion_tension")
    private Double CompensacionTension;

    @Column(name = "inv_compensacion_capacidad")
    private Double CompensacionCapacidad;

    @Column(name = "inv_compensacion_ubicacion")
    private String CompensacionUbicacion;

    @Column(name = "inv_compensacion_averia")
    private Boolean CompensacionAveria;

    @Column(name = "inv_compensacion_gabinetecorrosion")
    private Boolean CompensacionGabinetecorrosion;

    @Column(name = "inv_compensacion_gabinetecorrosionarea")
    private Double CompensacionGabinetecorrosionarea;

    @Column(name = "inv_compensacion_cablesderretidos")
    private Boolean CompensacionCablesderretidos;

    @Column(name = "inv_compensacion_ruta_imagen")
    private String CompensacionRutaImagen;

    @Column(name = "inv_compensacion_imagen")
    private String CompensacionImagen;

    @Column(name = "inv_compensacion_id")
    private Double CompensacionId;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCompensacionPotenciareactiva(String CompensacionPotenciareactiva) {this.CompensacionPotenciareactiva = CompensacionPotenciareactiva;}
	public String getCompensacionPotenciareactiva() {return CompensacionPotenciareactiva;}
	public void setCompensacionTension(Double CompensacionTension) {this.CompensacionTension = CompensacionTension;}
	public Double getCompensacionTension() {return CompensacionTension;}
	public void setCompensacionCapacidad(Double CompensacionCapacidad) {this.CompensacionCapacidad = CompensacionCapacidad;}
	public Double getCompensacionCapacidad() {return CompensacionCapacidad;}
	public void setCompensacionUbicacion(String CompensacionUbicacion) {this.CompensacionUbicacion = CompensacionUbicacion;}
	public String getCompensacionUbicacion() {return CompensacionUbicacion;}
	public void setCompensacionAveria(Boolean CompensacionAveria) {this.CompensacionAveria = CompensacionAveria;}
	public Boolean getCompensacionAveria() {return CompensacionAveria;}
	public void setCompensacionGabinetecorrosion(Boolean CompensacionGabinetecorrosion) {this.CompensacionGabinetecorrosion = CompensacionGabinetecorrosion;}
	public Boolean getCompensacionGabinetecorrosion() {return CompensacionGabinetecorrosion;}
	public void setCompensacionGabinetecorrosionarea(Double CompensacionGabinetecorrosionarea) {this.CompensacionGabinetecorrosionarea = CompensacionGabinetecorrosionarea;}
	public Double getCompensacionGabinetecorrosionarea() {return CompensacionGabinetecorrosionarea;}
	public void setCompensacionCablesderretidos(Boolean CompensacionCablesderretidos) {this.CompensacionCablesderretidos = CompensacionCablesderretidos;}
	public Boolean getCompensacionCablesderretidos() {return CompensacionCablesderretidos;}
	public void setCompensacionRutaImagen(String CompensacionRutaImagen) {this.CompensacionRutaImagen = CompensacionRutaImagen;}
	public String getCompensacionRutaImagen() {return CompensacionRutaImagen;}
	public void setCompensacionImagen(String CompensacionImagen) {this.CompensacionImagen = CompensacionImagen;}
	public String getCompensacionImagen() {return CompensacionImagen;}
	public void setCompensacionId(Double CompensacionId) {this.CompensacionId = CompensacionId;}
	public Double getCompensacionId() {return CompensacionId;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}