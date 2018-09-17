package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_plataforma")
public class Plataforma implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_plataforma")
	private Integer id;

    @Column(name = "inv_plataforma_ancho")
    private Double PlataformaAncho;

    @Column(name = "inv_plataforma_id")
    private Double PlataformaId;

    @Column(name = "inv_plataforma_estructura")
    private String PlataformaEstructura;

    @Column(name = "inv_plataforma_tipo")
    private String PlataformaTipo;

    @Column(name = "inv_plataforma_largo")
    private Double PlataformaLargo;

	public void setPlataformaAncho(Double PlataformaAncho) {this.PlataformaAncho = PlataformaAncho;}
	public Double getPlataformaAncho() {return PlataformaAncho;}
	public void setPlataformaId(Double PlataformaId) {this.PlataformaId = PlataformaId;}
	public Double getPlataformaId() {return PlataformaId;}
	public void setPlataformaEstructura(String PlataformaEstructura) {this.PlataformaEstructura = PlataformaEstructura;}
	public String getPlataformaEstructura() {return PlataformaEstructura;}
	public void setPlataformaTipo(String PlataformaTipo) {this.PlataformaTipo = PlataformaTipo;}
	public String getPlataformaTipo() {return PlataformaTipo;}
	public void setPlataformaLargo(Double PlataformaLargo) {this.PlataformaLargo = PlataformaLargo;}
	public Double getPlataformaLargo() {return PlataformaLargo;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}