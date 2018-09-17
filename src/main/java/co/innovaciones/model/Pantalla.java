package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_pantalla")
public class Pantalla implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_pantalla")
	private Integer id;

    @Column(name = "inv_pantalla_porcentajemanchas")
    private Double PantallaPorcentajemanchas;

    @Column(name = "inv_pantalla_fisura")
    private Boolean PantallaFisura;

    @Column(name = "inv_pantalla_sinservicio")
    private Boolean PantallaSinservicio;

    @Column(name = "inv_pantalla_numero")
    private Double PantallaNumero;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_pantalla_costado")
    private String PantallaCostado;

    @Column(name = "inv_pantalla_averia")
    private Boolean PantallaAveria;

    @Column(name = "inv_pantalla_manchas")
    private Boolean PantallaManchas;

	public void setPantallaPorcentajemanchas(Double PantallaPorcentajemanchas) {this.PantallaPorcentajemanchas = PantallaPorcentajemanchas;}
	public Double getPantallaPorcentajemanchas() {return PantallaPorcentajemanchas;}
	public void setPantallaFisura(Boolean PantallaFisura) {this.PantallaFisura = PantallaFisura;}
	public Boolean getPantallaFisura() {return PantallaFisura;}
	public void setPantallaSinservicio(Boolean PantallaSinservicio) {this.PantallaSinservicio = PantallaSinservicio;}
	public Boolean getPantallaSinservicio() {return PantallaSinservicio;}
	public void setPantallaNumero(Double PantallaNumero) {this.PantallaNumero = PantallaNumero;}
	public Double getPantallaNumero() {return PantallaNumero;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setPantallaCostado(String PantallaCostado) {this.PantallaCostado = PantallaCostado;}
	public String getPantallaCostado() {return PantallaCostado;}
	public void setPantallaAveria(Boolean PantallaAveria) {this.PantallaAveria = PantallaAveria;}
	public Boolean getPantallaAveria() {return PantallaAveria;}
	public void setPantallaManchas(Boolean PantallaManchas) {this.PantallaManchas = PantallaManchas;}
	public Boolean getPantallaManchas() {return PantallaManchas;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}