package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_escotilla")
public class Escotilla implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_escotilla")
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_escotilla_id")
    private Double EscotillaId;

    @Column(name = "inv_escotilla_largo")
    private Double EscotillaLargo;

    @Column(name = "inv_escotilla_ancho")
    private Double EscotillaAncho;

    @Column(name = "inv_escotilla_tipo")
    private String EscotillaTipo;

    @Column(name = "inv_escotilla_averia")
    private Boolean EscotillaAveria;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setEscotillaId(Double EscotillaId) {this.EscotillaId = EscotillaId;}
	public Double getEscotillaId() {return EscotillaId;}
	public void setEscotillaLargo(Double EscotillaLargo) {this.EscotillaLargo = EscotillaLargo;}
	public Double getEscotillaLargo() {return EscotillaLargo;}
	public void setEscotillaAncho(Double EscotillaAncho) {this.EscotillaAncho = EscotillaAncho;}
	public Double getEscotillaAncho() {return EscotillaAncho;}
	public void setEscotillaTipo(String EscotillaTipo) {this.EscotillaTipo = EscotillaTipo;}
	public String getEscotillaTipo() {return EscotillaTipo;}
	public void setEscotillaAveria(Boolean EscotillaAveria) {this.EscotillaAveria = EscotillaAveria;}
	public Boolean getEscotillaAveria() {return EscotillaAveria;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}