package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_cono")
public class Cono implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_cono_averia")
    private Boolean ConoAveria;

    @Column(name = "inv_cono_hayconos")
    private Boolean ConoHayconos;

    @Column(name = "inv_cono_porcentajeaveria")
    private Double ConoPorcentajeaveria;

    @Column(name = "inv_cono_id")
    private Double ConoId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setConoAveria(Boolean ConoAveria) {this.ConoAveria = ConoAveria;}
	public Boolean getConoAveria() {return ConoAveria;}
	public void setConoHayconos(Boolean ConoHayconos) {this.ConoHayconos = ConoHayconos;}
	public Boolean getConoHayconos() {return ConoHayconos;}
	public void setConoPorcentajeaveria(Double ConoPorcentajeaveria) {this.ConoPorcentajeaveria = ConoPorcentajeaveria;}
	public Double getConoPorcentajeaveria() {return ConoPorcentajeaveria;}
	public void setConoId(Double ConoId) {this.ConoId = ConoId;}
	public Double getConoId() {return ConoId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}