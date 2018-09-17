package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_elevadora")
public class Elevadora implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_elevadora_porcentajefisura")
    private Double ElevadoraPorcentajefisura;

    @Column(name = "inv_id_elevadora")
    private Double IdElevadora;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_elevadora_id")
    private Double ElevadoraId;

    @Column(name = "inv_elevadora_ubicacion")
    private String ElevadoraUbicacion;

    @Column(name = "inv_elevadora_averia")
    private Boolean ElevadoraAveria;

    @Column(name = "inv_elevadora_sinservicio")
    private Boolean ElevadoraSinservicio;

    @Column(name = "inv_elevadora_contaminacion")
    private Boolean ElevadoraContaminacion;

    @Column(name = "inv_elevadora_fisura")
    private Boolean ElevadoraFisura;

    @Column(name = "inv_elevadora_ruta_imagen")
    private String ElevadoraRutaImagen;

    @Column(name = "inv_elevadora_imagen")
    private String ElevadoraImagen;

	public void setElevadoraPorcentajefisura(Double ElevadoraPorcentajefisura) {this.ElevadoraPorcentajefisura = ElevadoraPorcentajefisura;}
	public Double getElevadoraPorcentajefisura() {return ElevadoraPorcentajefisura;}
	public void setIdElevadora(Double IdElevadora) {this.IdElevadora = IdElevadora;}
	public Double getIdElevadora() {return IdElevadora;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setElevadoraId(Double ElevadoraId) {this.ElevadoraId = ElevadoraId;}
	public Double getElevadoraId() {return ElevadoraId;}
	public void setElevadoraUbicacion(String ElevadoraUbicacion) {this.ElevadoraUbicacion = ElevadoraUbicacion;}
	public String getElevadoraUbicacion() {return ElevadoraUbicacion;}
	public void setElevadoraAveria(Boolean ElevadoraAveria) {this.ElevadoraAveria = ElevadoraAveria;}
	public Boolean getElevadoraAveria() {return ElevadoraAveria;}
	public void setElevadoraSinservicio(Boolean ElevadoraSinservicio) {this.ElevadoraSinservicio = ElevadoraSinservicio;}
	public Boolean getElevadoraSinservicio() {return ElevadoraSinservicio;}
	public void setElevadoraContaminacion(Boolean ElevadoraContaminacion) {this.ElevadoraContaminacion = ElevadoraContaminacion;}
	public Boolean getElevadoraContaminacion() {return ElevadoraContaminacion;}
	public void setElevadoraFisura(Boolean ElevadoraFisura) {this.ElevadoraFisura = ElevadoraFisura;}
	public Boolean getElevadoraFisura() {return ElevadoraFisura;}
	public void setElevadoraRutaImagen(String ElevadoraRutaImagen) {this.ElevadoraRutaImagen = ElevadoraRutaImagen;}
	public String getElevadoraRutaImagen() {return ElevadoraRutaImagen;}
	public void setElevadoraImagen(String ElevadoraImagen) {this.ElevadoraImagen = ElevadoraImagen;}
	public String getElevadoraImagen() {return ElevadoraImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}