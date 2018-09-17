package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_celosia")
public class Celosia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_celosia_id")
    private Double CelosiaId;

    @Column(name = "inv_id_celosia")
    private Double IdCelosia;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_celosia_costado")
    private String CelosiaCostado;

    @Column(name = "inv_celosia_tipo")
    private String CelosiaTipo;

    @Column(name = "inv_celosia_alto")
    private Double CelosiaAlto;

    @Column(name = "inv_celosia_averia")
    private Boolean CelosiaAveria;

    @Column(name = "inv_celosia_porcentajeaveria")
    private Double CelosiaPorcentajeaveria;

    @Column(name = "inv_celosia_corrosion")
    private Boolean CelosiaCorrosion;

    @Column(name = "inv_celosia_desgastepintura")
    private Boolean CelosiaDesgastepintura;

    @Column(name = "inv_celosia_tubofaltante")
    private Boolean CelosiaTubofaltante;

    @Column(name = "inv_celosia_piezasfaltante")
    private Boolean CelosiaPiezasfaltante;

    @Column(name = "inv_celosia_contaminacionvisual")
    private Boolean CelosiaContaminacionvisual;

    @Column(name = "inv_celosia_observacion")
    private String CelosiaObservacion;

    @Column(name = "inv_celosia_largo")
    private Double CelosiaLargo;

	public void setCelosiaId(Double CelosiaId) {this.CelosiaId = CelosiaId;}
	public Double getCelosiaId() {return CelosiaId;}
	public void setIdCelosia(Double IdCelosia) {this.IdCelosia = IdCelosia;}
	public Double getIdCelosia() {return IdCelosia;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCelosiaCostado(String CelosiaCostado) {this.CelosiaCostado = CelosiaCostado;}
	public String getCelosiaCostado() {return CelosiaCostado;}
	public void setCelosiaTipo(String CelosiaTipo) {this.CelosiaTipo = CelosiaTipo;}
	public String getCelosiaTipo() {return CelosiaTipo;}
	public void setCelosiaAlto(Double CelosiaAlto) {this.CelosiaAlto = CelosiaAlto;}
	public Double getCelosiaAlto() {return CelosiaAlto;}
	public void setCelosiaAveria(Boolean CelosiaAveria) {this.CelosiaAveria = CelosiaAveria;}
	public Boolean getCelosiaAveria() {return CelosiaAveria;}
	public void setCelosiaPorcentajeaveria(Double CelosiaPorcentajeaveria) {this.CelosiaPorcentajeaveria = CelosiaPorcentajeaveria;}
	public Double getCelosiaPorcentajeaveria() {return CelosiaPorcentajeaveria;}
	public void setCelosiaCorrosion(Boolean CelosiaCorrosion) {this.CelosiaCorrosion = CelosiaCorrosion;}
	public Boolean getCelosiaCorrosion() {return CelosiaCorrosion;}
	public void setCelosiaDesgastepintura(Boolean CelosiaDesgastepintura) {this.CelosiaDesgastepintura = CelosiaDesgastepintura;}
	public Boolean getCelosiaDesgastepintura() {return CelosiaDesgastepintura;}
	public void setCelosiaTubofaltante(Boolean CelosiaTubofaltante) {this.CelosiaTubofaltante = CelosiaTubofaltante;}
	public Boolean getCelosiaTubofaltante() {return CelosiaTubofaltante;}
	public void setCelosiaPiezasfaltante(Boolean CelosiaPiezasfaltante) {this.CelosiaPiezasfaltante = CelosiaPiezasfaltante;}
	public Boolean getCelosiaPiezasfaltante() {return CelosiaPiezasfaltante;}
	public void setCelosiaContaminacionvisual(Boolean CelosiaContaminacionvisual) {this.CelosiaContaminacionvisual = CelosiaContaminacionvisual;}
	public Boolean getCelosiaContaminacionvisual() {return CelosiaContaminacionvisual;}
	public void setCelosiaObservacion(String CelosiaObservacion) {this.CelosiaObservacion = CelosiaObservacion;}
	public String getCelosiaObservacion() {return CelosiaObservacion;}
	public void setCelosiaLargo(Double CelosiaLargo) {this.CelosiaLargo = CelosiaLargo;}
	public Double getCelosiaLargo() {return CelosiaLargo;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}