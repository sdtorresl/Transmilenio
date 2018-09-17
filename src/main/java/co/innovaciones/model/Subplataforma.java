package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_subplataforma")
public class Subplataforma implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_subplataforma_largo")
    private Double SubplataformaLargo;

    @Column(name = "inv_subplataforma_tipo")
    private String SubplataformaTipo;

    @Column(name = "inv_subplataforma_tipouso")
    private String SubplataformaTipouso;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_subplataforma_ancho")
    private Double SubplataformaAncho;

	public void setSubplataformaLargo(Double SubplataformaLargo) {this.SubplataformaLargo = SubplataformaLargo;}
	public Double getSubplataformaLargo() {return SubplataformaLargo;}
	public void setSubplataformaTipo(String SubplataformaTipo) {this.SubplataformaTipo = SubplataformaTipo;}
	public String getSubplataformaTipo() {return SubplataformaTipo;}
	public void setSubplataformaTipouso(String SubplataformaTipouso) {this.SubplataformaTipouso = SubplataformaTipouso;}
	public String getSubplataformaTipouso() {return SubplataformaTipouso;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setSubplataformaAncho(Double SubplataformaAncho) {this.SubplataformaAncho = SubplataformaAncho;}
	public Double getSubplataformaAncho() {return SubplataformaAncho;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}