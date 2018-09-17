package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_toma")
public class Toma implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_toma")
	private Integer id;

    @Column(name = "inv_toma_destruido")
    private Boolean TomaDestruido;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_toma_numero")
    private Double TomaNumero;

    @Column(name = "inv_toma_tipo")
    private String TomaTipo;

    @Column(name = "inv_toma_costado")
    private String TomaCostado;

    @Column(name = "inv_toma_averia")
    private Boolean TomaAveria;

    @Column(name = "inv_toma_tension")
    private Boolean TomaTension;

    @Column(name = "inv_toma_tapafalta")
    private Boolean TomaTapafalta;

    @Column(name = "inv_toma_porcentajetapafalta")
    private Double TomaPorcentajetapafalta;

    @Column(name = "inv_toma_sinservicio")
    private Boolean TomaSinservicio;

    @Column(name = "inv_toma_cableado")
    private Boolean TomaCableado;

	public void setTomaDestruido(Boolean TomaDestruido) {this.TomaDestruido = TomaDestruido;}
	public Boolean getTomaDestruido() {return TomaDestruido;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setTomaNumero(Double TomaNumero) {this.TomaNumero = TomaNumero;}
	public Double getTomaNumero() {return TomaNumero;}
	public void setTomaTipo(String TomaTipo) {this.TomaTipo = TomaTipo;}
	public String getTomaTipo() {return TomaTipo;}
	public void setTomaCostado(String TomaCostado) {this.TomaCostado = TomaCostado;}
	public String getTomaCostado() {return TomaCostado;}
	public void setTomaAveria(Boolean TomaAveria) {this.TomaAveria = TomaAveria;}
	public Boolean getTomaAveria() {return TomaAveria;}
	public void setTomaTension(Boolean TomaTension) {this.TomaTension = TomaTension;}
	public Boolean getTomaTension() {return TomaTension;}
	public void setTomaTapafalta(Boolean TomaTapafalta) {this.TomaTapafalta = TomaTapafalta;}
	public Boolean getTomaTapafalta() {return TomaTapafalta;}
	public void setTomaPorcentajetapafalta(Double TomaPorcentajetapafalta) {this.TomaPorcentajetapafalta = TomaPorcentajetapafalta;}
	public Double getTomaPorcentajetapafalta() {return TomaPorcentajetapafalta;}
	public void setTomaSinservicio(Boolean TomaSinservicio) {this.TomaSinservicio = TomaSinservicio;}
	public Boolean getTomaSinservicio() {return TomaSinservicio;}
	public void setTomaCableado(Boolean TomaCableado) {this.TomaCableado = TomaCableado;}
	public Boolean getTomaCableado() {return TomaCableado;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}