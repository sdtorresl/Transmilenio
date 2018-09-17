package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_vagon")
public class Vagon implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_vagon")
	private Integer id;

    @Column(name = "inv_id_vagonoperacional")
    private String IdVagonoperacional;

    @Column(name = "inv_vagon_id")
    private Double VagonId;

    @Column(name = "inv_vagon_nomenclatura")
    private String VagonNomenclatura;

    @Column(name = "inv_vagon_nomoperacional")
    private String VagonNomoperacional;

    @Column(name = "inv_vagon_nomusuario")
    private String VagonNomusuario;

    @Column(name = "inv_vagon_largo")
    private Double VagonLargo;

    @Column(name = "inv_vagon_ancho")
    private Double VagonAncho;

    @Column(name = "inv_vagon_nivel")
    private String VagonNivel;

	public void setIdVagonoperacional(String IdVagonoperacional) {this.IdVagonoperacional = IdVagonoperacional;}
	public String getIdVagonoperacional() {return IdVagonoperacional;}
	public void setVagonId(Double VagonId) {this.VagonId = VagonId;}
	public Double getVagonId() {return VagonId;}
	public void setVagonNomenclatura(String VagonNomenclatura) {this.VagonNomenclatura = VagonNomenclatura;}
	public String getVagonNomenclatura() {return VagonNomenclatura;}
	public void setVagonNomoperacional(String VagonNomoperacional) {this.VagonNomoperacional = VagonNomoperacional;}
	public String getVagonNomoperacional() {return VagonNomoperacional;}
	public void setVagonNomusuario(String VagonNomusuario) {this.VagonNomusuario = VagonNomusuario;}
	public String getVagonNomusuario() {return VagonNomusuario;}
	public void setVagonLargo(Double VagonLargo) {this.VagonLargo = VagonLargo;}
	public Double getVagonLargo() {return VagonLargo;}
	public void setVagonAncho(Double VagonAncho) {this.VagonAncho = VagonAncho;}
	public Double getVagonAncho() {return VagonAncho;}
	public void setVagonNivel(String VagonNivel) {this.VagonNivel = VagonNivel;}
	public String getVagonNivel() {return VagonNivel;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}