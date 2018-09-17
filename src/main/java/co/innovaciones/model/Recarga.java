package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_recarga")
public class Recarga implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_recarga")
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_recarga_id")
    private Double RecargaId;

    @Column(name = "inv_recarga_costado")
    private String RecargaCostado;

    @Column(name = "inv_recarga_enservicio")
    private Boolean RecargaEnservicio;

    @Column(name = "inv_recarga_contaminacion")
    private Boolean RecargaContaminacion;

    @Column(name = "inv_recarga_ruta_imagen")
    private String RecargaRutaImagen;

    @Column(name = "inv_recarga_imagen")
    private String RecargaImagen;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setRecargaId(Double RecargaId) {this.RecargaId = RecargaId;}
	public Double getRecargaId() {return RecargaId;}
	public void setRecargaCostado(String RecargaCostado) {this.RecargaCostado = RecargaCostado;}
	public String getRecargaCostado() {return RecargaCostado;}
	public void setRecargaEnservicio(Boolean RecargaEnservicio) {this.RecargaEnservicio = RecargaEnservicio;}
	public Boolean getRecargaEnservicio() {return RecargaEnservicio;}
	public void setRecargaContaminacion(Boolean RecargaContaminacion) {this.RecargaContaminacion = RecargaContaminacion;}
	public Boolean getRecargaContaminacion() {return RecargaContaminacion;}
	public void setRecargaRutaImagen(String RecargaRutaImagen) {this.RecargaRutaImagen = RecargaRutaImagen;}
	public String getRecargaRutaImagen() {return RecargaRutaImagen;}
	public void setRecargaImagen(String RecargaImagen) {this.RecargaImagen = RecargaImagen;}
	public String getRecargaImagen() {return RecargaImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}