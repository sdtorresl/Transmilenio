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
public class Entrance implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_entrada_nivel")
    private String level;

    @Column(name = "inv_entrada_largo")
    private Double length;

    @Column(name = "inv_entrada_ancho")
    private Double width;

	public void setLevel(String level) {this.level = level;}
	public String getLevel() {return level;}
	public void setLength(Double length) {this.length = length;}
	public Double getLength() {return length;}
	public void setWidth(Double width) {this.width = width;}
	public Double getWidth() {return width;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}