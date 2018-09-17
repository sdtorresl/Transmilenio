package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_taquilla")
public class Taquilla implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id_taquilla")
	private Integer id;

    @Column(name = "inv_taquilla_imagen")
    private String TaquillaImagen;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_taquilla_id")
    private Double TaquillaId;

    @Column(name = "inv_taquilla_costado")
    private String TaquillaCostado;

    @Column(name = "inv_taquilla_punto")
    private Double TaquillaPunto;

    @Column(name = "inv_taquilla_area")
    private Double TaquillaArea;

    @Column(name = "inv_taquilla_orientador")
    private Boolean TaquillaOrientador;

    @Column(name = "inv_taquilla_orientadormetro")
    private Double TaquillaOrientadormetro;

    @Column(name = "inv_taquilla_acomuladorbasura")
    private Boolean TaquillaAcomuladorbasura;

    @Column(name = "inv_taquilla_deterioro")
    private Boolean TaquillaDeterioro;

    @Column(name = "inv_taquilla_corrosion")
    private Boolean TaquillaCorrosion;

    @Column(name = "inv_taquilla_filtrasion")
    private Boolean TaquillaFiltrasion;

    @Column(name = "inv_taquilla_contaminacion")
    private Boolean TaquillaContaminacion;

    @Column(name = "inv_taquilla_sinluminacion")
    private Boolean TaquillaSinluminacion;

    @Column(name = "inv_taquilla_perdidaelementos")
    private Boolean TaquillaPerdidaelementos;

    @Column(name = "inv_taquilla_vidrioroto")
    private Boolean TaquillaVidrioroto;

    @Column(name = "inv_taquilla_tipo")
    private String TaquillaTipo;

    @Column(name = "inv_taquilla_ruta_imagen")
    private String TaquillaRutaImagen;

	public void setTaquillaImagen(String TaquillaImagen) {this.TaquillaImagen = TaquillaImagen;}
	public String getTaquillaImagen() {return TaquillaImagen;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setTaquillaId(Double TaquillaId) {this.TaquillaId = TaquillaId;}
	public Double getTaquillaId() {return TaquillaId;}
	public void setTaquillaCostado(String TaquillaCostado) {this.TaquillaCostado = TaquillaCostado;}
	public String getTaquillaCostado() {return TaquillaCostado;}
	public void setTaquillaPunto(Double TaquillaPunto) {this.TaquillaPunto = TaquillaPunto;}
	public Double getTaquillaPunto() {return TaquillaPunto;}
	public void setTaquillaArea(Double TaquillaArea) {this.TaquillaArea = TaquillaArea;}
	public Double getTaquillaArea() {return TaquillaArea;}
	public void setTaquillaOrientador(Boolean TaquillaOrientador) {this.TaquillaOrientador = TaquillaOrientador;}
	public Boolean getTaquillaOrientador() {return TaquillaOrientador;}
	public void setTaquillaOrientadormetro(Double TaquillaOrientadormetro) {this.TaquillaOrientadormetro = TaquillaOrientadormetro;}
	public Double getTaquillaOrientadormetro() {return TaquillaOrientadormetro;}
	public void setTaquillaAcomuladorbasura(Boolean TaquillaAcomuladorbasura) {this.TaquillaAcomuladorbasura = TaquillaAcomuladorbasura;}
	public Boolean getTaquillaAcomuladorbasura() {return TaquillaAcomuladorbasura;}
	public void setTaquillaDeterioro(Boolean TaquillaDeterioro) {this.TaquillaDeterioro = TaquillaDeterioro;}
	public Boolean getTaquillaDeterioro() {return TaquillaDeterioro;}
	public void setTaquillaCorrosion(Boolean TaquillaCorrosion) {this.TaquillaCorrosion = TaquillaCorrosion;}
	public Boolean getTaquillaCorrosion() {return TaquillaCorrosion;}
	public void setTaquillaFiltrasion(Boolean TaquillaFiltrasion) {this.TaquillaFiltrasion = TaquillaFiltrasion;}
	public Boolean getTaquillaFiltrasion() {return TaquillaFiltrasion;}
	public void setTaquillaContaminacion(Boolean TaquillaContaminacion) {this.TaquillaContaminacion = TaquillaContaminacion;}
	public Boolean getTaquillaContaminacion() {return TaquillaContaminacion;}
	public void setTaquillaSinluminacion(Boolean TaquillaSinluminacion) {this.TaquillaSinluminacion = TaquillaSinluminacion;}
	public Boolean getTaquillaSinluminacion() {return TaquillaSinluminacion;}
	public void setTaquillaPerdidaelementos(Boolean TaquillaPerdidaelementos) {this.TaquillaPerdidaelementos = TaquillaPerdidaelementos;}
	public Boolean getTaquillaPerdidaelementos() {return TaquillaPerdidaelementos;}
	public void setTaquillaVidrioroto(Boolean TaquillaVidrioroto) {this.TaquillaVidrioroto = TaquillaVidrioroto;}
	public Boolean getTaquillaVidrioroto() {return TaquillaVidrioroto;}
	public void setTaquillaTipo(String TaquillaTipo) {this.TaquillaTipo = TaquillaTipo;}
	public String getTaquillaTipo() {return TaquillaTipo;}
	public void setTaquillaRutaImagen(String TaquillaRutaImagen) {this.TaquillaRutaImagen = TaquillaRutaImagen;}
	public String getTaquillaRutaImagen() {return TaquillaRutaImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}