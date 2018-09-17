package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_ciclopar")
public class Ciclopar implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_ciclopar_techoindependiente")
    private Boolean CicloparTechoindependiente;

    @Column(name = "inv_ciclopar_ruta_imagen")
    private String CicloparRutaImagen;

    @Column(name = "inv_ciclopar_imagen")
    private String CicloparImagen;

    @Column(name = "inv_ciclopar_area")
    private Double CicloparArea;

    @Column(name = "inv_id_ciclopar")
    private Double IdCiclopar;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_ciclopar_id")
    private Double CicloparId;

    @Column(name = "inv_ciclopar_capacidad")
    private String CicloparCapacidad;

    @Column(name = "inv_ciclopar_areacubierta")
    private Double CicloparAreacubierta;

    @Column(name = "inv_ciclopar_tiporack")
    private String CicloparTiporack;

	public void setCicloparTechoindependiente(Boolean CicloparTechoindependiente) {this.CicloparTechoindependiente = CicloparTechoindependiente;}
	public Boolean getCicloparTechoindependiente() {return CicloparTechoindependiente;}
	public void setCicloparRutaImagen(String CicloparRutaImagen) {this.CicloparRutaImagen = CicloparRutaImagen;}
	public String getCicloparRutaImagen() {return CicloparRutaImagen;}
	public void setCicloparImagen(String CicloparImagen) {this.CicloparImagen = CicloparImagen;}
	public String getCicloparImagen() {return CicloparImagen;}
	public void setCicloparArea(Double CicloparArea) {this.CicloparArea = CicloparArea;}
	public Double getCicloparArea() {return CicloparArea;}
	public void setIdCiclopar(Double IdCiclopar) {this.IdCiclopar = IdCiclopar;}
	public Double getIdCiclopar() {return IdCiclopar;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCicloparId(Double CicloparId) {this.CicloparId = CicloparId;}
	public Double getCicloparId() {return CicloparId;}
	public void setCicloparCapacidad(String CicloparCapacidad) {this.CicloparCapacidad = CicloparCapacidad;}
	public String getCicloparCapacidad() {return CicloparCapacidad;}
	public void setCicloparAreacubierta(Double CicloparAreacubierta) {this.CicloparAreacubierta = CicloparAreacubierta;}
	public Double getCicloparAreacubierta() {return CicloparAreacubierta;}
	public void setCicloparTiporack(String CicloparTiporack) {this.CicloparTiporack = CicloparTiporack;}
	public String getCicloparTiporack() {return CicloparTiporack;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}