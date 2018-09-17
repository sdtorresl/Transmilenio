package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_fotoelectrica")
public class Fotoelectrica implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_fotoelectrica")
	private Integer id;

    @Column(name = "inv_fotoelectrica_ubicacion")
    private String FotoelectricaUbicacion;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_fotoelectrica_id")
    private Double FotoelectricaId;

    @Column(name = "inv_fotoelectrica_mancha")
    private Boolean FotoelectricaMancha;

    @Column(name = "inv_fotoelectrica_fisura")
    private Boolean FotoelectricaFisura;

	public void setFotoelectricaUbicacion(String FotoelectricaUbicacion) {this.FotoelectricaUbicacion = FotoelectricaUbicacion;}
	public String getFotoelectricaUbicacion() {return FotoelectricaUbicacion;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setFotoelectricaId(Double FotoelectricaId) {this.FotoelectricaId = FotoelectricaId;}
	public Double getFotoelectricaId() {return FotoelectricaId;}
	public void setFotoelectricaMancha(Boolean FotoelectricaMancha) {this.FotoelectricaMancha = FotoelectricaMancha;}
	public Boolean getFotoelectricaMancha() {return FotoelectricaMancha;}
	public void setFotoelectricaFisura(Boolean FotoelectricaFisura) {this.FotoelectricaFisura = FotoelectricaFisura;}
	public Boolean getFotoelectricaFisura() {return FotoelectricaFisura;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}