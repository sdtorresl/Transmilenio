package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_cajeroelec")
public class Cajeroelec implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_cajeroelec_id")
    private Double CajeroelecId;

    @Column(name = "inv_id_cajeroelec")
    private Double IdCajeroelec;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_cajeroelec_entidad")
    private String CajeroelecEntidad;

    @Column(name = "inv_cajeroelec_sinservicio")
    private Boolean CajeroelecSinservicio;

    @Column(name = "inv_cajeroelec_contaminacion")
    private Boolean CajeroelecContaminacion;

    @Column(name = "inv_cajeroelec_ruta_imagen")
    private String CajeroelecRutaImagen;

    @Column(name = "inv_cajeroelec_imagen")
    private String CajeroelecImagen;

	public void setCajeroelecId(Double CajeroelecId) {this.CajeroelecId = CajeroelecId;}
	public Double getCajeroelecId() {return CajeroelecId;}
	public void setIdCajeroelec(Double IdCajeroelec) {this.IdCajeroelec = IdCajeroelec;}
	public Double getIdCajeroelec() {return IdCajeroelec;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCajeroelecEntidad(String CajeroelecEntidad) {this.CajeroelecEntidad = CajeroelecEntidad;}
	public String getCajeroelecEntidad() {return CajeroelecEntidad;}
	public void setCajeroelecSinservicio(Boolean CajeroelecSinservicio) {this.CajeroelecSinservicio = CajeroelecSinservicio;}
	public Boolean getCajeroelecSinservicio() {return CajeroelecSinservicio;}
	public void setCajeroelecContaminacion(Boolean CajeroelecContaminacion) {this.CajeroelecContaminacion = CajeroelecContaminacion;}
	public Boolean getCajeroelecContaminacion() {return CajeroelecContaminacion;}
	public void setCajeroelecRutaImagen(String CajeroelecRutaImagen) {this.CajeroelecRutaImagen = CajeroelecRutaImagen;}
	public String getCajeroelecRutaImagen() {return CajeroelecRutaImagen;}
	public void setCajeroelecImagen(String CajeroelecImagen) {this.CajeroelecImagen = CajeroelecImagen;}
	public String getCajeroelecImagen() {return CajeroelecImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}