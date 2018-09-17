package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_vidriopuerta")
public class Vidriopuerta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_vidriopuerta_peliculaseguridadaveria")
    private Boolean VidriopuertaPeliculaseguridadaveria;

    @Column(name = "inv_vidriopuerta_contaminacion")
    private Boolean VidriopuertaContaminacion;

    @Column(name = "inv_vidriopuerta_numerocontaminacion")
    private Double VidriopuertaNumerocontaminacion;

    @Column(name = "inv_id_vidriopuerta")
    private Double IdVidriopuerta;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_vidriopuerta_id")
    private Double VidriopuertaId;

    @Column(name = "inv_vidriopuerta_costado")
    private String VidriopuertaCostado;

    @Column(name = "inv_vidriopuerta_largo")
    private Double VidriopuertaLargo;

    @Column(name = "inv_vidriopuerta_ancho")
    private Double VidriopuertaAncho;

    @Column(name = "inv_vidriopuerta_averia")
    private Boolean VidriopuertaAveria;

    @Column(name = "inv_vidriopuerta_fragmentado")
    private Boolean VidriopuertaFragmentado;

    @Column(name = "inv_vidriopuerta_numerofragmentado")
    private Double VidriopuertaNumerofragmentado;

    @Column(name = "inv_vidriopuerta_peliculaidentificacion")
    private Boolean VidriopuertaPeliculaidentificacion;

    @Column(name = "inv_vidriopuerta_numeropeliculaidentificacion")
    private Double VidriopuertaNumeropeliculaidentificacion;

    @Column(name = "inv_vidriopuerta_numeropelucilaseguridadaveria")
    private Double VidriopuertaNumeropelucilaseguridadaveria;

	public void setVidriopuertaPeliculaseguridadaveria(Boolean VidriopuertaPeliculaseguridadaveria) {this.VidriopuertaPeliculaseguridadaveria = VidriopuertaPeliculaseguridadaveria;}
	public Boolean getVidriopuertaPeliculaseguridadaveria() {return VidriopuertaPeliculaseguridadaveria;}
	public void setVidriopuertaContaminacion(Boolean VidriopuertaContaminacion) {this.VidriopuertaContaminacion = VidriopuertaContaminacion;}
	public Boolean getVidriopuertaContaminacion() {return VidriopuertaContaminacion;}
	public void setVidriopuertaNumerocontaminacion(Double VidriopuertaNumerocontaminacion) {this.VidriopuertaNumerocontaminacion = VidriopuertaNumerocontaminacion;}
	public Double getVidriopuertaNumerocontaminacion() {return VidriopuertaNumerocontaminacion;}
	public void setIdVidriopuerta(Double IdVidriopuerta) {this.IdVidriopuerta = IdVidriopuerta;}
	public Double getIdVidriopuerta() {return IdVidriopuerta;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setVidriopuertaId(Double VidriopuertaId) {this.VidriopuertaId = VidriopuertaId;}
	public Double getVidriopuertaId() {return VidriopuertaId;}
	public void setVidriopuertaCostado(String VidriopuertaCostado) {this.VidriopuertaCostado = VidriopuertaCostado;}
	public String getVidriopuertaCostado() {return VidriopuertaCostado;}
	public void setVidriopuertaLargo(Double VidriopuertaLargo) {this.VidriopuertaLargo = VidriopuertaLargo;}
	public Double getVidriopuertaLargo() {return VidriopuertaLargo;}
	public void setVidriopuertaAncho(Double VidriopuertaAncho) {this.VidriopuertaAncho = VidriopuertaAncho;}
	public Double getVidriopuertaAncho() {return VidriopuertaAncho;}
	public void setVidriopuertaAveria(Boolean VidriopuertaAveria) {this.VidriopuertaAveria = VidriopuertaAveria;}
	public Boolean getVidriopuertaAveria() {return VidriopuertaAveria;}
	public void setVidriopuertaFragmentado(Boolean VidriopuertaFragmentado) {this.VidriopuertaFragmentado = VidriopuertaFragmentado;}
	public Boolean getVidriopuertaFragmentado() {return VidriopuertaFragmentado;}
	public void setVidriopuertaNumerofragmentado(Double VidriopuertaNumerofragmentado) {this.VidriopuertaNumerofragmentado = VidriopuertaNumerofragmentado;}
	public Double getVidriopuertaNumerofragmentado() {return VidriopuertaNumerofragmentado;}
	public void setVidriopuertaPeliculaidentificacion(Boolean VidriopuertaPeliculaidentificacion) {this.VidriopuertaPeliculaidentificacion = VidriopuertaPeliculaidentificacion;}
	public Boolean getVidriopuertaPeliculaidentificacion() {return VidriopuertaPeliculaidentificacion;}
	public void setVidriopuertaNumeropeliculaidentificacion(Double VidriopuertaNumeropeliculaidentificacion) {this.VidriopuertaNumeropeliculaidentificacion = VidriopuertaNumeropeliculaidentificacion;}
	public Double getVidriopuertaNumeropeliculaidentificacion() {return VidriopuertaNumeropeliculaidentificacion;}
	public void setVidriopuertaNumeropelucilaseguridadaveria(Double VidriopuertaNumeropelucilaseguridadaveria) {this.VidriopuertaNumeropelucilaseguridadaveria = VidriopuertaNumeropelucilaseguridadaveria;}
	public Double getVidriopuertaNumeropelucilaseguridadaveria() {return VidriopuertaNumeropelucilaseguridadaveria;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}