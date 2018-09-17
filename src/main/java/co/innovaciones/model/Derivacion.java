package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_derivacion")
public class Derivacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_derivacion")
    private Double IdDerivacion;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_derivacion_id")
    private Double DerivacionId;

    @Column(name = "inv_derivacion_costado")
    private String DerivacionCostado;

    @Column(name = "inv_derivacion_averia")
    private Boolean DerivacionAveria;

    @Column(name = "inv_derivacion_corrosion")
    private Boolean DerivacionCorrosion;

    @Column(name = "inv_derivacion_porcentajecorrosion")
    private Double DerivacionPorcentajecorrosion;

    @Column(name = "inv_derivacion_sintuberia")
    private Boolean DerivacionSintuberia;

    @Column(name = "inv_derivacion_sintapa")
    private Boolean DerivacionSintapa;

	public void setIdDerivacion(Double IdDerivacion) {this.IdDerivacion = IdDerivacion;}
	public Double getIdDerivacion() {return IdDerivacion;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setDerivacionId(Double DerivacionId) {this.DerivacionId = DerivacionId;}
	public Double getDerivacionId() {return DerivacionId;}
	public void setDerivacionCostado(String DerivacionCostado) {this.DerivacionCostado = DerivacionCostado;}
	public String getDerivacionCostado() {return DerivacionCostado;}
	public void setDerivacionAveria(Boolean DerivacionAveria) {this.DerivacionAveria = DerivacionAveria;}
	public Boolean getDerivacionAveria() {return DerivacionAveria;}
	public void setDerivacionCorrosion(Boolean DerivacionCorrosion) {this.DerivacionCorrosion = DerivacionCorrosion;}
	public Boolean getDerivacionCorrosion() {return DerivacionCorrosion;}
	public void setDerivacionPorcentajecorrosion(Double DerivacionPorcentajecorrosion) {this.DerivacionPorcentajecorrosion = DerivacionPorcentajecorrosion;}
	public Double getDerivacionPorcentajecorrosion() {return DerivacionPorcentajecorrosion;}
	public void setDerivacionSintuberia(Boolean DerivacionSintuberia) {this.DerivacionSintuberia = DerivacionSintuberia;}
	public Boolean getDerivacionSintuberia() {return DerivacionSintuberia;}
	public void setDerivacionSintapa(Boolean DerivacionSintapa) {this.DerivacionSintapa = DerivacionSintapa;}
	public Boolean getDerivacionSintapa() {return DerivacionSintapa;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}