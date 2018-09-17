package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_rampamaterial")
public class Rampamaterial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_rampamaterial_tipo")
    private String RampamaterialTipo;

    @Column(name = "inv_id_rampa")
    private Double IdRampa;

    @Column(name = "inv_id_rampamaterial")
    private Double IdRampamaterial;

	public void setRampamaterialTipo(String RampamaterialTipo) {this.RampamaterialTipo = RampamaterialTipo;}
	public String getRampamaterialTipo() {return RampamaterialTipo;}
	public void setIdRampa(Double IdRampa) {this.IdRampa = IdRampa;}
	public Double getIdRampa() {return IdRampa;}
	public void setIdRampamaterial(Double IdRampamaterial) {this.IdRampamaterial = IdRampamaterial;}
	public Double getIdRampamaterial() {return IdRampamaterial;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}