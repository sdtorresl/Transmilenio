package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_acceso")
public class Acceso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_acceso")
    private Double IdAcceso;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_acceso_formaingreso")
    private String AccesoFormaingreso;

    @Column(name = "inv_acceso_total")
    private Double AccesoTotal;

    @Column(name = "inv_acceso_torniquete")
    private Double AccesoTorniquete;

    @Column(name = "inv_acceso_distribucion")
    private String AccesoDistribucion;

    @Column(name = "inv_acceso_id")
    private Double AccesoId;

	public void setIdAcceso(Double IdAcceso) {this.IdAcceso = IdAcceso;}
	public Double getIdAcceso() {return IdAcceso;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setAccesoFormaingreso(String AccesoFormaingreso) {this.AccesoFormaingreso = AccesoFormaingreso;}
	public String getAccesoFormaingreso() {return AccesoFormaingreso;}
	public void setAccesoTotal(Double AccesoTotal) {this.AccesoTotal = AccesoTotal;}
	public Double getAccesoTotal() {return AccesoTotal;}
	public void setAccesoTorniquete(Double AccesoTorniquete) {this.AccesoTorniquete = AccesoTorniquete;}
	public Double getAccesoTorniquete() {return AccesoTorniquete;}
	public void setAccesoDistribucion(String AccesoDistribucion) {this.AccesoDistribucion = AccesoDistribucion;}
	public String getAccesoDistribucion() {return AccesoDistribucion;}
	public void setAccesoId(Double AccesoId) {this.AccesoId = AccesoId;}
	public Double getAccesoId() {return AccesoId;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}