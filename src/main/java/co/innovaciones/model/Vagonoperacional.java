package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_vagonoperacional")
public class Vagonoperacional implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_vagonoperacional_id")
    private Double VagonoperacionalId;

    @Column(name = "inv_vagon_nomenclatura")
    private String VagonNomenclatura;

	public void setVagonoperacionalId(Double VagonoperacionalId) {this.VagonoperacionalId = VagonoperacionalId;}
	public Double getVagonoperacionalId() {return VagonoperacionalId;}
	public void setVagonNomenclatura(String VagonNomenclatura) {this.VagonNomenclatura = VagonNomenclatura;}
	public String getVagonNomenclatura() {return VagonNomenclatura;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}