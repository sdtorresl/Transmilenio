package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_barreraper")
public class Barreraper implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_id_barreraper")
    private Double IdBarreraper;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_barreraper_id")
    private String BarreraperId;

    @Column(name = "inv_barreraper_tipo")
    private String BarreraperTipo;

    @Column(name = "inv_barreraper_altomenor")
    private Double BarreraperAltomenor;

    @Column(name = "inv_barreraper_altomayor")
    private Double BarreraperAltomayor;

    @Column(name = "inv_barreraper_largo")
    private Double BarreraperLargo;

    @Column(name = "inv_barreraper_distanciatubos")
    private Double BarreraperDistanciatubos;

    @Column(name = "inv_barreraper_numerotubos")
    private Double BarreraperNumerotubos;

    @Column(name = "inv_barreraper_averia")
    private Boolean BarreraperAveria;

    @Column(name = "inv_barreraper_porcentajeaveria")
    private Double BarreraperPorcentajeaveria;

    @Column(name = "inv_barreraper_desintegravigacon")
    private Boolean BarreraperDesintegravigacon;

    @Column(name = "inv_barreraper_exposicionarmaduraacero")
    private Boolean BarreraperExposicionarmaduraacero;

    @Column(name = "inv_barreraper_corrosiontubo")
    private Boolean BarreraperCorrosiontubo;

    @Column(name = "inv_barreraper_corrosiontubonumero")
    private Double BarreraperCorrosiontubonumero;

    @Column(name = "inv_barreraper_desgastepintura")
    private Boolean BarreraperDesgastepintura;

    @Column(name = "inv_barreraper_desgastepinturanumero")
    private Double BarreraperDesgastepinturanumero;

    @Column(name = "inv_barreraper_perdidatubo")
    private Boolean BarreraperPerdidatubo;

    @Column(name = "inv_barreraper_perdidatubonumero")
    private Double BarreraperPerdidatubonumero;

    @Column(name = "inv_barreraper_pandeotubo")
    private Boolean BarreraperPandeotubo;

    @Column(name = "inv_barreraper_pandeotubotubonumero")
    private Double BarreraperPandeotubotubonumero;

    @Column(name = "inv_barreraper_ubicacion")
    private String BarreraperUbicacion;

    @Column(name = "inv_barreraper_ruta_imagen")
    private String BarreraperRutaImagen;

    @Column(name = "inv_barreraper_imagen")
    private String BarreraperImagen;

	public void setIdBarreraper(Double IdBarreraper) {this.IdBarreraper = IdBarreraper;}
	public Double getIdBarreraper() {return IdBarreraper;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setBarreraperId(String BarreraperId) {this.BarreraperId = BarreraperId;}
	public String getBarreraperId() {return BarreraperId;}
	public void setBarreraperTipo(String BarreraperTipo) {this.BarreraperTipo = BarreraperTipo;}
	public String getBarreraperTipo() {return BarreraperTipo;}
	public void setBarreraperAltomenor(Double BarreraperAltomenor) {this.BarreraperAltomenor = BarreraperAltomenor;}
	public Double getBarreraperAltomenor() {return BarreraperAltomenor;}
	public void setBarreraperAltomayor(Double BarreraperAltomayor) {this.BarreraperAltomayor = BarreraperAltomayor;}
	public Double getBarreraperAltomayor() {return BarreraperAltomayor;}
	public void setBarreraperLargo(Double BarreraperLargo) {this.BarreraperLargo = BarreraperLargo;}
	public Double getBarreraperLargo() {return BarreraperLargo;}
	public void setBarreraperDistanciatubos(Double BarreraperDistanciatubos) {this.BarreraperDistanciatubos = BarreraperDistanciatubos;}
	public Double getBarreraperDistanciatubos() {return BarreraperDistanciatubos;}
	public void setBarreraperNumerotubos(Double BarreraperNumerotubos) {this.BarreraperNumerotubos = BarreraperNumerotubos;}
	public Double getBarreraperNumerotubos() {return BarreraperNumerotubos;}
	public void setBarreraperAveria(Boolean BarreraperAveria) {this.BarreraperAveria = BarreraperAveria;}
	public Boolean getBarreraperAveria() {return BarreraperAveria;}
	public void setBarreraperPorcentajeaveria(Double BarreraperPorcentajeaveria) {this.BarreraperPorcentajeaveria = BarreraperPorcentajeaveria;}
	public Double getBarreraperPorcentajeaveria() {return BarreraperPorcentajeaveria;}
	public void setBarreraperDesintegravigacon(Boolean BarreraperDesintegravigacon) {this.BarreraperDesintegravigacon = BarreraperDesintegravigacon;}
	public Boolean getBarreraperDesintegravigacon() {return BarreraperDesintegravigacon;}
	public void setBarreraperExposicionarmaduraacero(Boolean BarreraperExposicionarmaduraacero) {this.BarreraperExposicionarmaduraacero = BarreraperExposicionarmaduraacero;}
	public Boolean getBarreraperExposicionarmaduraacero() {return BarreraperExposicionarmaduraacero;}
	public void setBarreraperCorrosiontubo(Boolean BarreraperCorrosiontubo) {this.BarreraperCorrosiontubo = BarreraperCorrosiontubo;}
	public Boolean getBarreraperCorrosiontubo() {return BarreraperCorrosiontubo;}
	public void setBarreraperCorrosiontubonumero(Double BarreraperCorrosiontubonumero) {this.BarreraperCorrosiontubonumero = BarreraperCorrosiontubonumero;}
	public Double getBarreraperCorrosiontubonumero() {return BarreraperCorrosiontubonumero;}
	public void setBarreraperDesgastepintura(Boolean BarreraperDesgastepintura) {this.BarreraperDesgastepintura = BarreraperDesgastepintura;}
	public Boolean getBarreraperDesgastepintura() {return BarreraperDesgastepintura;}
	public void setBarreraperDesgastepinturanumero(Double BarreraperDesgastepinturanumero) {this.BarreraperDesgastepinturanumero = BarreraperDesgastepinturanumero;}
	public Double getBarreraperDesgastepinturanumero() {return BarreraperDesgastepinturanumero;}
	public void setBarreraperPerdidatubo(Boolean BarreraperPerdidatubo) {this.BarreraperPerdidatubo = BarreraperPerdidatubo;}
	public Boolean getBarreraperPerdidatubo() {return BarreraperPerdidatubo;}
	public void setBarreraperPerdidatubonumero(Double BarreraperPerdidatubonumero) {this.BarreraperPerdidatubonumero = BarreraperPerdidatubonumero;}
	public Double getBarreraperPerdidatubonumero() {return BarreraperPerdidatubonumero;}
	public void setBarreraperPandeotubo(Boolean BarreraperPandeotubo) {this.BarreraperPandeotubo = BarreraperPandeotubo;}
	public Boolean getBarreraperPandeotubo() {return BarreraperPandeotubo;}
	public void setBarreraperPandeotubotubonumero(Double BarreraperPandeotubotubonumero) {this.BarreraperPandeotubotubonumero = BarreraperPandeotubotubonumero;}
	public Double getBarreraperPandeotubotubonumero() {return BarreraperPandeotubotubonumero;}
	public void setBarreraperUbicacion(String BarreraperUbicacion) {this.BarreraperUbicacion = BarreraperUbicacion;}
	public String getBarreraperUbicacion() {return BarreraperUbicacion;}
	public void setBarreraperRutaImagen(String BarreraperRutaImagen) {this.BarreraperRutaImagen = BarreraperRutaImagen;}
	public String getBarreraperRutaImagen() {return BarreraperRutaImagen;}
	public void setBarreraperImagen(String BarreraperImagen) {this.BarreraperImagen = BarreraperImagen;}
	public String getBarreraperImagen() {return BarreraperImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}