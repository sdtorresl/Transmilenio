package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_techo")
public class Techo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_techo_tipo")
    private String TechoTipo;

    @Column(name = "inv_techo_averia")
    private Boolean TechoAveria;

    @Column(name = "inv_techo_area")
    private Double TechoArea;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setTechoTipo(String TechoTipo) {this.TechoTipo = TechoTipo;}
	public String getTechoTipo() {return TechoTipo;}
	public void setTechoAveria(Boolean TechoAveria) {this.TechoAveria = TechoAveria;}
	public Boolean getTechoAveria() {return TechoAveria;}
	public void setTechoArea(Double TechoArea) {this.TechoArea = TechoArea;}
	public Double getTechoArea() {return TechoArea;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}