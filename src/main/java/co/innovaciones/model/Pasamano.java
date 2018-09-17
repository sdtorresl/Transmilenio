package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_pasamano")
public class Pasamano implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_pasamano_corrosion")
    private Boolean PasamanoCorrosion;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_pasamano_id")
    private Double PasamanoId;

    @Column(name = "inv_pasamano_costado")
    private String PasamanoCostado;

    @Column(name = "inv_pasamano_largo")
    private Double PasamanoLargo;

    @Column(name = "inv_pasamano_alto")
    private Double PasamanoAlto;

    @Column(name = "inv_pasamano_longitudmodulo")
    private Double PasamanoLongitudmodulo;

    @Column(name = "inv_pasamano_numeromodulos")
    private Double PasamanoNumeromodulos;

    @Column(name = "inv_pasamano_averia")
    private Boolean PasamanoAveria;

    @Column(name = "inv_pasamano_porcentajeaveria")
    private Double PasamanoPorcentajeaveria;

    @Column(name = "inv_pasamano_soldaduraaveria")
    private Boolean PasamanoSoldaduraaveria;

    @Column(name = "inv_pasamano_piezafaltante")
    private Boolean PasamanoPiezafaltante;

    @Column(name = "inv_pasamano_abolladuras")
    private Boolean PasamanoAbolladuras;

	public void setPasamanoCorrosion(Boolean PasamanoCorrosion) {this.PasamanoCorrosion = PasamanoCorrosion;}
	public Boolean getPasamanoCorrosion() {return PasamanoCorrosion;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setPasamanoId(Double PasamanoId) {this.PasamanoId = PasamanoId;}
	public Double getPasamanoId() {return PasamanoId;}
	public void setPasamanoCostado(String PasamanoCostado) {this.PasamanoCostado = PasamanoCostado;}
	public String getPasamanoCostado() {return PasamanoCostado;}
	public void setPasamanoLargo(Double PasamanoLargo) {this.PasamanoLargo = PasamanoLargo;}
	public Double getPasamanoLargo() {return PasamanoLargo;}
	public void setPasamanoAlto(Double PasamanoAlto) {this.PasamanoAlto = PasamanoAlto;}
	public Double getPasamanoAlto() {return PasamanoAlto;}
	public void setPasamanoLongitudmodulo(Double PasamanoLongitudmodulo) {this.PasamanoLongitudmodulo = PasamanoLongitudmodulo;}
	public Double getPasamanoLongitudmodulo() {return PasamanoLongitudmodulo;}
	public void setPasamanoNumeromodulos(Double PasamanoNumeromodulos) {this.PasamanoNumeromodulos = PasamanoNumeromodulos;}
	public Double getPasamanoNumeromodulos() {return PasamanoNumeromodulos;}
	public void setPasamanoAveria(Boolean PasamanoAveria) {this.PasamanoAveria = PasamanoAveria;}
	public Boolean getPasamanoAveria() {return PasamanoAveria;}
	public void setPasamanoPorcentajeaveria(Double PasamanoPorcentajeaveria) {this.PasamanoPorcentajeaveria = PasamanoPorcentajeaveria;}
	public Double getPasamanoPorcentajeaveria() {return PasamanoPorcentajeaveria;}
	public void setPasamanoSoldaduraaveria(Boolean PasamanoSoldaduraaveria) {this.PasamanoSoldaduraaveria = PasamanoSoldaduraaveria;}
	public Boolean getPasamanoSoldaduraaveria() {return PasamanoSoldaduraaveria;}
	public void setPasamanoPiezafaltante(Boolean PasamanoPiezafaltante) {this.PasamanoPiezafaltante = PasamanoPiezafaltante;}
	public Boolean getPasamanoPiezafaltante() {return PasamanoPiezafaltante;}
	public void setPasamanoAbolladuras(Boolean PasamanoAbolladuras) {this.PasamanoAbolladuras = PasamanoAbolladuras;}
	public Boolean getPasamanoAbolladuras() {return PasamanoAbolladuras;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}