package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_poste")
public class Poste implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_poste")
	private Integer id;

    @Column(name = "inv_poste_tipo")
    private String PosteTipo;

    @Column(name = "inv_poste_deformacion")
    private Boolean PosteDeformacion;

    @Column(name = "inv_poste_corrosion")
    private Boolean PosteCorrosion;

    @Column(name = "inv_poste_contaminacion")
    private Boolean PosteContaminacion;

    @Column(name = "inv_poste_pintura")
    private Boolean PostePintura;

    @Column(name = "inv_poste_perdida")
    private Boolean PostePerdida;

    @Column(name = "inv_poste_porcentajeaveria")
    private Double PostePorcentajeaveria;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_poste_id")
    private Double PosteId;

    @Column(name = "inv_poste_averia")
    private Boolean PosteAveria;

	public void setPosteTipo(String PosteTipo) {this.PosteTipo = PosteTipo;}
	public String getPosteTipo() {return PosteTipo;}
	public void setPosteDeformacion(Boolean PosteDeformacion) {this.PosteDeformacion = PosteDeformacion;}
	public Boolean getPosteDeformacion() {return PosteDeformacion;}
	public void setPosteCorrosion(Boolean PosteCorrosion) {this.PosteCorrosion = PosteCorrosion;}
	public Boolean getPosteCorrosion() {return PosteCorrosion;}
	public void setPosteContaminacion(Boolean PosteContaminacion) {this.PosteContaminacion = PosteContaminacion;}
	public Boolean getPosteContaminacion() {return PosteContaminacion;}
	public void setPostePintura(Boolean PostePintura) {this.PostePintura = PostePintura;}
	public Boolean getPostePintura() {return PostePintura;}
	public void setPostePerdida(Boolean PostePerdida) {this.PostePerdida = PostePerdida;}
	public Boolean getPostePerdida() {return PostePerdida;}
	public void setPostePorcentajeaveria(Double PostePorcentajeaveria) {this.PostePorcentajeaveria = PostePorcentajeaveria;}
	public Double getPostePorcentajeaveria() {return PostePorcentajeaveria;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setPosteId(Double PosteId) {this.PosteId = PosteId;}
	public Double getPosteId() {return PosteId;}
	public void setPosteAveria(Boolean PosteAveria) {this.PosteAveria = PosteAveria;}
	public Boolean getPosteAveria() {return PosteAveria;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}