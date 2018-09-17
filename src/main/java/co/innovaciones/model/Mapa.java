package co.innovaciones.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "inv_mapa")
public class Mapa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "inv_mapa_imagen")
    private String MapaImagen;

    @Column(name = "inv_id_seccionestacion")
    private Double IdSeccionestacion;

    @Column(name = "inv_mapa_id")
    private Double MapaId;

    @Column(name = "inv_mapa_alto")
    private Double MapaAlto;

    @Column(name = "inv_mapa_ancho")
    private Double MapaAncho;

    @Column(name = "inv_mapa_costado")
    private String MapaCostado;

    @Column(name = "inv_mapa_placamalestado")
    private Boolean MapaPlacamalestado;

    @Column(name = "inv_mapa_placaperdidaelemento")
    private Boolean MapaPlacaperdidaelemento;

    @Column(name = "inv_mapa_placalegible")
    private Boolean MapaPlacalegible;

    @Column(name = "inv_mapa_esquemaaveria")
    private Boolean MapaEsquemaaveria;

    @Column(name = "inv_mapa_esquemacontaminacion")
    private Boolean MapaEsquemacontaminacion;

    @Column(name = "inv_mapa_esquemalegible")
    private Boolean MapaEsquemalegible;

    @Column(name = "inv_mapa_ruta_imagen")
    private String MapaRutaImagen;

	public void setMapaImagen(String MapaImagen) {this.MapaImagen = MapaImagen;}
	public String getMapaImagen() {return MapaImagen;}
	public void setIdSeccionestacion(Double IdSeccionestacion) {this.IdSeccionestacion = IdSeccionestacion;}
	public Double getIdSeccionestacion() {return IdSeccionestacion;}
	public void setMapaId(Double MapaId) {this.MapaId = MapaId;}
	public Double getMapaId() {return MapaId;}
	public void setMapaAlto(Double MapaAlto) {this.MapaAlto = MapaAlto;}
	public Double getMapaAlto() {return MapaAlto;}
	public void setMapaAncho(Double MapaAncho) {this.MapaAncho = MapaAncho;}
	public Double getMapaAncho() {return MapaAncho;}
	public void setMapaCostado(String MapaCostado) {this.MapaCostado = MapaCostado;}
	public String getMapaCostado() {return MapaCostado;}
	public void setMapaPlacamalestado(Boolean MapaPlacamalestado) {this.MapaPlacamalestado = MapaPlacamalestado;}
	public Boolean getMapaPlacamalestado() {return MapaPlacamalestado;}
	public void setMapaPlacaperdidaelemento(Boolean MapaPlacaperdidaelemento) {this.MapaPlacaperdidaelemento = MapaPlacaperdidaelemento;}
	public Boolean getMapaPlacaperdidaelemento() {return MapaPlacaperdidaelemento;}
	public void setMapaPlacalegible(Boolean MapaPlacalegible) {this.MapaPlacalegible = MapaPlacalegible;}
	public Boolean getMapaPlacalegible() {return MapaPlacalegible;}
	public void setMapaEsquemaaveria(Boolean MapaEsquemaaveria) {this.MapaEsquemaaveria = MapaEsquemaaveria;}
	public Boolean getMapaEsquemaaveria() {return MapaEsquemaaveria;}
	public void setMapaEsquemacontaminacion(Boolean MapaEsquemacontaminacion) {this.MapaEsquemacontaminacion = MapaEsquemacontaminacion;}
	public Boolean getMapaEsquemacontaminacion() {return MapaEsquemacontaminacion;}
	public void setMapaEsquemalegible(Boolean MapaEsquemalegible) {this.MapaEsquemalegible = MapaEsquemalegible;}
	public Boolean getMapaEsquemalegible() {return MapaEsquemalegible;}
	public void setMapaRutaImagen(String MapaRutaImagen) {this.MapaRutaImagen = MapaRutaImagen;}
	public String getMapaRutaImagen() {return MapaRutaImagen;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}