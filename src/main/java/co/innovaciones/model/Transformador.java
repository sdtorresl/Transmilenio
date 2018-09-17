package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_transformador")
public class Transformador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_transformador")
	private Integer id;

    @Column(name = "inv_transformador_cablederretido")
    private Boolean TransformadorCablederretido;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_transformador_id")
    private Double TransformadorId;

    @Column(name = "inv_transformador_potencia")
    private Double TransformadorPotencia;

    @Column(name = "inv_transformador_primario")
    private Double TransformadorPrimario;

    @Column(name = "inv_transformador_secundario")
    private Double TransformadorSecundario;

    @Column(name = "inv_transformador_ubicacion")
    private String TransformadorUbicacion;

    @Column(name = "inv_transformador_averia")
    private Boolean TransformadorAveria;

    @Column(name = "inv_transformador_gabinetecorrosion")
    private Boolean TransformadorGabinetecorrosion;

    @Column(name = "inv_transformador_gabinetecorrosionarea")
    private Double TransformadorGabinetecorrosionarea;

    @Column(name = "inv_transformador_imagen")
    private String TransformadorImagen;

	public void setTransformadorCablederretido(Boolean TransformadorCablederretido) {this.TransformadorCablederretido = TransformadorCablederretido;}
	public Boolean getTransformadorCablederretido() {return TransformadorCablederretido;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setTransformadorId(Double TransformadorId) {this.TransformadorId = TransformadorId;}
	public Double getTransformadorId() {return TransformadorId;}
	public void setTransformadorPotencia(Double TransformadorPotencia) {this.TransformadorPotencia = TransformadorPotencia;}
	public Double getTransformadorPotencia() {return TransformadorPotencia;}
	public void setTransformadorPrimario(Double TransformadorPrimario) {this.TransformadorPrimario = TransformadorPrimario;}
	public Double getTransformadorPrimario() {return TransformadorPrimario;}
	public void setTransformadorSecundario(Double TransformadorSecundario) {this.TransformadorSecundario = TransformadorSecundario;}
	public Double getTransformadorSecundario() {return TransformadorSecundario;}
	public void setTransformadorUbicacion(String TransformadorUbicacion) {this.TransformadorUbicacion = TransformadorUbicacion;}
	public String getTransformadorUbicacion() {return TransformadorUbicacion;}
	public void setTransformadorAveria(Boolean TransformadorAveria) {this.TransformadorAveria = TransformadorAveria;}
	public Boolean getTransformadorAveria() {return TransformadorAveria;}
	public void setTransformadorGabinetecorrosion(Boolean TransformadorGabinetecorrosion) {this.TransformadorGabinetecorrosion = TransformadorGabinetecorrosion;}
	public Boolean getTransformadorGabinetecorrosion() {return TransformadorGabinetecorrosion;}
	public void setTransformadorGabinetecorrosionarea(Double TransformadorGabinetecorrosionarea) {this.TransformadorGabinetecorrosionarea = TransformadorGabinetecorrosionarea;}
	public Double getTransformadorGabinetecorrosionarea() {return TransformadorGabinetecorrosionarea;}
	public void setTransformadorImagen(String TransformadorImagen) {this.TransformadorImagen = TransformadorImagen;}
	public String getTransformadorImagen() {return TransformadorImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}