package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_canal")
public class Canal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_canal")
    private Double IdCanal;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_canal_id")
    private Double CanalId;

    @Column(name = "inv_canal_averia")
    private Boolean CanalAveria;

    @Column(name = "inv_canal_porcentajeaveria")
    private Double CanalPorcentajeaveria;

    @Column(name = "inv_canal_corrosion")
    private Boolean CanalCorrosion;

    @Column(name = "inv_canal_discontinuo")
    private Boolean CanalDiscontinuo;

    @Column(name = "inv_canal_desajustado")
    private Boolean CanalDesajustado;

	public void setIdCanal(Double IdCanal) {this.IdCanal = IdCanal;}
	public Double getIdCanal() {return IdCanal;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setCanalId(Double CanalId) {this.CanalId = CanalId;}
	public Double getCanalId() {return CanalId;}
	public void setCanalAveria(Boolean CanalAveria) {this.CanalAveria = CanalAveria;}
	public Boolean getCanalAveria() {return CanalAveria;}
	public void setCanalPorcentajeaveria(Double CanalPorcentajeaveria) {this.CanalPorcentajeaveria = CanalPorcentajeaveria;}
	public Double getCanalPorcentajeaveria() {return CanalPorcentajeaveria;}
	public void setCanalCorrosion(Boolean CanalCorrosion) {this.CanalCorrosion = CanalCorrosion;}
	public Boolean getCanalCorrosion() {return CanalCorrosion;}
	public void setCanalDiscontinuo(Boolean CanalDiscontinuo) {this.CanalDiscontinuo = CanalDiscontinuo;}
	public Boolean getCanalDiscontinuo() {return CanalDiscontinuo;}
	public void setCanalDesajustado(Boolean CanalDesajustado) {this.CanalDesajustado = CanalDesajustado;}
	public Boolean getCanalDesajustado() {return CanalDesajustado;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}