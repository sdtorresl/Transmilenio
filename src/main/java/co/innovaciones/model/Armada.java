package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_armada")
public class Armada implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_armada_longitud")
    private Double ArmadaLongitud;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_armada_id")
    private Double ArmadaId;

    @Column(name = "inv_armada_alto")
    private Double ArmadaAlto;

    @Column(name = "inv_armada_averia")
    private Boolean ArmadaAveria;

    @Column(name = "inv_armada_porcentajeaveria")
    private Double ArmadaPorcentajeaveria;

    @Column(name = "inv_armada_grietas")
    private Boolean ArmadaGrietas;

    @Column(name = "inv_armada_filtraciones")
    private Boolean ArmadaFiltraciones;

    @Column(name = "inv_armada_deformaciones")
    private Boolean ArmadaDeformaciones;

    @Column(name = "inv_armada_contaminacion")
    private Boolean ArmadaContaminacion;

	public void setArmadaLongitud(Double ArmadaLongitud) {this.ArmadaLongitud = ArmadaLongitud;}
	public Double getArmadaLongitud() {return ArmadaLongitud;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setArmadaId(Double ArmadaId) {this.ArmadaId = ArmadaId;}
	public Double getArmadaId() {return ArmadaId;}
	public void setArmadaAlto(Double ArmadaAlto) {this.ArmadaAlto = ArmadaAlto;}
	public Double getArmadaAlto() {return ArmadaAlto;}
	public void setArmadaAveria(Boolean ArmadaAveria) {this.ArmadaAveria = ArmadaAveria;}
	public Boolean getArmadaAveria() {return ArmadaAveria;}
	public void setArmadaPorcentajeaveria(Double ArmadaPorcentajeaveria) {this.ArmadaPorcentajeaveria = ArmadaPorcentajeaveria;}
	public Double getArmadaPorcentajeaveria() {return ArmadaPorcentajeaveria;}
	public void setArmadaGrietas(Boolean ArmadaGrietas) {this.ArmadaGrietas = ArmadaGrietas;}
	public Boolean getArmadaGrietas() {return ArmadaGrietas;}
	public void setArmadaFiltraciones(Boolean ArmadaFiltraciones) {this.ArmadaFiltraciones = ArmadaFiltraciones;}
	public Boolean getArmadaFiltraciones() {return ArmadaFiltraciones;}
	public void setArmadaDeformaciones(Boolean ArmadaDeformaciones) {this.ArmadaDeformaciones = ArmadaDeformaciones;}
	public Boolean getArmadaDeformaciones() {return ArmadaDeformaciones;}
	public void setArmadaContaminacion(Boolean ArmadaContaminacion) {this.ArmadaContaminacion = ArmadaContaminacion;}
	public Boolean getArmadaContaminacion() {return ArmadaContaminacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}