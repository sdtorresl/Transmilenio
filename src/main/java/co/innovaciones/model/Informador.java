package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_informador")
public class Informador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_informador_id")
    private Double InformadorId;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_id_informador")
    private Double IdInformador;

    @Column(name = "inv_informador_costado")
    private String InformadorCostado;

    @Column(name = "inv_informador_soporteaveria")
    private Boolean InformadorSoporteaveria;

    @Column(name = "inv_informador_porcentajeaveria")
    private Double InformadorPorcentajeaveria;

    @Column(name = "inv_informador_sinservicio")
    private Boolean InformadorSinservicio;

    @Column(name = "inv_informador_ruta_imagen")
    private String InformadorRutaImagen;

    @Column(name = "inv_informador_imagen")
    private String InformadorImagen;

    @Column(name = "inv_informador_soporte")
    private String InformadorSoporte;

	public void setInformadorId(Double InformadorId) {this.InformadorId = InformadorId;}
	public Double getInformadorId() {return InformadorId;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setIdInformador(Double IdInformador) {this.IdInformador = IdInformador;}
	public Double getIdInformador() {return IdInformador;}
	public void setInformadorCostado(String InformadorCostado) {this.InformadorCostado = InformadorCostado;}
	public String getInformadorCostado() {return InformadorCostado;}
	public void setInformadorSoporteaveria(Boolean InformadorSoporteaveria) {this.InformadorSoporteaveria = InformadorSoporteaveria;}
	public Boolean getInformadorSoporteaveria() {return InformadorSoporteaveria;}
	public void setInformadorPorcentajeaveria(Double InformadorPorcentajeaveria) {this.InformadorPorcentajeaveria = InformadorPorcentajeaveria;}
	public Double getInformadorPorcentajeaveria() {return InformadorPorcentajeaveria;}
	public void setInformadorSinservicio(Boolean InformadorSinservicio) {this.InformadorSinservicio = InformadorSinservicio;}
	public Boolean getInformadorSinservicio() {return InformadorSinservicio;}
	public void setInformadorRutaImagen(String InformadorRutaImagen) {this.InformadorRutaImagen = InformadorRutaImagen;}
	public String getInformadorRutaImagen() {return InformadorRutaImagen;}
	public void setInformadorImagen(String InformadorImagen) {this.InformadorImagen = InformadorImagen;}
	public String getInformadorImagen() {return InformadorImagen;}
	public void setInformadorSoporte(String InformadorSoporte) {this.InformadorSoporte = InformadorSoporte;}
	public String getInformadorSoporte() {return InformadorSoporte;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}