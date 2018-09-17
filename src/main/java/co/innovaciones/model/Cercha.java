package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_cercha")
public class Cercha implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_cercha_piezadeformada")
    private Boolean CerchaPiezadeformada;

    @Column(name = "inv_cercha_corrosion")
    private Boolean CerchaCorrosion;

    @Column(name = "inv_cercha_piezafalta")
    private Boolean CerchaPiezafalta;

    @Column(name = "inv_cercha_porcentajeaveria")
    private Double CerchaPorcentajeaveria;

    @Column(name = "inv_cercha_averia")
    private Boolean CerchaAveria;

    @Column(name = "inv_cercha_id")
    private Double CerchaId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_cercha_pinturaepoxica")
    private Boolean CerchaPinturaepoxica;

	public void setCerchaPiezadeformada(Boolean CerchaPiezadeformada) {this.CerchaPiezadeformada = CerchaPiezadeformada;}
	public Boolean getCerchaPiezadeformada() {return CerchaPiezadeformada;}
	public void setCerchaCorrosion(Boolean CerchaCorrosion) {this.CerchaCorrosion = CerchaCorrosion;}
	public Boolean getCerchaCorrosion() {return CerchaCorrosion;}
	public void setCerchaPiezafalta(Boolean CerchaPiezafalta) {this.CerchaPiezafalta = CerchaPiezafalta;}
	public Boolean getCerchaPiezafalta() {return CerchaPiezafalta;}
	public void setCerchaPorcentajeaveria(Double CerchaPorcentajeaveria) {this.CerchaPorcentajeaveria = CerchaPorcentajeaveria;}
	public Double getCerchaPorcentajeaveria() {return CerchaPorcentajeaveria;}
	public void setCerchaAveria(Boolean CerchaAveria) {this.CerchaAveria = CerchaAveria;}
	public Boolean getCerchaAveria() {return CerchaAveria;}
	public void setCerchaId(Double CerchaId) {this.CerchaId = CerchaId;}
	public Double getCerchaId() {return CerchaId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCerchaPinturaepoxica(Boolean CerchaPinturaepoxica) {this.CerchaPinturaepoxica = CerchaPinturaepoxica;}
	public Boolean getCerchaPinturaepoxica() {return CerchaPinturaepoxica;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}