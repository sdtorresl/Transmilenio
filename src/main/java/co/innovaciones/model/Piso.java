package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_piso")
public class Piso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_piso_porcentajeaveria")
    private Double PisoPorcentajeaveria;

    @Column(name = "inv_piso_averia")
    private Boolean PisoAveria;

    @Column(name = "inv_piso_area")
    private Double PisoArea;

    @Column(name = "inv_piso_longitud")
    private Double PisoLongitud;

    @Column(name = "inv_piso_modulo")
    private Double PisoModulo;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setPisoPorcentajeaveria(Double PisoPorcentajeaveria) {this.PisoPorcentajeaveria = PisoPorcentajeaveria;}
	public Double getPisoPorcentajeaveria() {return PisoPorcentajeaveria;}
	public void setPisoAveria(Boolean PisoAveria) {this.PisoAveria = PisoAveria;}
	public Boolean getPisoAveria() {return PisoAveria;}
	public void setPisoArea(Double PisoArea) {this.PisoArea = PisoArea;}
	public Double getPisoArea() {return PisoArea;}
	public void setPisoLongitud(Double PisoLongitud) {this.PisoLongitud = PisoLongitud;}
	public Double getPisoLongitud() {return PisoLongitud;}
	public void setPisoModulo(Double PisoModulo) {this.PisoModulo = PisoModulo;}
	public Double getPisoModulo() {return PisoModulo;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}