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

    @Column(name = "inv_entrada_nivel")
    private String nivel;

    @Column(name = "inv_entrada_largo")
    private Double largo;

    @Column(name = "inv_entrada_ancho")
    private Double ancho;

	public void setNivel(String nivel) {this.nivel = nivel;}
	public String getNivel() {return nivel;}
	public void setLargo(Double largo) {this.largo = largo;}
	public Double getLargo() {return largo;}
	public void setAncho(Double ancho) {this.ancho = ancho;}
	public Double getAncho() {return ancho;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}