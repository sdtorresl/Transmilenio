package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_entrada")
public class Entrada implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_entrada_id")
    private Double EntradaId;

    @Column(name = "inv_entrada_nivel")
    private String EntradaNivel;

    @Column(name = "inv_entrada_largo")
    private Double EntradaLargo;

    @Column(name = "inv_entrada_ancho")
    private Double EntradaAncho;

	public void setEntradaId(Double EntradaId) {this.EntradaId = EntradaId;}
	public Double getEntradaId() {return EntradaId;}
	public void setEntradaNivel(String EntradaNivel) {this.EntradaNivel = EntradaNivel;}
	public String getEntradaNivel() {return EntradaNivel;}
	public void setEntradaLargo(Double EntradaLargo) {this.EntradaLargo = EntradaLargo;}
	public Double getEntradaLargo() {return EntradaLargo;}
	public void setEntradaAncho(Double EntradaAncho) {this.EntradaAncho = EntradaAncho;}
	public Double getEntradaAncho() {return EntradaAncho;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}