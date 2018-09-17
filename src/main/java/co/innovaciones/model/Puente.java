package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_puente")
public class Puente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_puente")
	private Integer id;

    @Column(name = "inv_puente_porcentajetablero")
    private Double PuentePorcentajetablero;

    @Column(name = "inv_puente_ruta_imagen")
    private String PuenteRutaImagen;

    @Column(name = "inv_puente_imagen")
    private String PuenteImagen;

    @Column(name = "inv_puente_porcentajepasamanos")
    private Double PuentePorcentajepasamanos;

    @Column(name = "inv_puente_averiapasamanos")
    private Boolean PuenteAveriapasamanos;

    @Column(name = "inv_puente_materialtablero")
    private String PuenteMaterialtablero;

    @Column(name = "inv_puente_ancho")
    private Double PuenteAncho;

    @Column(name = "inv_puente_longitud")
    private Double PuenteLongitud;

    @Column(name = "inv_puente_buenmovilidadreducida")
    private Boolean PuenteBuenmovilidadreducida;

    @Column(name = "inv_puente_rampatipo")
    private String PuenteRampatipo;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_puente_id")
    private Double PuenteId;

    @Column(name = "inv_id_tipopuente")
    private String IdTipopuente;

    @Column(name = "inv_puente_numeroascensor")
    private Double PuenteNumeroascensor;

    @Column(name = "inv_puente_numeroescalera")
    private Double PuenteNumeroescalera;

    @Column(name = "inv_id_tipoescalera")
    private String IdTipoescalera;

    @Column(name = "inv_puente_numerorampa")
    private Double PuenteNumerorampa;

    @Column(name = "inv_puente_averiatablero")
    private Boolean PuenteAveriatablero;

	public void setPuentePorcentajetablero(Double PuentePorcentajetablero) {this.PuentePorcentajetablero = PuentePorcentajetablero;}
	public Double getPuentePorcentajetablero() {return PuentePorcentajetablero;}
	public void setPuenteRutaImagen(String PuenteRutaImagen) {this.PuenteRutaImagen = PuenteRutaImagen;}
	public String getPuenteRutaImagen() {return PuenteRutaImagen;}
	public void setPuenteImagen(String PuenteImagen) {this.PuenteImagen = PuenteImagen;}
	public String getPuenteImagen() {return PuenteImagen;}
	public void setPuentePorcentajepasamanos(Double PuentePorcentajepasamanos) {this.PuentePorcentajepasamanos = PuentePorcentajepasamanos;}
	public Double getPuentePorcentajepasamanos() {return PuentePorcentajepasamanos;}
	public void setPuenteAveriapasamanos(Boolean PuenteAveriapasamanos) {this.PuenteAveriapasamanos = PuenteAveriapasamanos;}
	public Boolean getPuenteAveriapasamanos() {return PuenteAveriapasamanos;}
	public void setPuenteMaterialtablero(String PuenteMaterialtablero) {this.PuenteMaterialtablero = PuenteMaterialtablero;}
	public String getPuenteMaterialtablero() {return PuenteMaterialtablero;}
	public void setPuenteAncho(Double PuenteAncho) {this.PuenteAncho = PuenteAncho;}
	public Double getPuenteAncho() {return PuenteAncho;}
	public void setPuenteLongitud(Double PuenteLongitud) {this.PuenteLongitud = PuenteLongitud;}
	public Double getPuenteLongitud() {return PuenteLongitud;}
	public void setPuenteBuenmovilidadreducida(Boolean PuenteBuenmovilidadreducida) {this.PuenteBuenmovilidadreducida = PuenteBuenmovilidadreducida;}
	public Boolean getPuenteBuenmovilidadreducida() {return PuenteBuenmovilidadreducida;}
	public void setPuenteRampatipo(String PuenteRampatipo) {this.PuenteRampatipo = PuenteRampatipo;}
	public String getPuenteRampatipo() {return PuenteRampatipo;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setPuenteId(Double PuenteId) {this.PuenteId = PuenteId;}
	public Double getPuenteId() {return PuenteId;}
	public void setIdTipopuente(String IdTipopuente) {this.IdTipopuente = IdTipopuente;}
	public String getIdTipopuente() {return IdTipopuente;}
	public void setPuenteNumeroascensor(Double PuenteNumeroascensor) {this.PuenteNumeroascensor = PuenteNumeroascensor;}
	public Double getPuenteNumeroascensor() {return PuenteNumeroascensor;}
	public void setPuenteNumeroescalera(Double PuenteNumeroescalera) {this.PuenteNumeroescalera = PuenteNumeroescalera;}
	public Double getPuenteNumeroescalera() {return PuenteNumeroescalera;}
	public void setIdTipoescalera(String IdTipoescalera) {this.IdTipoescalera = IdTipoescalera;}
	public String getIdTipoescalera() {return IdTipoescalera;}
	public void setPuenteNumerorampa(Double PuenteNumerorampa) {this.PuenteNumerorampa = PuenteNumerorampa;}
	public Double getPuenteNumerorampa() {return PuenteNumerorampa;}
	public void setPuenteAveriatablero(Boolean PuenteAveriatablero) {this.PuenteAveriatablero = PuenteAveriatablero;}
	public Boolean getPuenteAveriatablero() {return PuenteAveriatablero;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}