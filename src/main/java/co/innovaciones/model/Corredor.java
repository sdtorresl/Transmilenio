package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_corredor")
public class Corredor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_corredor")
    private Double IdCorredor;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_corredor_id")
    private Double CorredorId;

    @Column(name = "inv_corredor_tipo")
    private String CorredorTipo;

    @Column(name = "inv_corredor_area")
    private Double CorredorArea;

	public void setIdCorredor(Double IdCorredor) {this.IdCorredor = IdCorredor;}
	public Double getIdCorredor() {return IdCorredor;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCorredorId(Double CorredorId) {this.CorredorId = CorredorId;}
	public Double getCorredorId() {return CorredorId;}
	public void setCorredorTipo(String CorredorTipo) {this.CorredorTipo = CorredorTipo;}
	public String getCorredorTipo() {return CorredorTipo;}
	public void setCorredorArea(Double CorredorArea) {this.CorredorArea = CorredorArea;}
	public Double getCorredorArea() {return CorredorArea;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}