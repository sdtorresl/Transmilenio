package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_ruta")
public class Ruta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_ruta")
	private Integer id;

    @Column(name = "inv_ruta_id")
    private Double RutaId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_ruta_costado")
    private String RutaCostado;

    @Column(name = "inv_ruta_descripcion")
    private String RutaDescripcion;

    @Column(name = "inv_ruta_averia")
    private Boolean RutaAveria;

	public void setRutaId(Double RutaId) {this.RutaId = RutaId;}
	public Double getRutaId() {return RutaId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setRutaCostado(String RutaCostado) {this.RutaCostado = RutaCostado;}
	public String getRutaCostado() {return RutaCostado;}
	public void setRutaDescripcion(String RutaDescripcion) {this.RutaDescripcion = RutaDescripcion;}
	public String getRutaDescripcion() {return RutaDescripcion;}
	public void setRutaAveria(Boolean RutaAveria) {this.RutaAveria = RutaAveria;}
	public Boolean getRutaAveria() {return RutaAveria;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}