package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_isquiatico")
public class Isquiatico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_isquiatico")
	private Integer id;

    @Column(name = "inv_isquiatico_corrosion")
    private Boolean IsquiaticoCorrosion;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_isquiatico_id")
    private Double IsquiaticoId;

    @Column(name = "inv_isquiatico_costado")
    private String IsquiaticoCostado;

    @Column(name = "inv_isquiatico_largo")
    private Double IsquiaticoLargo;

    @Column(name = "inv_isquiatico_averia")
    private Boolean IsquiaticoAveria;

    @Column(name = "inv_isquiatico_porcentajeaveria")
    private Double IsquiaticoPorcentajeaveria;

    @Column(name = "inv_isquiatico_soldaduraaveria")
    private Boolean IsquiaticoSoldaduraaveria;

    @Column(name = "inv_isquiatico_piezasfaltante")
    private Boolean IsquiaticoPiezasfaltante;

    @Column(name = "inv_isquiatico_abolladuras")
    private Boolean IsquiaticoAbolladuras;

	public void setIsquiaticoCorrosion(Boolean IsquiaticoCorrosion) {this.IsquiaticoCorrosion = IsquiaticoCorrosion;}
	public Boolean getIsquiaticoCorrosion() {return IsquiaticoCorrosion;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setIsquiaticoId(Double IsquiaticoId) {this.IsquiaticoId = IsquiaticoId;}
	public Double getIsquiaticoId() {return IsquiaticoId;}
	public void setIsquiaticoCostado(String IsquiaticoCostado) {this.IsquiaticoCostado = IsquiaticoCostado;}
	public String getIsquiaticoCostado() {return IsquiaticoCostado;}
	public void setIsquiaticoLargo(Double IsquiaticoLargo) {this.IsquiaticoLargo = IsquiaticoLargo;}
	public Double getIsquiaticoLargo() {return IsquiaticoLargo;}
	public void setIsquiaticoAveria(Boolean IsquiaticoAveria) {this.IsquiaticoAveria = IsquiaticoAveria;}
	public Boolean getIsquiaticoAveria() {return IsquiaticoAveria;}
	public void setIsquiaticoPorcentajeaveria(Double IsquiaticoPorcentajeaveria) {this.IsquiaticoPorcentajeaveria = IsquiaticoPorcentajeaveria;}
	public Double getIsquiaticoPorcentajeaveria() {return IsquiaticoPorcentajeaveria;}
	public void setIsquiaticoSoldaduraaveria(Boolean IsquiaticoSoldaduraaveria) {this.IsquiaticoSoldaduraaveria = IsquiaticoSoldaduraaveria;}
	public Boolean getIsquiaticoSoldaduraaveria() {return IsquiaticoSoldaduraaveria;}
	public void setIsquiaticoPiezasfaltante(Boolean IsquiaticoPiezasfaltante) {this.IsquiaticoPiezasfaltante = IsquiaticoPiezasfaltante;}
	public Boolean getIsquiaticoPiezasfaltante() {return IsquiaticoPiezasfaltante;}
	public void setIsquiaticoAbolladuras(Boolean IsquiaticoAbolladuras) {this.IsquiaticoAbolladuras = IsquiaticoAbolladuras;}
	public Boolean getIsquiaticoAbolladuras() {return IsquiaticoAbolladuras;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}