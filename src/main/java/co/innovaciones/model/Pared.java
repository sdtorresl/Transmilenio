package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_pared")
public class Pared implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_pared_id")
    private Double ParedId;

    @Column(name = "inv_pared_averia")
    private Boolean ParedAveria;

    @Column(name = "inv_pared_area")
    private Double ParedArea;

    @Column(name = "inv_pared_porcentajeaveria")
    private Double ParedPorcentajeaveria;

    @Column(name = "inv_pared_tipo")
    private String ParedTipo;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setParedId(Double ParedId) {this.ParedId = ParedId;}
	public Double getParedId() {return ParedId;}
	public void setParedAveria(Boolean ParedAveria) {this.ParedAveria = ParedAveria;}
	public Boolean getParedAveria() {return ParedAveria;}
	public void setParedArea(Double ParedArea) {this.ParedArea = ParedArea;}
	public Double getParedArea() {return ParedArea;}
	public void setParedPorcentajeaveria(Double ParedPorcentajeaveria) {this.ParedPorcentajeaveria = ParedPorcentajeaveria;}
	public Double getParedPorcentajeaveria() {return ParedPorcentajeaveria;}
	public void setParedTipo(String ParedTipo) {this.ParedTipo = ParedTipo;}
	public String getParedTipo() {return ParedTipo;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}