package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_conexa")
public class Conexa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_conexa_area")
    private Double ConexaArea;

    @Column(name = "inv_conexa_numero")
    private Double ConexaNumero;

	public void setConexaArea(Double ConexaArea) {this.ConexaArea = ConexaArea;}
	public Double getConexaArea() {return ConexaArea;}
	public void setConexaNumero(Double ConexaNumero) {this.ConexaNumero = ConexaNumero;}
	public Double getConexaNumero() {return ConexaNumero;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}