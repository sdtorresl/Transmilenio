package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_cuarto")
public class Cuarto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_cuarto_id")
    private Double CuartoId;

    @Column(name = "inv_cuarto_uso")
    private String CuartoUso;

    @Column(name = "inv_cuarto_tipo")
    private String CuartoTipo;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCuartoId(Double CuartoId) {this.CuartoId = CuartoId;}
	public Double getCuartoId() {return CuartoId;}
	public void setCuartoUso(String CuartoUso) {this.CuartoUso = CuartoUso;}
	public String getCuartoUso() {return CuartoUso;}
	public void setCuartoTipo(String CuartoTipo) {this.CuartoTipo = CuartoTipo;}
	public String getCuartoTipo() {return CuartoTipo;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}