package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_edificio")
public class Edificio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_edificio")
	private Integer id;

    @Column(name = "inv_edificio_id")
    private Double EdificioId;

    @Column(name = "inv_edificio_ancho")
    private Double EdificioAncho;

    @Column(name = "inv_edificio_largo")
    private Double EdificioLargo;

    @Column(name = "inv_edificio_nivel")
    private String EdificioNivel;

	public void setEdificioId(Double EdificioId) {this.EdificioId = EdificioId;}
	public Double getEdificioId() {return EdificioId;}
	public void setEdificioAncho(Double EdificioAncho) {this.EdificioAncho = EdificioAncho;}
	public Double getEdificioAncho() {return EdificioAncho;}
	public void setEdificioLargo(Double EdificioLargo) {this.EdificioLargo = EdificioLargo;}
	public Double getEdificioLargo() {return EdificioLargo;}
	public void setEdificioNivel(String EdificioNivel) {this.EdificioNivel = EdificioNivel;}
	public String getEdificioNivel() {return EdificioNivel;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}