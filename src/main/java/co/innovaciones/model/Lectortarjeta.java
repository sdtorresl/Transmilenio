package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_lectortarjeta")
public class Lectortarjeta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_lectortarjeta_imagen")
    private String LectortarjetaImagen;

    @Column(name = "inv_lectortarjeta_ruta_imagen")
    private String LectortarjetaRutaImagen;

    @Column(name = "inv_lectortarjeta_fueraservicio")
    private Boolean LectortarjetaFueraservicio;

    @Column(name = "inv_lectortarjeta_costado")
    private String LectortarjetaCostado;

    @Column(name = "inv_lectortarjeta_id")
    private Double LectortarjetaId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_id_lectortarjeta")
    private Double IdLectortarjeta;

	public void setLectortarjetaImagen(String LectortarjetaImagen) {this.LectortarjetaImagen = LectortarjetaImagen;}
	public String getLectortarjetaImagen() {return LectortarjetaImagen;}
	public void setLectortarjetaRutaImagen(String LectortarjetaRutaImagen) {this.LectortarjetaRutaImagen = LectortarjetaRutaImagen;}
	public String getLectortarjetaRutaImagen() {return LectortarjetaRutaImagen;}
	public void setLectortarjetaFueraservicio(Boolean LectortarjetaFueraservicio) {this.LectortarjetaFueraservicio = LectortarjetaFueraservicio;}
	public Boolean getLectortarjetaFueraservicio() {return LectortarjetaFueraservicio;}
	public void setLectortarjetaCostado(String LectortarjetaCostado) {this.LectortarjetaCostado = LectortarjetaCostado;}
	public String getLectortarjetaCostado() {return LectortarjetaCostado;}
	public void setLectortarjetaId(Double LectortarjetaId) {this.LectortarjetaId = LectortarjetaId;}
	public Double getLectortarjetaId() {return LectortarjetaId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setIdLectortarjeta(Double IdLectortarjeta) {this.IdLectortarjeta = IdLectortarjeta;}
	public Double getIdLectortarjeta() {return IdLectortarjeta;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}