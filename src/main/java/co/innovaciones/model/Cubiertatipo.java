package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_cubiertatipo")
public class Cubiertatipo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_cubiertatipo")
    private Double IdCubiertatipo;

    @Column(name = "inv_id_cubierta")
    private Double IdCubierta;

    @Column(name = "inv_cubiertatipo_material")
    private String CubiertatipoMaterial;

	public void setIdCubiertatipo(Double IdCubiertatipo) {this.IdCubiertatipo = IdCubiertatipo;}
	public Double getIdCubiertatipo() {return IdCubiertatipo;}
	public void setIdCubierta(Double IdCubierta) {this.IdCubierta = IdCubierta;}
	public Double getIdCubierta() {return IdCubierta;}
	public void setCubiertatipoMaterial(String CubiertatipoMaterial) {this.CubiertatipoMaterial = CubiertatipoMaterial;}
	public String getCubiertatipoMaterial() {return CubiertatipoMaterial;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}