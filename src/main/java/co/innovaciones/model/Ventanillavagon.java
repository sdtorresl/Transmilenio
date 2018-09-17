package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_ventanillavagon")
public class Ventanillavagon implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_ventanillavagon_cantidadaverias")
    private Integer VentanillavagonCantidadaverias;

    @Column(name = "inv_ventanillavagon_cantidad")
    private Integer VentanillavagonCantidad;

    @Column(name = "inv_ventanillavagon_costado")
    private String VentanillavagonCostado;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setVentanillavagonCantidadaverias(Integer VentanillavagonCantidadaverias) {this.VentanillavagonCantidadaverias = VentanillavagonCantidadaverias;}
	public Integer getVentanillavagonCantidadaverias() {return VentanillavagonCantidadaverias;}
	public void setVentanillavagonCantidad(Integer VentanillavagonCantidad) {this.VentanillavagonCantidad = VentanillavagonCantidad;}
	public Integer getVentanillavagonCantidad() {return VentanillavagonCantidad;}
	public void setVentanillavagonCostado(String VentanillavagonCostado) {this.VentanillavagonCostado = VentanillavagonCostado;}
	public String getVentanillavagonCostado() {return VentanillavagonCostado;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}