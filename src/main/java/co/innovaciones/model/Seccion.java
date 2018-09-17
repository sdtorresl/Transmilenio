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
	
    @Column(name = "inv_id_plataforma")
    private Integer IdPlataforma;
	
    @Column(name = "inv_id_conexion")
    private Integer IdConexion;
	
    @Column(name = "inv_id_transicion")
    private Integer IdTransicion;
	
    @Column(name = "inv_id_conexa")
    private Integer IdConexa;
	
    @Column(name = "inv_id_vagon")
    private Integer IdVagon;
	
    @Column(name = "inv_id_edificio")
    private Integer IdEdificio;
	
    @Column(name = "inv_id_entrada")
    private Integer IdEntrada;
	
    @Column(name = "inv_seccion_externa")
    private Boolean SeccionExterna;
	
    @Column(name = "inv_seccion_nombre")
    private String SeccionNombre;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inv_id_seccion")
    private Integer IdSeccion;
	
	public void setIdPlataforma(Integer IdPlataforma) {this.IdPlataforma = IdPlataforma;}
	public Integer getIdPlataforma() {return IdPlataforma;}
	public void setIdConexion(Integer IdConexion) {this.IdConexion = IdConexion;}
	public Integer getIdConexion() {return IdConexion;}
	public void setIdTransicion(Integer IdTransicion) {this.IdTransicion = IdTransicion;}
	public Integer getIdTransicion() {return IdTransicion;}
	public void setIdConexa(Integer IdConexa) {this.IdConexa = IdConexa;}
	public Integer getIdConexa() {return IdConexa;}
	public void setIdVagon(Integer IdVagon) {this.IdVagon = IdVagon;}
	public Integer getIdVagon() {return IdVagon;}
	public void setIdEdificio(Integer IdEdificio) {this.IdEdificio = IdEdificio;}
	public Integer getIdEdificio() {return IdEdificio;}
	public void setIdEntrada(Integer IdEntrada) {this.IdEntrada = IdEntrada;}
	public Integer getIdEntrada() {return IdEntrada;}
	public void setSeccionExterna(Boolean SeccionExterna) {this.SeccionExterna = SeccionExterna;}
	public Boolean getSeccionExterna() {return SeccionExterna;}
	public void setSeccionNombre(String SeccionNombre) {this.SeccionNombre = SeccionNombre;}
	public String getSeccionNombre() {return SeccionNombre;}
	public void setIdSeccion(Integer IdSeccion) {this.IdSeccion = IdSeccion;}
	public Integer getIdSeccion() {return IdSeccion;}	
}