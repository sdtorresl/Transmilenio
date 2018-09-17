package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_garita")
public class Garita implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_garita")
	private Integer id;

    @Column(name = "inv_garita_ancho")
    private Double GaritaAncho;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_garita_observaciones")
    private String GaritaObservaciones;

    @Column(name = "inv_garita_id")
    private Integer GaritaId;

    @Column(name = "inv_garita_area")
    private Double GaritaArea;

    @Column(name = "inv_garita_tipo")
    private String GaritaTipo;

    @Column(name = "inv_garita_largo")
    private Double GaritaLargo;

	public void setGaritaAncho(Double GaritaAncho) {this.GaritaAncho = GaritaAncho;}
	public Double getGaritaAncho() {return GaritaAncho;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setGaritaObservaciones(String GaritaObservaciones) {this.GaritaObservaciones = GaritaObservaciones;}
	public String getGaritaObservaciones() {return GaritaObservaciones;}
	public void setGaritaId(Integer GaritaId) {this.GaritaId = GaritaId;}
	public Integer getGaritaId() {return GaritaId;}
	public void setGaritaArea(Double GaritaArea) {this.GaritaArea = GaritaArea;}
	public Double getGaritaArea() {return GaritaArea;}
	public void setGaritaTipo(String GaritaTipo) {this.GaritaTipo = GaritaTipo;}
	public String getGaritaTipo() {return GaritaTipo;}
	public void setGaritaLargo(Double GaritaLargo) {this.GaritaLargo = GaritaLargo;}
	public Double getGaritaLargo() {return GaritaLargo;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}