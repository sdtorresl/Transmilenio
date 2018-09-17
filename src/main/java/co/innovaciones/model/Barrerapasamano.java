package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_barrerapasamano")
public class Barrerapasamano implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_barrerapasamano")
    private Double IdBarrerapasamano;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_barrerapasamano_id")
    private Double BarrerapasamanoId;

    @Column(name = "inv_barrerapasamano_costado")
    private String BarrerapasamanoCostado;

    @Column(name = "inv_barrerapasamano_largo")
    private Double BarrerapasamanoLargo;

    @Column(name = "inv_barrerapasamano_alto")
    private Double BarrerapasamanoAlto;

    @Column(name = "inv_barrerapasamano_numeromodulos")
    private Double BarrerapasamanoNumeromodulos;

    @Column(name = "inv_barrerapasamano_longitudmodulos")
    private Double BarrerapasamanoLongitudmodulos;

    @Column(name = "inv_barrerapasamano_alturamodulo")
    private Double BarrerapasamanoAlturamodulo;

    @Column(name = "inv_barrerapasamano_tipo")
    private String BarrerapasamanoTipo;

    @Column(name = "inv_barrerapasamano_averia")
    private Boolean BarrerapasamanoAveria;

    @Column(name = "inv_barrerapasamano_porcentajeaveria")
    private Double BarrerapasamanoPorcentajeaveria;

    @Column(name = "inv_barrerapasamano_corrosion")
    private Boolean BarrerapasamanoCorrosion;

    @Column(name = "inv_barrerapasamano_abolladuras")
    private Boolean BarrerapasamanoAbolladuras;

    @Column(name = "inv_barrerapasamano_pintura")
    private Boolean BarrerapasamanoPintura;

    @Column(name = "inv_barrerapasamano_tubofaltante")
    private Boolean BarrerapasamanoTubofaltante;

    @Column(name = "inv_barrerapasamano_contaminacion")
    private Boolean BarrerapasamanoContaminacion;

    @Column(name = "inv_barrerapasamano_soldadura")
    private Boolean BarrerapasamanoSoldadura;

	public void setIdBarrerapasamano(Double IdBarrerapasamano) {this.IdBarrerapasamano = IdBarrerapasamano;}
	public Double getIdBarrerapasamano() {return IdBarrerapasamano;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setBarrerapasamanoId(Double BarrerapasamanoId) {this.BarrerapasamanoId = BarrerapasamanoId;}
	public Double getBarrerapasamanoId() {return BarrerapasamanoId;}
	public void setBarrerapasamanoCostado(String BarrerapasamanoCostado) {this.BarrerapasamanoCostado = BarrerapasamanoCostado;}
	public String getBarrerapasamanoCostado() {return BarrerapasamanoCostado;}
	public void setBarrerapasamanoLargo(Double BarrerapasamanoLargo) {this.BarrerapasamanoLargo = BarrerapasamanoLargo;}
	public Double getBarrerapasamanoLargo() {return BarrerapasamanoLargo;}
	public void setBarrerapasamanoAlto(Double BarrerapasamanoAlto) {this.BarrerapasamanoAlto = BarrerapasamanoAlto;}
	public Double getBarrerapasamanoAlto() {return BarrerapasamanoAlto;}
	public void setBarrerapasamanoNumeromodulos(Double BarrerapasamanoNumeromodulos) {this.BarrerapasamanoNumeromodulos = BarrerapasamanoNumeromodulos;}
	public Double getBarrerapasamanoNumeromodulos() {return BarrerapasamanoNumeromodulos;}
	public void setBarrerapasamanoLongitudmodulos(Double BarrerapasamanoLongitudmodulos) {this.BarrerapasamanoLongitudmodulos = BarrerapasamanoLongitudmodulos;}
	public Double getBarrerapasamanoLongitudmodulos() {return BarrerapasamanoLongitudmodulos;}
	public void setBarrerapasamanoAlturamodulo(Double BarrerapasamanoAlturamodulo) {this.BarrerapasamanoAlturamodulo = BarrerapasamanoAlturamodulo;}
	public Double getBarrerapasamanoAlturamodulo() {return BarrerapasamanoAlturamodulo;}
	public void setBarrerapasamanoTipo(String BarrerapasamanoTipo) {this.BarrerapasamanoTipo = BarrerapasamanoTipo;}
	public String getBarrerapasamanoTipo() {return BarrerapasamanoTipo;}
	public void setBarrerapasamanoAveria(Boolean BarrerapasamanoAveria) {this.BarrerapasamanoAveria = BarrerapasamanoAveria;}
	public Boolean getBarrerapasamanoAveria() {return BarrerapasamanoAveria;}
	public void setBarrerapasamanoPorcentajeaveria(Double BarrerapasamanoPorcentajeaveria) {this.BarrerapasamanoPorcentajeaveria = BarrerapasamanoPorcentajeaveria;}
	public Double getBarrerapasamanoPorcentajeaveria() {return BarrerapasamanoPorcentajeaveria;}
	public void setBarrerapasamanoCorrosion(Boolean BarrerapasamanoCorrosion) {this.BarrerapasamanoCorrosion = BarrerapasamanoCorrosion;}
	public Boolean getBarrerapasamanoCorrosion() {return BarrerapasamanoCorrosion;}
	public void setBarrerapasamanoAbolladuras(Boolean BarrerapasamanoAbolladuras) {this.BarrerapasamanoAbolladuras = BarrerapasamanoAbolladuras;}
	public Boolean getBarrerapasamanoAbolladuras() {return BarrerapasamanoAbolladuras;}
	public void setBarrerapasamanoPintura(Boolean BarrerapasamanoPintura) {this.BarrerapasamanoPintura = BarrerapasamanoPintura;}
	public Boolean getBarrerapasamanoPintura() {return BarrerapasamanoPintura;}
	public void setBarrerapasamanoTubofaltante(Boolean BarrerapasamanoTubofaltante) {this.BarrerapasamanoTubofaltante = BarrerapasamanoTubofaltante;}
	public Boolean getBarrerapasamanoTubofaltante() {return BarrerapasamanoTubofaltante;}
	public void setBarrerapasamanoContaminacion(Boolean BarrerapasamanoContaminacion) {this.BarrerapasamanoContaminacion = BarrerapasamanoContaminacion;}
	public Boolean getBarrerapasamanoContaminacion() {return BarrerapasamanoContaminacion;}
	public void setBarrerapasamanoSoldadura(Boolean BarrerapasamanoSoldadura) {this.BarrerapasamanoSoldadura = BarrerapasamanoSoldadura;}
	public Boolean getBarrerapasamanoSoldadura() {return BarrerapasamanoSoldadura;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}