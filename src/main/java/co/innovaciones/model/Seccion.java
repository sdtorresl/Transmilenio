package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_seccion")
public class Seccion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_plataforma")
    private Double IdPlataforma;

    @Column(name = "inv_id_conexion")
    private Double IdConexion;

    @Column(name = "inv_id_transicion")
    private Double IdTransicion;

    @Column(name = "inv_id_conexa")
    private Double IdConexa;

    @Column(name = "inv_id_vagon")
    private Double IdVagon;

    @Column(name = "inv_id_edificio")
    private Double IdEdificio;

    @Column(name = "inv_id_entrada")
    private Double IdEntrada;

    @Column(name = "inv_seccion_externa")
    private Boolean SeccionExterna;

    @Column(name = "inv_seccion_nombre")
    private String SeccionNombre;

    @Column(name = "inv_id_seccion")
    private Double IdSeccion;

	public void setIdPlataforma(Double IdPlataforma) {this.IdPlataforma = IdPlataforma;}
	public Double getIdPlataforma() {return IdPlataforma;}
	public void setIdConexion(Double IdConexion) {this.IdConexion = IdConexion;}
	public Double getIdConexion() {return IdConexion;}
	public void setIdTransicion(Double IdTransicion) {this.IdTransicion = IdTransicion;}
	public Double getIdTransicion() {return IdTransicion;}
	public void setIdConexa(Double IdConexa) {this.IdConexa = IdConexa;}
	public Double getIdConexa() {return IdConexa;}
	public void setIdVagon(Double IdVagon) {this.IdVagon = IdVagon;}
	public Double getIdVagon() {return IdVagon;}
	public void setIdEdificio(Double IdEdificio) {this.IdEdificio = IdEdificio;}
	public Double getIdEdificio() {return IdEdificio;}
	public void setIdEntrada(Double IdEntrada) {this.IdEntrada = IdEntrada;}
	public Double getIdEntrada() {return IdEntrada;}
	public void setSeccionExterna(Boolean SeccionExterna) {this.SeccionExterna = SeccionExterna;}
	public Boolean getSeccionExterna() {return SeccionExterna;}
	public void setSeccionNombre(String SeccionNombre) {this.SeccionNombre = SeccionNombre;}
	public String getSeccionNombre() {return SeccionNombre;}
	public void setIdSeccion(Double IdSeccion) {this.IdSeccion = IdSeccion;}
	public Double getIdSeccion() {return IdSeccion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}