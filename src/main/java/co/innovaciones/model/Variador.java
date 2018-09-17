package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_variador")
public class Variador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_variador_id")
    private Double VariadorId;

    @Column(name = "inv_variador_marca")
    private String VariadorMarca;

    @Column(name = "inv_variador_ubicacion")
    private String VariadorUbicacion;

    @Column(name = "inv_id_variador")
    private Double IdVariador;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setVariadorId(Double VariadorId) {this.VariadorId = VariadorId;}
	public Double getVariadorId() {return VariadorId;}
	public void setVariadorMarca(String VariadorMarca) {this.VariadorMarca = VariadorMarca;}
	public String getVariadorMarca() {return VariadorMarca;}
	public void setVariadorUbicacion(String VariadorUbicacion) {this.VariadorUbicacion = VariadorUbicacion;}
	public String getVariadorUbicacion() {return VariadorUbicacion;}
	public void setIdVariador(Double IdVariador) {this.IdVariador = IdVariador;}
	public Double getIdVariador() {return IdVariador;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}