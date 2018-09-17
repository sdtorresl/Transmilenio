package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_subestacion")
public class Subestacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_subestacion_nominalfusible")
    private Double SubestacionNominalfusible;

    @Column(name = "inv_subestacion_nominal")
    private Double SubestacionNominal;

    @Column(name = "inv_subestacion_aislamiento")
    private Double SubestacionAislamiento;

    @Column(name = "inv_subestacion_transforsecundario")
    private Double SubestacionTransforsecundario;

    @Column(name = "inv_subestacion_transforprimario")
    private Double SubestacionTransforprimario;

    @Column(name = "inv_subestacion_transfornumero")
    private Double SubestacionTransfornumero;

    @Column(name = "inv_subestacion_transforpotencia")
    private Double SubestacionTransforpotencia;

    @Column(name = "inv_subestacion_cablederretido")
    private Boolean SubestacionCablederretido;

    @Column(name = "inv_subestacion_gabinetecorrosionarea")
    private Double SubestacionGabinetecorrosionarea;

    @Column(name = "inv_id_subestacion")
    private Double IdSubestacion;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_subestacion_id")
    private Double SubestacionId;

    @Column(name = "inv_subestacion_potencia")
    private String SubestacionPotencia;

    @Column(name = "inv_subestacion_transformacion")
    private String SubestacionTransformacion;

    @Column(name = "inv_subestacion_ubicacion")
    private String SubestacionUbicacion;

    @Column(name = "inv_subestacion_averia")
    private Boolean SubestacionAveria;

    @Column(name = "inv_subestacion_imagen")
    private String SubestacionImagen;

    @Column(name = "inv_subestacion_gabinetecorrosion")
    private Boolean SubestacionGabinetecorrosion;

    @Column(name = "inv_subestacion_ruta_imagen")
    private String SubestacionRutaImagen;

	public void setSubestacionNominalfusible(Double SubestacionNominalfusible) {this.SubestacionNominalfusible = SubestacionNominalfusible;}
	public Double getSubestacionNominalfusible() {return SubestacionNominalfusible;}
	public void setSubestacionNominal(Double SubestacionNominal) {this.SubestacionNominal = SubestacionNominal;}
	public Double getSubestacionNominal() {return SubestacionNominal;}
	public void setSubestacionAislamiento(Double SubestacionAislamiento) {this.SubestacionAislamiento = SubestacionAislamiento;}
	public Double getSubestacionAislamiento() {return SubestacionAislamiento;}
	public void setSubestacionTransforsecundario(Double SubestacionTransforsecundario) {this.SubestacionTransforsecundario = SubestacionTransforsecundario;}
	public Double getSubestacionTransforsecundario() {return SubestacionTransforsecundario;}
	public void setSubestacionTransforprimario(Double SubestacionTransforprimario) {this.SubestacionTransforprimario = SubestacionTransforprimario;}
	public Double getSubestacionTransforprimario() {return SubestacionTransforprimario;}
	public void setSubestacionTransfornumero(Double SubestacionTransfornumero) {this.SubestacionTransfornumero = SubestacionTransfornumero;}
	public Double getSubestacionTransfornumero() {return SubestacionTransfornumero;}
	public void setSubestacionTransforpotencia(Double SubestacionTransforpotencia) {this.SubestacionTransforpotencia = SubestacionTransforpotencia;}
	public Double getSubestacionTransforpotencia() {return SubestacionTransforpotencia;}
	public void setSubestacionCablederretido(Boolean SubestacionCablederretido) {this.SubestacionCablederretido = SubestacionCablederretido;}
	public Boolean getSubestacionCablederretido() {return SubestacionCablederretido;}
	public void setSubestacionGabinetecorrosionarea(Double SubestacionGabinetecorrosionarea) {this.SubestacionGabinetecorrosionarea = SubestacionGabinetecorrosionarea;}
	public Double getSubestacionGabinetecorrosionarea() {return SubestacionGabinetecorrosionarea;}
	public void setIdSubestacion(Double IdSubestacion) {this.IdSubestacion = IdSubestacion;}
	public Double getIdSubestacion() {return IdSubestacion;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setSubestacionId(Double SubestacionId) {this.SubestacionId = SubestacionId;}
	public Double getSubestacionId() {return SubestacionId;}
	public void setSubestacionPotencia(String SubestacionPotencia) {this.SubestacionPotencia = SubestacionPotencia;}
	public String getSubestacionPotencia() {return SubestacionPotencia;}
	public void setSubestacionTransformacion(String SubestacionTransformacion) {this.SubestacionTransformacion = SubestacionTransformacion;}
	public String getSubestacionTransformacion() {return SubestacionTransformacion;}
	public void setSubestacionUbicacion(String SubestacionUbicacion) {this.SubestacionUbicacion = SubestacionUbicacion;}
	public String getSubestacionUbicacion() {return SubestacionUbicacion;}
	public void setSubestacionAveria(Boolean SubestacionAveria) {this.SubestacionAveria = SubestacionAveria;}
	public Boolean getSubestacionAveria() {return SubestacionAveria;}
	public void setSubestacionImagen(String SubestacionImagen) {this.SubestacionImagen = SubestacionImagen;}
	public String getSubestacionImagen() {return SubestacionImagen;}
	public void setSubestacionGabinetecorrosion(Boolean SubestacionGabinetecorrosion) {this.SubestacionGabinetecorrosion = SubestacionGabinetecorrosion;}
	public Boolean getSubestacionGabinetecorrosion() {return SubestacionGabinetecorrosion;}
	public void setSubestacionRutaImagen(String SubestacionRutaImagen) {this.SubestacionRutaImagen = SubestacionRutaImagen;}
	public String getSubestacionRutaImagen() {return SubestacionRutaImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}