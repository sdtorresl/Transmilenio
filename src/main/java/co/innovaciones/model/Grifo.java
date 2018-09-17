package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_grifo")
public class Grifo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_grifo_id")
    private Double GrifoId;

    @Column(name = "inv_grifo_costado")
    private String GrifoCostado;

    @Column(name = "inv_grifo_averia")
    private Boolean GrifoAveria;

    @Column(name = "inv_grifo_corrosion")
    private Boolean GrifoCorrosion;

    @Column(name = "inv_grifo_escapeagua")
    private Boolean GrifoEscapeagua;

    @Column(name = "inv_grifo_sinagua")
    private Boolean GrifoSinagua;

    @Column(name = "inv_grifo_faltantes")
    private Boolean GrifoFaltantes;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setGrifoId(Double GrifoId) {this.GrifoId = GrifoId;}
	public Double getGrifoId() {return GrifoId;}
	public void setGrifoCostado(String GrifoCostado) {this.GrifoCostado = GrifoCostado;}
	public String getGrifoCostado() {return GrifoCostado;}
	public void setGrifoAveria(Boolean GrifoAveria) {this.GrifoAveria = GrifoAveria;}
	public Boolean getGrifoAveria() {return GrifoAveria;}
	public void setGrifoCorrosion(Boolean GrifoCorrosion) {this.GrifoCorrosion = GrifoCorrosion;}
	public Boolean getGrifoCorrosion() {return GrifoCorrosion;}
	public void setGrifoEscapeagua(Boolean GrifoEscapeagua) {this.GrifoEscapeagua = GrifoEscapeagua;}
	public Boolean getGrifoEscapeagua() {return GrifoEscapeagua;}
	public void setGrifoSinagua(Boolean GrifoSinagua) {this.GrifoSinagua = GrifoSinagua;}
	public Boolean getGrifoSinagua() {return GrifoSinagua;}
	public void setGrifoFaltantes(Boolean GrifoFaltantes) {this.GrifoFaltantes = GrifoFaltantes;}
	public Boolean getGrifoFaltantes() {return GrifoFaltantes;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}