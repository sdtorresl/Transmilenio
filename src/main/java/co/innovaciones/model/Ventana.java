package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_ventana")
public class Ventana implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_ventana")
    private Double IdVentana;

    @Column(name = "inv_ventana_desaparicion")
    private Boolean VentanaDesaparicion;

    @Column(name = "inv_ventana_rayones")
    private Boolean VentanaRayones;

    @Column(name = "inv_ventana_contaminacion")
    private Boolean VentanaContaminacion;

    @Column(name = "inv_ventana_cierre")
    private Boolean VentanaCierre;

    @Column(name = "inv_ventana_rejarota")
    private Boolean VentanaRejarota;

    @Column(name = "inv_ventana_fisura")
    private Boolean VentanaFisura;

    @Column(name = "inv_ventana_ancho")
    private Double VentanaAncho;

    @Column(name = "inv_ventana_alto")
    private Double VentanaAlto;

    @Column(name = "inv_ventana_costado")
    private String VentanaCostado;

    @Column(name = "inv_ventana_id")
    private Double VentanaId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setIdVentana(Double IdVentana) {this.IdVentana = IdVentana;}
	public Double getIdVentana() {return IdVentana;}
	public void setVentanaDesaparicion(Boolean VentanaDesaparicion) {this.VentanaDesaparicion = VentanaDesaparicion;}
	public Boolean getVentanaDesaparicion() {return VentanaDesaparicion;}
	public void setVentanaRayones(Boolean VentanaRayones) {this.VentanaRayones = VentanaRayones;}
	public Boolean getVentanaRayones() {return VentanaRayones;}
	public void setVentanaContaminacion(Boolean VentanaContaminacion) {this.VentanaContaminacion = VentanaContaminacion;}
	public Boolean getVentanaContaminacion() {return VentanaContaminacion;}
	public void setVentanaCierre(Boolean VentanaCierre) {this.VentanaCierre = VentanaCierre;}
	public Boolean getVentanaCierre() {return VentanaCierre;}
	public void setVentanaRejarota(Boolean VentanaRejarota) {this.VentanaRejarota = VentanaRejarota;}
	public Boolean getVentanaRejarota() {return VentanaRejarota;}
	public void setVentanaFisura(Boolean VentanaFisura) {this.VentanaFisura = VentanaFisura;}
	public Boolean getVentanaFisura() {return VentanaFisura;}
	public void setVentanaAncho(Double VentanaAncho) {this.VentanaAncho = VentanaAncho;}
	public Double getVentanaAncho() {return VentanaAncho;}
	public void setVentanaAlto(Double VentanaAlto) {this.VentanaAlto = VentanaAlto;}
	public Double getVentanaAlto() {return VentanaAlto;}
	public void setVentanaCostado(String VentanaCostado) {this.VentanaCostado = VentanaCostado;}
	public String getVentanaCostado() {return VentanaCostado;}
	public void setVentanaId(Double VentanaId) {this.VentanaId = VentanaId;}
	public Double getVentanaId() {return VentanaId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}