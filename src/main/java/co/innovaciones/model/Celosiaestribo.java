package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_celosiaestribo")
public class Celosiaestribo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_celosiaestribo_costado")
    private String CelosiaestriboCostado;

    @Column(name = "inv_celosiaestribo_largo")
    private Double CelosiaestriboLargo;

    @Column(name = "inv_celosiaestribo_alto")
    private Double CelosiaestriboAlto;

    @Column(name = "inv_celosiaestribo_averia")
    private Boolean CelosiaestriboAveria;

    @Column(name = "inv_celosiaestribo_porcentajeaveria")
    private Double CelosiaestriboPorcentajeaveria;

    @Column(name = "inv_celosiaestribo_corrosion")
    private Boolean CelosiaestriboCorrosion;

    @Column(name = "inv_celosiaestribo_doblado")
    private Boolean CelosiaestriboDoblado;

    @Column(name = "inv_celosiaestribo_robado")
    private Boolean CelosiaestriboRobado;

    @Column(name = "inv_velosiaestribo_observacion")
    private String VelosiaestriboObservacion;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_celosiaestribo_id")
    private Double CelosiaestriboId;

	public void setCelosiaestriboCostado(String CelosiaestriboCostado) {this.CelosiaestriboCostado = CelosiaestriboCostado;}
	public String getCelosiaestriboCostado() {return CelosiaestriboCostado;}
	public void setCelosiaestriboLargo(Double CelosiaestriboLargo) {this.CelosiaestriboLargo = CelosiaestriboLargo;}
	public Double getCelosiaestriboLargo() {return CelosiaestriboLargo;}
	public void setCelosiaestriboAlto(Double CelosiaestriboAlto) {this.CelosiaestriboAlto = CelosiaestriboAlto;}
	public Double getCelosiaestriboAlto() {return CelosiaestriboAlto;}
	public void setCelosiaestriboAveria(Boolean CelosiaestriboAveria) {this.CelosiaestriboAveria = CelosiaestriboAveria;}
	public Boolean getCelosiaestriboAveria() {return CelosiaestriboAveria;}
	public void setCelosiaestriboPorcentajeaveria(Double CelosiaestriboPorcentajeaveria) {this.CelosiaestriboPorcentajeaveria = CelosiaestriboPorcentajeaveria;}
	public Double getCelosiaestriboPorcentajeaveria() {return CelosiaestriboPorcentajeaveria;}
	public void setCelosiaestriboCorrosion(Boolean CelosiaestriboCorrosion) {this.CelosiaestriboCorrosion = CelosiaestriboCorrosion;}
	public Boolean getCelosiaestriboCorrosion() {return CelosiaestriboCorrosion;}
	public void setCelosiaestriboDoblado(Boolean CelosiaestriboDoblado) {this.CelosiaestriboDoblado = CelosiaestriboDoblado;}
	public Boolean getCelosiaestriboDoblado() {return CelosiaestriboDoblado;}
	public void setCelosiaestriboRobado(Boolean CelosiaestriboRobado) {this.CelosiaestriboRobado = CelosiaestriboRobado;}
	public Boolean getCelosiaestriboRobado() {return CelosiaestriboRobado;}
	public void setVelosiaestriboObservacion(String VelosiaestriboObservacion) {this.VelosiaestriboObservacion = VelosiaestriboObservacion;}
	public String getVelosiaestriboObservacion() {return VelosiaestriboObservacion;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCelosiaestriboId(Double CelosiaestriboId) {this.CelosiaestriboId = CelosiaestriboId;}
	public Double getCelosiaestriboId() {return CelosiaestriboId;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}