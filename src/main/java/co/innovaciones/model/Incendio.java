package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_incendio")
public class Incendio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_incendio_hachaperdida")
    private Boolean IncendioHachaperdida;

    @Column(name = "inv_incendio_martilloroto")
    private Boolean IncendioMartilloroto;

    @Column(name = "inv_incendio_martilloperdido")
    private Boolean IncendioMartilloperdido;

    @Column(name = "inv_incendio_vidrioroto")
    private Boolean IncendioVidrioroto;

    @Column(name = "inv_incendio_id")
    private Double IncendioId;

    @Column(name = "inv_incendio_alto")
    private Double IncendioAlto;

    @Column(name = "inv_incendio_ancho")
    private Double IncendioAncho;

    @Column(name = "inv_incendio_costado")
    private String IncendioCostado;

    @Column(name = "inv_incendio_tipo")
    private String IncendioTipo;

    @Column(name = "inv_incendio_extintorvencido")
    private Boolean IncendioExtintorvencido;

    @Column(name = "inv_incendio_extintorperdido")
    private Boolean IncendioExtintorperdido;

    @Column(name = "inv_incendio_manguerarota")
    private Boolean IncendioManguerarota;

    @Column(name = "inv_incendio_mangueraperdida")
    private Boolean IncendioMangueraperdida;

    @Column(name = "inv_incendio_hacharota")
    private Boolean IncendioHacharota;

    @Column(name = "inv_incendio_imagen")
    private String IncendioImagen;

    @Column(name = "inv_incendio_ruta_imagen")
    private String IncendioRutaImagen;

    @Column(name = "inv_incendio_agua")
    private Boolean IncendioAgua;

    @Column(name = "inv_incendio_vidriofaltante")
    private Boolean IncendioVidriofaltante;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

	public void setIncendioHachaperdida(Boolean IncendioHachaperdida) {this.IncendioHachaperdida = IncendioHachaperdida;}
	public Boolean getIncendioHachaperdida() {return IncendioHachaperdida;}
	public void setIncendioMartilloroto(Boolean IncendioMartilloroto) {this.IncendioMartilloroto = IncendioMartilloroto;}
	public Boolean getIncendioMartilloroto() {return IncendioMartilloroto;}
	public void setIncendioMartilloperdido(Boolean IncendioMartilloperdido) {this.IncendioMartilloperdido = IncendioMartilloperdido;}
	public Boolean getIncendioMartilloperdido() {return IncendioMartilloperdido;}
	public void setIncendioVidrioroto(Boolean IncendioVidrioroto) {this.IncendioVidrioroto = IncendioVidrioroto;}
	public Boolean getIncendioVidrioroto() {return IncendioVidrioroto;}
	public void setIncendioId(Double IncendioId) {this.IncendioId = IncendioId;}
	public Double getIncendioId() {return IncendioId;}
	public void setIncendioAlto(Double IncendioAlto) {this.IncendioAlto = IncendioAlto;}
	public Double getIncendioAlto() {return IncendioAlto;}
	public void setIncendioAncho(Double IncendioAncho) {this.IncendioAncho = IncendioAncho;}
	public Double getIncendioAncho() {return IncendioAncho;}
	public void setIncendioCostado(String IncendioCostado) {this.IncendioCostado = IncendioCostado;}
	public String getIncendioCostado() {return IncendioCostado;}
	public void setIncendioTipo(String IncendioTipo) {this.IncendioTipo = IncendioTipo;}
	public String getIncendioTipo() {return IncendioTipo;}
	public void setIncendioExtintorvencido(Boolean IncendioExtintorvencido) {this.IncendioExtintorvencido = IncendioExtintorvencido;}
	public Boolean getIncendioExtintorvencido() {return IncendioExtintorvencido;}
	public void setIncendioExtintorperdido(Boolean IncendioExtintorperdido) {this.IncendioExtintorperdido = IncendioExtintorperdido;}
	public Boolean getIncendioExtintorperdido() {return IncendioExtintorperdido;}
	public void setIncendioManguerarota(Boolean IncendioManguerarota) {this.IncendioManguerarota = IncendioManguerarota;}
	public Boolean getIncendioManguerarota() {return IncendioManguerarota;}
	public void setIncendioMangueraperdida(Boolean IncendioMangueraperdida) {this.IncendioMangueraperdida = IncendioMangueraperdida;}
	public Boolean getIncendioMangueraperdida() {return IncendioMangueraperdida;}
	public void setIncendioHacharota(Boolean IncendioHacharota) {this.IncendioHacharota = IncendioHacharota;}
	public Boolean getIncendioHacharota() {return IncendioHacharota;}
	public void setIncendioImagen(String IncendioImagen) {this.IncendioImagen = IncendioImagen;}
	public String getIncendioImagen() {return IncendioImagen;}
	public void setIncendioRutaImagen(String IncendioRutaImagen) {this.IncendioRutaImagen = IncendioRutaImagen;}
	public String getIncendioRutaImagen() {return IncendioRutaImagen;}
	public void setIncendioAgua(Boolean IncendioAgua) {this.IncendioAgua = IncendioAgua;}
	public Boolean getIncendioAgua() {return IncendioAgua;}
	public void setIncendioVidriofaltante(Boolean IncendioVidriofaltante) {this.IncendioVidriofaltante = IncendioVidriofaltante;}
	public Boolean getIncendioVidriofaltante() {return IncendioVidriofaltante;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}