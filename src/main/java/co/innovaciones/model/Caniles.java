package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_caniles")
public class Caniles implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_caniles_imagen")
    private String CanilesImagen;

    @Column(name = "inv_caniles_ruta_imagen")
    private String CanilesRutaImagen;

    @Column(name = "inv_caniles_total")
    private Double CanilesTotal;

    @Column(name = "inv_caniles_numeroaveriados")
    private Double CanilesNumeroaveriados;

    @Column(name = "inv_caniles_numerosinservicio")
    private Boolean CanilesNumerosinservicio;

    @Column(name = "inv_caniles_cantidad")
    private Double CanilesCantidad;

    @Column(name = "inv_caniles_id")
    private Double CanilesId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setCanilesImagen(String CanilesImagen) {this.CanilesImagen = CanilesImagen;}
	public String getCanilesImagen() {return CanilesImagen;}
	public void setCanilesRutaImagen(String CanilesRutaImagen) {this.CanilesRutaImagen = CanilesRutaImagen;}
	public String getCanilesRutaImagen() {return CanilesRutaImagen;}
	public void setCanilesTotal(Double CanilesTotal) {this.CanilesTotal = CanilesTotal;}
	public Double getCanilesTotal() {return CanilesTotal;}
	public void setCanilesNumeroaveriados(Double CanilesNumeroaveriados) {this.CanilesNumeroaveriados = CanilesNumeroaveriados;}
	public Double getCanilesNumeroaveriados() {return CanilesNumeroaveriados;}
	public void setCanilesNumerosinservicio(Boolean CanilesNumerosinservicio) {this.CanilesNumerosinservicio = CanilesNumerosinservicio;}
	public Boolean getCanilesNumerosinservicio() {return CanilesNumerosinservicio;}
	public void setCanilesCantidad(Double CanilesCantidad) {this.CanilesCantidad = CanilesCantidad;}
	public Double getCanilesCantidad() {return CanilesCantidad;}
	public void setCanilesId(Double CanilesId) {this.CanilesId = CanilesId;}
	public Double getCanilesId() {return CanilesId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}