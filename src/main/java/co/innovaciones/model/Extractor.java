package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_extractor")
public class Extractor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_extractor")
	private Integer id;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_extractor_id")
    private Double ExtractorId;

    @Column(name = "inv_extractor_ubicacion")
    private String ExtractorUbicacion;

    @Column(name = "inv_extractor_corrosion")
    private Boolean ExtractorCorrosion;

    @Column(name = "inv_extractor_sinservicio")
    private Boolean ExtractorSinservicio;

	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setExtractorId(Double ExtractorId) {this.ExtractorId = ExtractorId;}
	public Double getExtractorId() {return ExtractorId;}
	public void setExtractorUbicacion(String ExtractorUbicacion) {this.ExtractorUbicacion = ExtractorUbicacion;}
	public String getExtractorUbicacion() {return ExtractorUbicacion;}
	public void setExtractorCorrosion(Boolean ExtractorCorrosion) {this.ExtractorCorrosion = ExtractorCorrosion;}
	public Boolean getExtractorCorrosion() {return ExtractorCorrosion;}
	public void setExtractorSinservicio(Boolean ExtractorSinservicio) {this.ExtractorSinservicio = ExtractorSinservicio;}
	public Boolean getExtractorSinservicio() {return ExtractorSinservicio;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}