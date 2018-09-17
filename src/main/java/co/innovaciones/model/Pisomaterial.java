package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_pisomaterial")
public class Pisomaterial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_pisomaterial")
    private Double IdPisomaterial;

    @Column(name = "inv_id_piso")
    private Double IdPiso;

    @Column(name = "inv_pisomaterial_tipo")
    private String PisomaterialTipo;

	public void setIdPisomaterial(Double IdPisomaterial) {this.IdPisomaterial = IdPisomaterial;}
	public Double getIdPisomaterial() {return IdPisomaterial;}
	public void setIdPiso(Double IdPiso) {this.IdPiso = IdPiso;}
	public Double getIdPiso() {return IdPiso;}
	public void setPisomaterialTipo(String PisomaterialTipo) {this.PisomaterialTipo = PisomaterialTipo;}
	public String getPisomaterialTipo() {return PisomaterialTipo;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}