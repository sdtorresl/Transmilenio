package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_medidor")
public class Medidor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_medidor_averia")
    private Boolean MedidorAveria;

    @Column(name = "inv_medidor_cablederretido")
    private Boolean MedidorCablederretido;

    @Column(name = "inv_medidor_gabinetecerradura")
    private Boolean MedidorGabinetecerradura;

    @Column(name = "inv_medidor_serial")
    private String MedidorSerial;

    @Column(name = "inv_medidor_propietario")
    private String MedidorPropietario;

    @Column(name = "inv_medidor_tipo")
    private String MedidorTipo;

    @Column(name = "inv_medidor_gabinetepintura")
    private Boolean MedidorGabinetepintura;

    @Column(name = "inv_medidor_gabinetecorrosion")
    private Boolean MedidorGabinetecorrosion;

    @Column(name = "inv_medidor_imagen")
    private String MedidorImagen;

    @Column(name = "inv_medidor_gabinetesucio")
    private Boolean MedidorGabinetesucio;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_medidor_id")
    private Double MedidorId;

    @Column(name = "inv_medidor_ruta_imagen")
    private String MedidorRutaImagen;

	public void setMedidorAveria(Boolean MedidorAveria) {this.MedidorAveria = MedidorAveria;}
	public Boolean getMedidorAveria() {return MedidorAveria;}
	public void setMedidorCablederretido(Boolean MedidorCablederretido) {this.MedidorCablederretido = MedidorCablederretido;}
	public Boolean getMedidorCablederretido() {return MedidorCablederretido;}
	public void setMedidorGabinetecerradura(Boolean MedidorGabinetecerradura) {this.MedidorGabinetecerradura = MedidorGabinetecerradura;}
	public Boolean getMedidorGabinetecerradura() {return MedidorGabinetecerradura;}
	public void setMedidorSerial(String MedidorSerial) {this.MedidorSerial = MedidorSerial;}
	public String getMedidorSerial() {return MedidorSerial;}
	public void setMedidorPropietario(String MedidorPropietario) {this.MedidorPropietario = MedidorPropietario;}
	public String getMedidorPropietario() {return MedidorPropietario;}
	public void setMedidorTipo(String MedidorTipo) {this.MedidorTipo = MedidorTipo;}
	public String getMedidorTipo() {return MedidorTipo;}
	public void setMedidorGabinetepintura(Boolean MedidorGabinetepintura) {this.MedidorGabinetepintura = MedidorGabinetepintura;}
	public Boolean getMedidorGabinetepintura() {return MedidorGabinetepintura;}
	public void setMedidorGabinetecorrosion(Boolean MedidorGabinetecorrosion) {this.MedidorGabinetecorrosion = MedidorGabinetecorrosion;}
	public Boolean getMedidorGabinetecorrosion() {return MedidorGabinetecorrosion;}
	public void setMedidorImagen(String MedidorImagen) {this.MedidorImagen = MedidorImagen;}
	public String getMedidorImagen() {return MedidorImagen;}
	public void setMedidorGabinetesucio(Boolean MedidorGabinetesucio) {this.MedidorGabinetesucio = MedidorGabinetesucio;}
	public Boolean getMedidorGabinetesucio() {return MedidorGabinetesucio;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setMedidorId(Double MedidorId) {this.MedidorId = MedidorId;}
	public Double getMedidorId() {return MedidorId;}
	public void setMedidorRutaImagen(String MedidorRutaImagen) {this.MedidorRutaImagen = MedidorRutaImagen;}
	public String getMedidorRutaImagen() {return MedidorRutaImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}