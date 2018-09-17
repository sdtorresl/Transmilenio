package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_bano")
public class Bano implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_bano_baldosfisurada")
    private Boolean BanoBaldosfisurada;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_bano_id")
    private Double BanoId;

    @Column(name = "inv_bano_area")
    private Double BanoArea;

    @Column(name = "inv_bano_sanitarios")
    private Double BanoSanitarios;

    @Column(name = "inv_bano_lavamanos")
    private Boolean BanoLavamanos;

    @Column(name = "inv_bano_espejos")
    private Double BanoEspejos;

    @Column(name = "inv_bano_averia")
    private Boolean BanoAveria;

    @Column(name = "inv_bano_porcentajeaveria")
    private Double BanoPorcentajeaveria;

    @Column(name = "inv_bano_enservicio")
    private Boolean BanoEnservicio;

    @Column(name = "inv_bano_espejo_roto")
    private Boolean BanoEspejoRoto;

    @Column(name = "inv_bano_sinservicioinodoro")
    private Boolean BanoSinservicioinodoro;

    @Column(name = "inv_bano_orinales")
    private Integer BanoOrinales;

    @Column(name = "inv_bano_sinservicioorinal")
    private Boolean BanoSinservicioorinal;

    @Column(name = "inv_bano_ruta_imagen")
    private String BanoRutaImagen;

    @Column(name = "inv_bano_imagen")
    private String BanoImagen;

	public void setBanoBaldosfisurada(Boolean BanoBaldosfisurada) {this.BanoBaldosfisurada = BanoBaldosfisurada;}
	public Boolean getBanoBaldosfisurada() {return BanoBaldosfisurada;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setBanoId(Double BanoId) {this.BanoId = BanoId;}
	public Double getBanoId() {return BanoId;}
	public void setBanoArea(Double BanoArea) {this.BanoArea = BanoArea;}
	public Double getBanoArea() {return BanoArea;}
	public void setBanoSanitarios(Double BanoSanitarios) {this.BanoSanitarios = BanoSanitarios;}
	public Double getBanoSanitarios() {return BanoSanitarios;}
	public void setBanoLavamanos(Boolean BanoLavamanos) {this.BanoLavamanos = BanoLavamanos;}
	public Boolean getBanoLavamanos() {return BanoLavamanos;}
	public void setBanoEspejos(Double BanoEspejos) {this.BanoEspejos = BanoEspejos;}
	public Double getBanoEspejos() {return BanoEspejos;}
	public void setBanoAveria(Boolean BanoAveria) {this.BanoAveria = BanoAveria;}
	public Boolean getBanoAveria() {return BanoAveria;}
	public void setBanoPorcentajeaveria(Double BanoPorcentajeaveria) {this.BanoPorcentajeaveria = BanoPorcentajeaveria;}
	public Double getBanoPorcentajeaveria() {return BanoPorcentajeaveria;}
	public void setBanoEnservicio(Boolean BanoEnservicio) {this.BanoEnservicio = BanoEnservicio;}
	public Boolean getBanoEnservicio() {return BanoEnservicio;}
	public void setBanoEspejoRoto(Boolean BanoEspejoRoto) {this.BanoEspejoRoto = BanoEspejoRoto;}
	public Boolean getBanoEspejoRoto() {return BanoEspejoRoto;}
	public void setBanoSinservicioinodoro(Boolean BanoSinservicioinodoro) {this.BanoSinservicioinodoro = BanoSinservicioinodoro;}
	public Boolean getBanoSinservicioinodoro() {return BanoSinservicioinodoro;}
	public void setBanoOrinales(Integer BanoOrinales) {this.BanoOrinales = BanoOrinales;}
	public Integer getBanoOrinales() {return BanoOrinales;}
	public void setBanoSinservicioorinal(Boolean BanoSinservicioorinal) {this.BanoSinservicioorinal = BanoSinservicioorinal;}
	public Boolean getBanoSinservicioorinal() {return BanoSinservicioorinal;}
	public void setBanoRutaImagen(String BanoRutaImagen) {this.BanoRutaImagen = BanoRutaImagen;}
	public String getBanoRutaImagen() {return BanoRutaImagen;}
	public void setBanoImagen(String BanoImagen) {this.BanoImagen = BanoImagen;}
	public String getBanoImagen() {return BanoImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}