package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_bombaagua")
public class Bombaagua implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_bombaagua_id")
    private Double BombaaguaId;

    @Column(name = "inv_bombaagua_ubicacion")
    private String BombaaguaUbicacion;

    @Column(name = "inv_bombaagua_ruta_imagen")
    private String BombaaguaRutaImagen;

    @Column(name = "inv_bombaagua_imagen")
    private String BombaaguaImagen;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setBombaaguaId(Double BombaaguaId) {this.BombaaguaId = BombaaguaId;}
	public Double getBombaaguaId() {return BombaaguaId;}
	public void setBombaaguaUbicacion(String BombaaguaUbicacion) {this.BombaaguaUbicacion = BombaaguaUbicacion;}
	public String getBombaaguaUbicacion() {return BombaaguaUbicacion;}
	public void setBombaaguaRutaImagen(String BombaaguaRutaImagen) {this.BombaaguaRutaImagen = BombaaguaRutaImagen;}
	public String getBombaaguaRutaImagen() {return BombaaguaRutaImagen;}
	public void setBombaaguaImagen(String BombaaguaImagen) {this.BombaaguaImagen = BombaaguaImagen;}
	public String getBombaaguaImagen() {return BombaaguaImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}