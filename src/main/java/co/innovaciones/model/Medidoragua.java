package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_medidoragua")
public class Medidoragua implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_medidoragua_id")
    private Double MedidoraguaId;

    @Column(name = "inv_medidoragua_fuga")
    private Boolean MedidoraguaFuga;

    @Column(name = "inv_medidoragua_ubicacion")
    private String MedidoraguaUbicacion;

    @Column(name = "inv_id_medidoragua")
    private Double IdMedidoragua;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setMedidoraguaId(Double MedidoraguaId) {this.MedidoraguaId = MedidoraguaId;}
	public Double getMedidoraguaId() {return MedidoraguaId;}
	public void setMedidoraguaFuga(Boolean MedidoraguaFuga) {this.MedidoraguaFuga = MedidoraguaFuga;}
	public Boolean getMedidoraguaFuga() {return MedidoraguaFuga;}
	public void setMedidoraguaUbicacion(String MedidoraguaUbicacion) {this.MedidoraguaUbicacion = MedidoraguaUbicacion;}
	public String getMedidoraguaUbicacion() {return MedidoraguaUbicacion;}
	public void setIdMedidoragua(Double IdMedidoragua) {this.IdMedidoragua = IdMedidoragua;}
	public Double getIdMedidoragua() {return IdMedidoragua;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}