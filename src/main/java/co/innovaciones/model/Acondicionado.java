package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_acondicionado")
public class Acondicionado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_acondicionado")
    private Double IdAcondicionado;

    @Column(name = "inv_acondicionado_id")
    private Double AcondicionadoId;

    @Column(name = "inv_acondicionado_ubicacion")
    private String AcondicionadoUbicacion;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setIdAcondicionado(Double IdAcondicionado) {this.IdAcondicionado = IdAcondicionado;}
	public Double getIdAcondicionado() {return IdAcondicionado;}
	public void setAcondicionadoId(Double AcondicionadoId) {this.AcondicionadoId = AcondicionadoId;}
	public Double getAcondicionadoId() {return AcondicionadoId;}
	public void setAcondicionadoUbicacion(String AcondicionadoUbicacion) {this.AcondicionadoUbicacion = AcondicionadoUbicacion;}
	public String getAcondicionadoUbicacion() {return AcondicionadoUbicacion;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}