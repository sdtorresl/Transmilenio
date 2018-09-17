package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_transicion")
public class Transicion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_transicion_id")
    private String TransicionId;

    @Column(name = "inv_transicion_numero")
    private Double TransicionNumero;

    @Column(name = "inv_transicion_largo")
    private Double TransicionLargo;

    @Column(name = "inv_transicion_ancho")
    private Double TransicionAncho;

	public void setTransicionId(String TransicionId) {this.TransicionId = TransicionId;}
	public String getTransicionId() {return TransicionId;}
	public void setTransicionNumero(Double TransicionNumero) {this.TransicionNumero = TransicionNumero;}
	public Double getTransicionNumero() {return TransicionNumero;}
	public void setTransicionLargo(Double TransicionLargo) {this.TransicionLargo = TransicionLargo;}
	public Double getTransicionLargo() {return TransicionLargo;}
	public void setTransicionAncho(Double TransicionAncho) {this.TransicionAncho = TransicionAncho;}
	public Double getTransicionAncho() {return TransicionAncho;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}