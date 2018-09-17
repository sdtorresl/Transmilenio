package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_torniquete")
public class Torniquete implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_acceso")
    private Double IdAcceso;

    @Column(name = "inv_torniquete_tipo")
    private String TorniqueteTipo;

    @Column(name = "inv_torniquete_estructura_mal_estado")
    private Boolean TorniqueteEstructuraMalEstado;

    @Column(name = "inv_torniquete_sistemaelectrmalestado")
    private Boolean TorniqueteSistemaelectrmalestado;

    @Column(name = "inv_torniquete_sistemamecanicomalestado")
    private Boolean TorniqueteSistemamecanicomalestado;

    @Column(name = "inv_torniquete_corrosion")
    private Boolean TorniqueteCorrosion;

    @Column(name = "inv_torniquete_id")
    private Double TorniqueteId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_id_torniquete")
    private Double IdTorniquete;

	public void setIdAcceso(Double IdAcceso) {this.IdAcceso = IdAcceso;}
	public Double getIdAcceso() {return IdAcceso;}
	public void setTorniqueteTipo(String TorniqueteTipo) {this.TorniqueteTipo = TorniqueteTipo;}
	public String getTorniqueteTipo() {return TorniqueteTipo;}
	public void setTorniqueteEstructuraMalEstado(Boolean TorniqueteEstructuraMalEstado) {this.TorniqueteEstructuraMalEstado = TorniqueteEstructuraMalEstado;}
	public Boolean getTorniqueteEstructuraMalEstado() {return TorniqueteEstructuraMalEstado;}
	public void setTorniqueteSistemaelectrmalestado(Boolean TorniqueteSistemaelectrmalestado) {this.TorniqueteSistemaelectrmalestado = TorniqueteSistemaelectrmalestado;}
	public Boolean getTorniqueteSistemaelectrmalestado() {return TorniqueteSistemaelectrmalestado;}
	public void setTorniqueteSistemamecanicomalestado(Boolean TorniqueteSistemamecanicomalestado) {this.TorniqueteSistemamecanicomalestado = TorniqueteSistemamecanicomalestado;}
	public Boolean getTorniqueteSistemamecanicomalestado() {return TorniqueteSistemamecanicomalestado;}
	public void setTorniqueteCorrosion(Boolean TorniqueteCorrosion) {this.TorniqueteCorrosion = TorniqueteCorrosion;}
	public Boolean getTorniqueteCorrosion() {return TorniqueteCorrosion;}
	public void setTorniqueteId(Double TorniqueteId) {this.TorniqueteId = TorniqueteId;}
	public Double getTorniqueteId() {return TorniqueteId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setIdTorniquete(Double IdTorniquete) {this.IdTorniquete = IdTorniquete;}
	public Double getIdTorniquete() {return IdTorniquete;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}