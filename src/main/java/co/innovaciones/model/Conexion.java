package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_conexion")
public class Conexion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_conexion_elevacion")
    private String ConexionElevacion;

    @Column(name = "inv_conexion_id")
    private Double ConexionId;

    @Column(name = "inv_conexion_numero")
    private Double ConexionNumero;

    @Column(name = "inv_conexion_tipo")
    private String ConexionTipo;

    @Column(name = "inv_conexion_largo")
    private Double ConexionLargo;

    @Column(name = "inv_conexion_ancho")
    private Double ConexionAncho;

	public void setConexionElevacion(String ConexionElevacion) {this.ConexionElevacion = ConexionElevacion;}
	public String getConexionElevacion() {return ConexionElevacion;}
	public void setConexionId(Double ConexionId) {this.ConexionId = ConexionId;}
	public Double getConexionId() {return ConexionId;}
	public void setConexionNumero(Double ConexionNumero) {this.ConexionNumero = ConexionNumero;}
	public Double getConexionNumero() {return ConexionNumero;}
	public void setConexionTipo(String ConexionTipo) {this.ConexionTipo = ConexionTipo;}
	public String getConexionTipo() {return ConexionTipo;}
	public void setConexionLargo(Double ConexionLargo) {this.ConexionLargo = ConexionLargo;}
	public Double getConexionLargo() {return ConexionLargo;}
	public void setConexionAncho(Double ConexionAncho) {this.ConexionAncho = ConexionAncho;}
	public Double getConexionAncho() {return ConexionAncho;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}