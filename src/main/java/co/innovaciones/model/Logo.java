package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_logo")
public class Logo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_logo_perdida")
    private Boolean LogoPerdida;

    @Column(name = "inv_logo_legible")
    private Boolean LogoLegible;

    @Column(name = "inv_logo_malestado")
    private Boolean LogoMalestado;

    @Column(name = "inv_logo_averia")
    private Boolean LogoAveria;

    @Column(name = "inv_logo_numerologos")
    private Double LogoNumerologos;

    @Column(name = "inv_logo_costado")
    private String LogoCostado;

    @Column(name = "inv_logo_id")
    private Double LogoId;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setLogoPerdida(Boolean LogoPerdida) {this.LogoPerdida = LogoPerdida;}
	public Boolean getLogoPerdida() {return LogoPerdida;}
	public void setLogoLegible(Boolean LogoLegible) {this.LogoLegible = LogoLegible;}
	public Boolean getLogoLegible() {return LogoLegible;}
	public void setLogoMalestado(Boolean LogoMalestado) {this.LogoMalestado = LogoMalestado;}
	public Boolean getLogoMalestado() {return LogoMalestado;}
	public void setLogoAveria(Boolean LogoAveria) {this.LogoAveria = LogoAveria;}
	public Boolean getLogoAveria() {return LogoAveria;}
	public void setLogoNumerologos(Double LogoNumerologos) {this.LogoNumerologos = LogoNumerologos;}
	public Double getLogoNumerologos() {return LogoNumerologos;}
	public void setLogoCostado(String LogoCostado) {this.LogoCostado = LogoCostado;}
	public String getLogoCostado() {return LogoCostado;}
	public void setLogoId(Double LogoId) {this.LogoId = LogoId;}
	public Double getLogoId() {return LogoId;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}