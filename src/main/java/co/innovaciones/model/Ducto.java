package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_ducto")
public class Ducto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_ducto")
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_ducto_id")
    private Double DuctoId;

    @Column(name = "inv_ducto_tipo")
    private String DuctoTipo;

    @Column(name = "inv_ducto_corrosion")
    private Boolean DuctoCorrosion;

    @Column(name = "inv_ducto_fisura")
    private Boolean DuctoFisura;

    @Column(name = "inv_ducto_pieza")
    private Boolean DuctoPieza;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setDuctoId(Double DuctoId) {this.DuctoId = DuctoId;}
	public Double getDuctoId() {return DuctoId;}
	public void setDuctoTipo(String DuctoTipo) {this.DuctoTipo = DuctoTipo;}
	public String getDuctoTipo() {return DuctoTipo;}
	public void setDuctoCorrosion(Boolean DuctoCorrosion) {this.DuctoCorrosion = DuctoCorrosion;}
	public Boolean getDuctoCorrosion() {return DuctoCorrosion;}
	public void setDuctoFisura(Boolean DuctoFisura) {this.DuctoFisura = DuctoFisura;}
	public Boolean getDuctoFisura() {return DuctoFisura;}
	public void setDuctoPieza(Boolean DuctoPieza) {this.DuctoPieza = DuctoPieza;}
	public Boolean getDuctoPieza() {return DuctoPieza;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}